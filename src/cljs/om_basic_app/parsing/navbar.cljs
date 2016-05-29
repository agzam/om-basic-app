(ns om-basic-app.parsing.navbar
  (:require
   [om-basic-app.om-helpers :refer [reconciler read mutate]]
   [om-basic-app.ui-container :refer [UiContainer ui-container route->component]]
   [om.next :refer-macros [ui defui] :as om]
   [taoensso.timbre :refer-macros [log info spy]]))

(def top-nav-menu [{:id       :accounts :title "Accounts"
                    :sub-menu [{:id :customer :title "Customer"}
                               {:id :system :title "System"}
                               {:id 2 :title "Nunc porta vulputate tellus"}]}

                   {:id       :treasury :title "Nam vestibulum"
                    :sub-menu [{:id 0 :title "Etiam laoreet quam sed arcu"}
                               {:id 1 :title "Nam a sapien"}
                               {:id 2 :title "Etiam laoreet quam sed arcu"}
                               {:id 3 :title "Nunc eleifend leo vitae magna"}
                               {:id 4 :title "Cum sociis"}]}

                   {:id       :servicing :title "Pellentesque tristique"
                    :sub-menu [{:id 0 :title "Donec pretium"}
                               {:id 1 :title "Nam vivamus id enim"}
                               {:id 2 :title "Nunc etiam laoreet quam sed arcu"}
                               {:id 3 :title "Cum vestibulum accumsan nisl"}]}

                   {:id       :approvals :title "Nulla posuere"
                    :sub-menu [{:id 0 :title "Aenean in sem ac leo mollis blandit."}
                               {:id 1 :title "Nunc porta vulputate tellus"}
                               {:id 2 :title "Nunc eleifend leo vitae magna"}
                               {:id 3 :title "Nullam rutrum"}]}])

(defmethod read :app/top-nav-menu
  [{:keys [state]} _ _]
  (let [v (get @state :app/top-nav-menu)]
    {:value (if (empty? v) top-nav-menu v)}))

(defmethod read :app/main-menu
  [{:keys [state query]} key _]
  (let [st @state
        v (get st :app/top-nav-menu)]
    {:value {:app/top-nav-menu (if (empty? v) top-nav-menu v)
             :app/active-top-nav-menu (get st :app/active-top-nav-menu)}}))

(defmethod read :app/active-top-nav-menu
  [{:keys [state]} _ _]
  {:value (get @state :app/active-top-nav-menu)})

(defmethod mutate 'change-active-top-nav-menu!
  [{:keys [state]} key props]
  {:action #(swap! state assoc :app/active-top-nav-menu props)})

(defmethod mutate 'change-route-from-menu!
  [{:keys [state]} key {:keys [parent-id id]}]
  (let [new-route (conj [] parent-id id)]
    {:action (fn [] (
                     (swap! state assoc
                       :app/active-top-nav-menu nil 
                       :app/current-route new-route)))}))

(defmethod read :app/current-route
  [{:keys [state]} _ _]
  (let [r (get @state :app/current-route :default)]
    {:value r}))
