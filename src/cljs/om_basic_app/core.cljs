(ns om-basic-app.core
  (:require [goog.dom :as gdom]
            [om.next :as om :refer-macros [defui]]
            [om.dom :as dom]
            [cognitect.transit :as transit]
            [sablono.core :refer-macros [html]]
            [om-basic-app.om-helpers :refer [reconciler read mutate]]
            [taoensso.timbre :as timbre :refer-macros [log spy]]
            [om-basic-app.ledger-index :refer [LedgerAccountIndexRoot]]
            [om-basic-app.app :as app]))

(enable-console-print!)

(defmethod read :root-data
  [{:keys [parser query ast target state] :as env} key _]
  (let [remote (parser env query target)
        st     @state]
    (if (and target (not-empty remote))
      {:remote (update-in ast [:query] (fn [query] remote))}
      (when (some? (key @state))
        {:value (key @state)}))))

(defui SuperRoot
  static om/IQuery
  (query [this]
    [{:root-data (om/get-query LedgerAccountIndexRoot)}])

  Object
  (render [this]
    (let [{:keys [root-data]} (om/props this)
          ledger-account-index-root (om/factory LedgerAccountIndexRoot)]
      (html [:div (ledger-account-index-root root-data)]))))

;; (om/add-root! reconciler om-basic-app.ledger-index/LedgerAccountIndexRoot (gdom/getElement "app"))
(om/add-root! reconciler SuperRoot (gdom/getElement "app"))
