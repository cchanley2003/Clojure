 (ns PowerSet)

(require 'clojure.set)


; If set is empty return #{#{}}
; PowerSet(#{Set without first}) union (add first to every set in PowerSet(#{Set without first})

(defn addItemToAll [item setsOfSets] (into (map #(conj % item) setsOfSets) #{}))

(defn powerset [input] (cond (empty? input) #{#{}}
                            :else (let [e (first input) t (disj input e)]
                                    (clojure.set/union
                                      (powerset t)
                                      (into (map #(conj % e)  (powerset t)) #{})))))

 (println (conj #{} 1))
 (println (map #(conj % 1) #{#{}}))
 (println (addItemToAll 1 #{#{}}))
 (println "test")
 (println (powerset #{1 2 3}))