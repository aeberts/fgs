(ns app.client
  (:require
    ;; the application itself
    [app.application :refer [app]]
    [app.ui :as ui]
    ;; the fulcro namespace for managing the app
    [com.fulcrologic.fulcro.application :as app]
    ))

(defn ^:export init
  "Shadow-cljs sets this up to be our entry-point function. See shadow-cljs.edn `:init-fn` in the modules of the main build."
  []
  (app/mount! app ui/Root "app")
  (js/console.log "Loaded"))

(defn ^:export refresh
  "During development, shadow-cljs will call this on every hot reload of source. See shadow-cljs.edn"
  []
  ;; re-mounting will cause forced UI refresh, update internals, etc.
  (app/mount! app ui/Root "app")
  (js/console.log "Hot reload")
  )