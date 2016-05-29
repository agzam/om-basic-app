(ns om-basic-app.om-helpers
  (:require
   [om.next :as om]
   [taoensso.timbre :as timbre :refer-macros [log spy]]
   [cognitect.transit :as transit]))

(defmulti read om/dispatch)
(defmulti mutate om/dispatch)

(defn send [{:keys [remote] :as queries} cb]
   (let [xhr          (new js/XMLHttpRequest)
         {:keys [query rewrite]} (om/process-roots remote)
         request-body (transit/write (transit/writer :json) {:remote query})]

     (.open xhr "POST" "/ledger-data")
     (.setRequestHeader xhr "Content-Type" "application/transit+json")
     (.setRequestHeader xhr "Accept" "application/transit+json")
     (.addEventListener
       xhr "load"
       (fn [evt]
         (let [response (transit/read (transit/reader :json)
                          (.. evt -currentTarget -responseText))
               restructured-response (rewrite response)]
           (cb restructured-response))))
     (.send xhr request-body)))

(def reconciler
  (om/reconciler
    {:state   nil 
     :parser  (om/parser {:read   read
                          :mutate mutate})
     :send    send 
     :merge-tree (fn [a b] (merge a b))
     :remotes [:remote]}))

