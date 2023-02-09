(ns bhlie.train-time.main
  (:require
   [reagent.dom :as rdom]
   [re-frame.core :as re-frame]
   [bhlie.train-time.rf :as rf :refer [<sub >evt >evt-now]]
   [bhlie.train-time.views :as views]
   [bhlie.train-time.config :as config]))

(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (re-frame/clear-subscription-cache!)
  (let [root (.getElementById js/document "app")]
    (rdom/unmount-component-at-node root)
    (rdom/render [views/main] root)))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn init []
  (>evt-now [::rf/boot])
  (dev-setup)
  (mount-root))
