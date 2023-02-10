(ns core
  (:require [clojure.edn :as edn]
            [clojure.data.json :as json]
            [clojure.test :refer [deftest is testing run-tests with-test]]
            [clojure.repl :refer [doc]]
            [clojure.data.priority-map :refer [priority-map]]
            #_[tick.core :as t]
            #_[tick.alpha.interval :as t.i]))

(def time-table (edn/read-string (slurp "times.edn")))

(def times (->> [:weekday :southbound] 
      (get-in time-table)
      (partition 2)
      (apply map vector)))