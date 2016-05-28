(ns om-basic-app.server
  (:require [clojure.data.json :as json]
            [ring.middleware.defaults :refer [api-defaults wrap-defaults]]
            [ring.middleware.format :as fmt]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.util.http-response :refer [ok header resource-response] :as resp]
            [prone.middleware :refer [wrap-exceptions]]
            [taoensso.timbre :as log]
            [cognitect.transit :as transit]
            [environ.core :refer [env]]
            [bidi.ring :refer [make-handler]]
            [om.next.server :as om]
            [om-basic-app.pages :as pages]
            [om-basic-app.data :as data])
  (:import [java.io ByteArrayOutputStream ByteArrayInputStream]))

(def transit #{"application/transit+msgpack"
              "application/transit+json;q=0.9"})

(defmulti readf om/dispatch)

(defmethod readf :app/current-data [{:keys [query] :as env} k params])

(defmethod readf :ledger/resources [env k params]
  "emulating grabbing data from database applying specified filter"
  {:value (filter #(= (% :account-type) :nominal) data/ledger-items)})

(defmethod readf :ledger/requirements [env k params]
  "emulating grabbing data from database applying specified filter"
  {:value (filter #(= (% :account-type) :real) data/ledger-items)})

(defn log-request [handler]
  (fn [request]
      (log/info request)
    (handler request)))

(defn content-type [cnt ctype]
  (let [c (get {:html    "text/html; charset=UTF-8"
                :css     "text/css; charset=UTF-8"
                :js      "application/javascript; charset=UTF-8"
                :json    "application/json; charset=UTF-8"
                :transit "application/transit+json; charset=UTF-8"
                :font    "font/opentype"} ctype
               (name ctype))]
    (resp/content-type cnt c)))

(defn fonts [req]
  "Serving Font-Awesome by redirecting to node_modules folder"
  (let [new-p (str "/node_modules/"
                (if (re-find #"fontawesome" (req :uri))
                  "font-awesome/fonts/"
                  "fonts/")
                 (-> req :route-params :path))]
    (-> (resource-response new-p {:root "public"})
      (content-type :font))))

(defn main-css [req]
  (-> (resource-response "main.css" {:root "public"})
      (content-type :css)))

(defn main-js [req]
  (let [path (-> req :route-params :path)]
    (-> (resource-response path {:root "public/js"})
        (content-type :js))))

(defn serve-index [_]
  (-> (pages/index-page) (ok) (content-type :html)))

(defn not-found [req]
  (-> (pages/not-found) (resp/not-found) (content-type :html)))

(defn transit-write [clj-obj]
  (let [out-stream (ByteArrayOutputStream.)]
    (transit/write (transit/writer out-stream :json) clj-obj)
    (.toString out-stream)))

(def parser (om/parser {:read readf :mutate nil}))

(defn om-query-resource [req]
  (let [msg (transit/read (transit/reader (:body req) :json))
        parsed (parser nil (:remote msg))]
    (-> parsed transit-write ok (content-type :transit))));

(def routes ["/" [["" {:get serve-index}]
                  ["main.css" {:get main-css}]
                  [["js/" [#".*$" :path]] {:get main-js}]
                  [["fonts/" [#".*$" :path]] {:get fonts}]
                  ["ledger-data" {:post om-query-resource}]
                  [true   {:get not-found}]]])

(def app
  (let [handler (-> routes
                  (make-handler)
                  (wrap-defaults api-defaults)
                  #_log-request)]
    (if (env :dev)
      (-> handler
        wrap-exceptions
        wrap-reload)
      handler)))
