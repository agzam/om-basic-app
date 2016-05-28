(defproject agzam.om-basic-app "0.1.0-SNAPSHOT"
  :description "Basic app for learning Om Next"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.8.51"]

                 [com.stuartsierra/component "0.3.1"]
                 [figwheel-sidecar "0.5.0-SNAPSHOT" :scope "provided"]
                 [inflections "0.12.1"]
                 [com.taoensso/timbre "4.3.1"] 
                 [environ "1.0.3"]

                 [ring "1.4.0"]
                 [ring/ring-defaults "0.2.0"]
                 [ring-middleware-format  "0.7.0"]
                 [prone "1.1.1"]
                 [bidi "2.0.9"]
                 [yada "1.1.11"]
                 [aleph "0.4.2-alpha3"]

                 [com.cognitect/transit-clj "0.8.285"]
                 [com.cognitect/transit-cljs "0.8.237"]

                 [org.omcljs/om "1.0.0-alpha36"]
                 [cljsjs/react "15.0.2-0"]
                 [hiccup "1.0.5"]
                 [sablono "0.7.1" :exclusions [cljsjs/react]]]

  :plugins [[lein-npm "0.6.2"]
            [lein-cljsbuild "1.1.3"]
            [lein-ring "0.9.7"]]

  :ring {:handler om-basic-app.server/app}
  :main om-basic-app.run
  :uberjar-name "om-basic-app.jar"
  :target-path "target/%s"

  :profiles {:dev {:source-paths ["dev" "src/clj" "src/cljs" "src/cljc" "test/cljc" "test/clj"]
                   :dependencies [[com.cemerick/piggieback "0.2.2-SNAPSHOT"]
                                  [devcards "0.2.1-7" :scope "provided" :exclusions [cljsjs/react]]]
                   :repl-options {:init-ns          user
                                  :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]
                                  :port             7001}}
             :uberjar {:source-paths ["src/clj" "src/cljc"]
                       :prep-tasks ["compile" ["cljsbuild" "once" "dev"]]
                       :aot :all}}

  :cljsbuild {:builds {:dev {:source-paths ["src/cljs"]
                             :compiler           {:main       om-basic-app.core
                                                  :asset-path "js/out"
                                                  :output-to  "resources/public/js/main.js"
                                                  :output-dir "resources/public/js/out"
                                                  :optimizations :none
                                                  :verbose    true}}}}

  :npm {:dependencies [[font-awesome "4.6.1"]]
        :root         "resources/public/"})
