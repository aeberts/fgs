(ns app.ui
  (:require
    [com.fulcrologic.fulcro.components :as comp :refer [defsc]]
    [com.fulcrologic.fulcro.dom :as dom :refer [div p ul h4]]))

;(defsc Cars [this {:cars/id [name]}]
;  {:query [:cars/id [:cars/name :cars/model]]})

(defsc Person [this {:person/keys [id name age] :as props}]
  {:query         [:person/id :person/name :person/age]
   :ident         (fn [] [:person/id (:person/id props)])
   :initial-state (fn [{:keys [id name age] :as params}] {:person/id id :person/name name :person/age age})}
  (div
    (p "Name: " name)
    (p "Age: " age)))

(def ui-person (comp/factory Person {:keyfn :person/id}))

(defsc PersonList [this {:list/keys [id label people] :as props}]
  {:query         [:list/id :list/label {:list/people (comp/get-query Person)}]
   :ident         (fn [] [:list/id (:list/id props)])
   :initial-state (fn [{:keys [id label]}]
                    {:list/id    id
                     :list/label label
                     :list/people
                                 (if (= id :friends)
                                   [(comp/get-initial-state Person {:id 1 :name "Bob" :age 23})
                                    (comp/get-initial-state Person {:id 2 :name "Mike" :age 32})]
                                   [(comp/get-initial-state Person {:id 3 :name "Eric" :age 34})
                                    (comp/get-initial-state Person {:id 4 :name "Malfoy" :age 25})])})}
  (div
    (h4 label)
    (ul
      (map ui-person people))))

(def ui-person-list (comp/factory PersonList))

(defsc Root [this {:keys [friends enemies]}]
  {:query         [{:friends (comp/get-query PersonList)}
                   {:enemies (comp/get-query PersonList)}]
   :initial-state (fn [params]
                    {:friends (comp/get-initial-state PersonList {:id :friends :label "Friends"})
                     :enemies (comp/get-initial-state PersonList {:id :enemies :label "Enemies"})
                     })}
  (div
    (ui-person-list friends)
    (ui-person-list enemies)))

(comment

  )