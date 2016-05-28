(ns om-basic-app.navbar
  (:require                             
   [om.next :refer-macros [ui defui] :as om]
   [om.dom :as dom]
   [sablono.core :refer-macros [html] :as html]
   [taoensso.timbre :refer-macros [log info spy]]
   [om-basic-app.parsing.navbar]
   [om-basic-app.om-helpers :refer [reconciler read mutate]]))

(defn sub-menu-item [item id]
  "rendering sub-menu item"
  (html [:li {:key      (str id "_" (:id item))
              :on-click #(om/transact! reconciler
                           `[(~'change-route-from-menu! {:parent-id ~id
                                                         :id        ~(:id item)})])}
         (:title item)]))

(defui TopNavSubmenu
  static om/Ident
  (ident [this {:keys [id]}]
    [:sub-menu/by-id id])

  static om/IQuery
  (query [this]
    '[{:app/active-top-nav-menu [:id :sub-menu]}])

  Object
  (render [this]
    (let [{:keys [id sub-menu] :as props} (om/props this)
          parent-id (when (some? props) (-> (om/get-ident this)
                                          (#(into {} [%]))
                                          :sub-menu/by-id))]
      (html [:div.top-submenu
             (when (some? sub-menu)
               [:ul (map #(sub-menu-item % id) sub-menu)])]))))

(defn menu-item [item currently-active]
  "rendering top menu item"
  (let [active (if (= (:id item) (:id currently-active)) "active" "")] 
    (html [:li.menu-item
           {:class active
            :on-mouse-over #(om/transact! reconciler `[(~'change-active-top-nav-menu! ~item)])
            :key           (get item :id)}
           (:title item)])))

(defui TopNavBar
  static om/IQuery
  (query [this]
    `[{:app/top-nav-menu [:app/top-nav-menu]}
      {:app/active-top-nav-menu ~(om/get-query TopNavSubmenu)}])

  Object
  (render [this]
    (let [{:keys [app/top-nav-menu app/active-top-nav-menu]} (om/props this)
          top-nav-submenu (om/factory TopNavSubmenu)]
      (html [:div.top-navbar
             [:div.content
              [:div.logo]
              [:div.top-menu
               [:ul
                (map #(menu-item % active-top-nav-menu) top-nav-menu)]]
              [:div.username]]
             (top-nav-submenu active-top-nav-menu)]))))
