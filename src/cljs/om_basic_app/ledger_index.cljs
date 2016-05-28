(ns om-basic-app.ledger-index
  (:require [goog.dom :as gdom]
            [om.next :as om :refer-macros [ui defui]]
            [om.dom :as dom]
            [sablono.core :refer-macros [html]]
            [om-basic-app.om-helpers :refer [reconciler read mutate]]
            [om-basic-app.table-view :as table-view]
            [taoensso.timbre :as log]))

(def ledger-table-columns
  [{:id        :id
    :type      :guid
    :is-visible false}
   {:id     :created
    :title  "Created"
    :type   :datetime
    :filter {:type :daterange}}
   {:id     :credit
    :title  "Credit"
    :type   :number
    :filter {:type :range}}
   {:id     :debit
    :title  "Debit"
    :type   :number
    :filter {:type :range}}
   {:id     :description
    :title  "Description"
    :type   :string
    :filter {:type :text}}
   {:id     :customer-id
    :title  "Customer ID"
    :type   :uuid
    :filter {:type :string}}])

(defn- update-ledger-account-item-data [ctx data ev]
  (.preventDefault ev)
  (om/transact! ctx `[(~'change-ledger-item-data! ~data)]))

(defui LedgerAccountItemData
  static om/IQuery
  (query [this]
    '[:ledger/account-item-data])

  Object
  (render [this]
    (let [props (om/props this)]
      (html
       [:div.ledger-account-item-data
        [:button.back
         {:on-click #(update-ledger-account-item-data reconciler `[:ledger/account-item-data nil] %)}
         "back"]
        (table-view/table-view ledger-table-columns props)]))))

(defmethod read :ledger/account-item-data
  [{:keys [state ast] :as env} key params]
  {:value (get @state key)})

(def ledger-account-item-data (om/factory LedgerAccountItemData))

(defmethod mutate 'change-ledger-item-data!
  [{:keys [state]} key {:keys [ledger/account-item-data] :as props}]
  {
   :value  {:keys [:ledger/account-item-data]}
   :action #(swap! state assoc :ledger/account-item-data account-item-data)})

(defui LedgerAccountItem
  static om/Ident
  (ident [this {:keys [id]}]
    [:ledger-item/by-id id])

  static om/IQuery
  (query [this]
    [:id :description :account-type :account-item-data])

  Object
  (render [this]
    (let [{:keys [id description account-item-data] :as props} (om/props this)]
      (html [:li.ledger-account-item
             {:on-click #(update-ledger-account-item-data reconciler `[:ledger/account-item-data ~account-item-data] %)}
             (str description)]))))

(def ledger-item (om/factory LedgerAccountItem {:keyfn :id}))

(def ledger-items-list (om/factory
                         (ui 
                           Object
                           (render [this]
                             (let [{:keys [items title]} (om/props this)]
                               (html [:div.list-view
                                      [:div.header title]
                                      [:ul.content (map ledger-item items)]]))))))

(defui LedgerAccountIndexRoot
  static om/IQuery
  (query [this]
    (let [subq (om/get-query LedgerAccountItem)]
      `[{:ledger/resources ~subq}
        {:ledger/requirements ~subq}
        {:ledger/account-item-data ~(om/get-query LedgerAccountItemData)}]))

  Object
  (render [this]
    (let [{:keys [ledger/resources ledger/requirements ledger/account-item-data] :as props} (om/props this)]
      (html [:div
             (if (empty? account-item-data)
               [:div.ledger-resources-index-view
                [(ledger-items-list {:items resources :title "resources"})]
                [(ledger-items-list {:items requirements :title "requirements"})]]
               [:div
                (ledger-account-item-data (:ledger/account-item-data props))])]))))

(defn get-ledger-items [state key {:keys [account-type] :as params}]
  (let [st @state]
    (->> (get st key)
      (reduce (fn [a n]
                (as-> (get-in st n) cur
                  (if (or (nil? account-type)
                        (= (:account-type cur) account-type))
                    (conj a cur) a))) []))))

(defmethod read :ledger/requirements
  [{:keys [state ast] :as env} key params]
  (let [st  @state
        lis (get st key)]
    
    (if (empty? lis)
      {:remote ast}
      {:value lis})))

(defmethod read :ledger/resources
  [{:keys [state ast query] :as env} key params]
  (let [st  @state
        lis (get st key)]
    
    (if (empty? lis)
      {:remote ast}
      {:value lis})))
