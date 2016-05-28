(ns om-basic-app.core
  (:require [goog.dom :as gdom]
            [om.next :as om :refer-macros [defui]]
            [om.dom :as dom]
            [cognitect.transit :as transit]
            [sablono.core :refer-macros [html]]
            [om-basic-app.om-helpers :refer [reconciler read mutate]]
            [taoensso.timbre :as timbre :refer-macros [log spy]]
            [om-basic-app.app :as app]))

(enable-console-print!)

(om/add-root! reconciler om-basic-app.app/App (gdom/getElement "app"))
