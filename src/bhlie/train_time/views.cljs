(ns bhlie.train-time.views
  (:require [clojure.pprint :as pp]
            [shadow.css :refer (css)]
            [bhlie.train-time.rf :as rf :refer [<sub >evt]]
            [bhlie.train-time.times :refer [times]]))

(defn navbar []
  [:div {:class (css :bg-blue-500 :rounded :h-24 :flex :justify-center :items-center :mx-5)}
   [:nav
    (map (fn [link id] [:a {:key id
                            :class (css :m-1 :font-mono :font-medium :bg-slate-300 :rounded-full :p-5
                                        :text-sky-500 :ring
                                        :ring-red-800)} link])
         ["Home"
          "Train schedule"
          "Plan route"] (range 3))]])

(defn schedule []
  [:div {:class (css :flex :justify-center)}
   [:div {:class (css :my-5)}
    [:h2 "Schedule for Rail Runner, southbound direction"]
    [:table {:class (css :rounded :m-3)}
     (into [:tbody {:class (css :border-emerald-200)}]
           (for [[stations times] times
                 :let [rows (concat [stations] times)]]
             [:tr {:class (css :border :border-emerald-50)}
              (map (fn [x] [:td {:class (css :m-3 :bg-blue-500
                                             :border
                                             :border-emerald-50
                                             :p-5
                                             :font-mono
                                             [:hover :text-sky-500])} x]) rows)]))]]])

(defn main []
  [:<>
   [:header {:class (css :flex :justify-center :text-3xl)}
    [:h1 {:class (css :p-4 :hy-8 :font-mono)} "Schedule for the NM Rail Runner"]]
   [:main
    [navbar]
    [schedule]]
   [:footer]])
