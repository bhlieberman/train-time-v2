(ns bhlie.train-time.views
  (:require [shadow.css :refer (css)]
            [bhlie.train-time.rf :as rf :refer [<sub >evt]]))

(defn navbar []
  [:div {:class (css :bg-blue-500 :rounded :h-24 :flex :justify-center :items-center :mx-5)}
   [:nav
    (map (fn [link id] [:a {:key id
                            :class (css :m-1 :font-mono :font-medium :bg-slate-300 :rounded-full :p-5
                                        :text-sky-500)} link])
         ["Home"
          "Train schedule"
          "Plan route"] (range 3))]])

(defn schedule []
  [:div {:class (css :flex :justify-center)}
   [:table {:class (css :rounded)}
    (into [:tbody {:class (css :border-emerald-200)}] (for [i (range 5)]
                     [:tr i
                      (map (fn [x] [:td {:key x :class (css :m-3 :bg-blue-500
                                                            :border
                                                            :border-emerald-50
                                                            :p-5)} x]) (range 5))]))]])

(defn main []
  [:<>
   [:header {:class (css :flex :justify-center :text-3xl)}
    [:h1 {:class (css :p-4 :hy-8 :font-mono)} "Schedule for the NM Rail Runner"]]
   [:main
    [navbar]
    [schedule]]
   [:footer]])
