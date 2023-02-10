(ns bhlie.train-time.views
  (:require [clojure.pprint :as pp]
            [shadow.css :refer (css)]
            [bhlie.train-time.rf :as rf :refer [<sub >evt]]
            [bhlie.train-time.times :refer [times]]))

(defn navbar []
  (let [tooltip (css :absolute :w-auto :p-2 :m-2 :min-w-max :left-14 :rounded-md :shadow-md
                     :text-white :bg-gray-900
                     :text-xs :font-bold
                     :transition-all :duration-100 :scale-0 :origin-left)]
    [:div {:class (css :bg-gray-500 :h-24 :flex :flex-col :justify-center
                       :items-center :fixed :top-0 :left-0 :h-screen :w-32
                       :shadow-lg)}
     [:nav
      (for [lnk ["Home"
                 "Train schedule"
                 "Plan route"]
            :let [idx (range (count lnk))]]
        [:i {:key idx
             :class (css :relative :flex :items-center :justify-center :mb-2
                         :bg-blue-500 :font-bold :border :rounded :p-1
                         [:hover :bg-blue-900]
                         [:hover :text-sky-500]
                         [:hover :rounded-3xl]
                         :transition-all :duration-300 :ease-linear)} lnk])]
     ]))

(defn schedule []
  [:div {:class (css :flex :justify-center)}
   [:div {:class (css :my-5)}
    [:h2 "Schedule for Rail Runner, southbound direction"]
    [:table {:class (css :rounded :m-3)}
     (into [:tbody {:class (css :border-emerald-200)}]
           (for [[stations times] times
                 :let [rows (concat [stations] times)]]
             [:tr {:class (css :border :border-emerald-50)}
              (map (fn [x] [:td {:class (css :m-3 :bg-blue-500 :border 
                                             :border-emerald-50 :p-5 :font-mono
                                             [:hover :text-sky-500]
                                             [:hover :bg-blue-900])} x]) rows)]))]]])

(defn main []
  [:<>
   [:header {:class (css :flex :justify-center :text-3xl)}
    [:h1 {:class (css :p-4 :hy-8 :font-mono)} "Schedule for the NM Rail Runner"]]
   [:main
    [navbar]
    [schedule]]
   [:footer]])
