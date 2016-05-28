(ns om-basic-app.om-helpers
  (:require
   [om.next :as om]
   [taoensso.timbre :as log]
   [cognitect.transit :as transit]))

(defmulti read om/dispatch)
(defmulti mutate om/dispatch)

(defn send [m cb]
  (let [xhr          (new js/XMLHttpRequest)
        request-body (transit/write (transit/writer :json) m)]
    (.open xhr "POST" "/ledger-data")
    (.setRequestHeader xhr "Content-Type" "application/transit+json")
    (.setRequestHeader xhr "Accept" "application/transit+json")
    (.addEventListener
      xhr "load"
      (fn [evt]
        (let [response (transit/read (transit/reader :json)
                         (.. evt -currentTarget -responseText))]
          (cb response))))
    (.send xhr request-body)))

(def reconciler
  (om/reconciler
    {:state   nil 
     :parser  (om/parser {:read   read
                          :mutate mutate})
     :send    send 
     :remotes [:remote]}))

