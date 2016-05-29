(ns om-basic-app.app
  (:require                             
   [om.next :refer-macros [ui defui] :as om]
   [om.next.impl.parser :as om-parser]
   [om.dom :as dom]
   [sablono.core :refer-macros [html] :as html]
   [taoensso.timbre :refer-macros [log info spy]]
   [om-basic-app.om-helpers :refer [reconciler read mutate]]
   [om-basic-app.ui-container :refer [UiContainer ui-container route->component]]
   [om-basic-app.ledger-index]
   [om-basic-app.navbar :as navbar]))

(defmethod read :app/current-data
  [{:keys [state ast query]} key params]
  (when (not= query [{:app/current-data []}])
    {:remote (om-parser/join->ast query)}))

(defui App
  static om/IQuery
  (query [this]
    (let [sub-ref   (if (om/component? this)
                      (-> (om/props this) :app/current-route)
                      :default)
          sub-class (get route->component sub-ref)]
      `[{:app/main-menu ~(om/get-query navbar/TopNavBar)}
       {:app/current-route ~(om/subquery this sub-ref sub-class)}
       {:app/current-data ~(om/get-query UiContainer)}]))

  Object
  (render [this]
    (let [props  (om/props this) 
          navbar (om/factory navbar/TopNavBar)]
 
      (html [:div (navbar (:app/main-menu props))
             [:div (ui-container (:app/current-data props))]]))))
