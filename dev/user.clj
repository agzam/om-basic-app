(require
 '[figwheel-sidecar.repl-api :as ra]
 '[com.stuartsierra.component :as component])

(import 'java.lang.Runtime)

(def figwheel-config
  {:figwheel-options {:server-port 3333
                      :css-dirs ["resources/public"]
                      :ring-handler 'om-basic-app.server/app}
   :build-ids ["dev"]
   :all-builds
   [{:id "dev"
     :figwheel true
     :source-paths ["src"]
     :compiler {:main "om-basic-app.core"
                :asset-path "js/out"
                :output-to "resources/public/js/main.js"
                :output-dir "resources/public/js/out"
                :verbose true}}]})

(def sass-config
  {:executable-path "sass -r sass-globbing" 
   :input-file "src/sass/main.sass" 
   :output-file "resources/public/main.css"})

(defrecord Figwheel []
  component/Lifecycle
  (start [config]
    (ra/start-figwheel! config)
    config)
  (stop [config]
    (ra/stop-figwheel!)
    config))

(defrecord SassWatcher [executable-path input-file output-file]
  component/Lifecycle
  (start [config]
    (if (not (:sass-watcher-process config))
      (do
        (println (str "Figwheel: Starting SASS watch process for " input-file))
        (assoc config :sass-watcher-process
               (.exec (Runtime/getRuntime)
                      (str executable-path " --watch " input-file ":" output-file))))
      config))
  (stop [config]
    (when-let [process (:sass-watcher-process config)]
      (println "Figwheel: Stopping SASS watch process")
      (.destroy process))
    config))

(def system
  (atom
   (component/system-map
    :figwheel (map->Figwheel figwheel-config)
    :sass (map->SassWatcher sass-config))))

(defn start []
  (swap! system component/start))

(defn stop []
  (swap! system component/stop))

(defn reload []
  (stop)
  (start))

(defn repl []
  (ra/cljs-repl))
