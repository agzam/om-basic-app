(ns om-basic-app.run
  (:require [om-basic-app.server :as server]
            [ring.adapter.jetty :as jetty])
  (:gen-class))

(defn -main [& _]
  (jetty/run-jetty server/app {:port 3000}))
