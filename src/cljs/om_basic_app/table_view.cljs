(ns om-basic-app.table-view
  (:require [goog.dom :as gdom]
            [om.next :as om :refer-macros [defui]]
            [om.dom :as dom]
            [sablono.core :refer-macros [html]]
            [om-basic-app.om-helpers :refer [reconciler read mutate]]))

(defmulti render-data (fn [x & _] x))
(defmethod render-data :default
  [_ s]
  (str s))

(defn render-table-header [column-spec]
  [:div.thead
   [:div.tr
    (mapv (fn [{:keys [id title is-visible]
                :or {is-visible true}}]
            ;; TODO: better display of column name
            (when is-visible
              [:div.th (or title (name id))]))
          column-spec)]])

(defn render-row [column-spec row]
  [:div.tr
   (mapv (fn [{:keys [id type is-visible]
               :or   {is-visible true}}]
           (when is-visible
             [:div.td (render-data type (get row id))]))
         column-spec)])

(defn render-table-body [column-spec rows]
  [:div.tbody
   (mapv (partial render-row column-spec) rows)])

(defn table-view [column-spec rows]
  (html
   [:div.table
    (render-table-header column-spec)
    (render-table-body column-spec rows)]))
