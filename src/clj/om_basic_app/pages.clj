(ns om-basic-app.pages
  (:require [hiccup.core :refer [html]]))


(defn header []
  [:title "Om basic App"]
  [:head
   [:meta {:charset "UTF-8"}]
   [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]
   [:link {:href "/main.css" :rel "stylesheet" :type "text/css"}]
   #_[:link {:href "/images/favicon.ico" :type "image/x-icon" :rel "icon"}]])

(defn index-page []
  (html
    [:html
     (header)
     [:body
      [:div {:id "app"}]
      [:script {:type "text/javascript" :src "/js/out/goog/base.js"}]
      [:script {:type "text/javascript" :src "/js/main.js"}]]]))
    
(defn not-found []
  (html
    [:html
     (header)
     [:body
      [:h1 "Rats! Page not found"]]]))
