(ns ConnectedGraph)

(def input1 #{[1 2] [2 3] [3 1] [4 5] [5 6] [6 4]})

;(def candidate (first (first input1)))

;(println candidate)

;(def nodes (into [] (disj (reduce #(into %1 %2) #{} input1) candidate)))

;(println nodes)

;(defn getNext [s x] (into s (filter #(some #{x} %1) input1)))

;(defn nextLevel [level visited] (apply disj (into #{} (flatten (reduce getNext [] level))) (into level visited)))

;(defn connectedPair? [root cand graph] (loop [visited #{cand} next #{cand}] (cond
;                                               (empty? (nextLevel next visited)) false
;                                               (some #{root} (nextLevel next visited)) true
;                                               :default (recur (into visited next) (nextLevel next visited)))))

(defn connected? [graph] (let [candidate (first (first graph))
                               nodes (into [] (disj (reduce #(into %1 %2) #{} graph) candidate))
                               getNext (fn [s x] (into s (filter #(some #{x} %1) graph)))
                               nextLevel (fn [level visited] (apply disj (into #{} (flatten (reduce getNext [] level))) (into level visited)))
                               connectedPair? (fn [root cand] (loop [visited #{cand} next #{cand}] (cond
                                                                                                             (empty? (nextLevel next visited)) false
                                                                                                             (some #{root} (nextLevel next visited)) true
                                                                                                             :default (recur (into visited next) (nextLevel next visited)))))

                               ] (if (= 1 (count graph)) true (every? #(connectedPair? candidate %1) nodes))))

(println (connected? input1))

