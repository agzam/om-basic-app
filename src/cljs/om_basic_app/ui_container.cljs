(ns om-basic-app.ui-container
  (:require
   [om-basic-app.om-helpers :refer [reconciler read mutate]]
   [om.next :refer-macros [ui defui] :as om]
   [sablono.core :refer-macros [html] :as html]
   [om-basic-app.ledger-index]
   [taoensso.timbre :refer-macros [log info spy]]))

(def route->component
  {:default          om-basic-app.ledger-index/LedgerAccountIndexRoot
   [:accounts :system] om-basic-app.ledger-index/LedgerAccountIndexRoot})

(defui UiContainer
  static om/IQuery
  (query [this]
    [{:app/current-data []}])

  Object
  (render [this]
    (spy (om/props this))
    (html [:h1 "TODO: render real data of hosted component"])))

(def ui-container (om/factory UiContainer))
