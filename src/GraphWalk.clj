 (ns GraphWalk)

(defn addVisited [visited edge] (conj (conj visited edge) [(second edge) (first edge)]))

(println (addVisited #{} '[a b]))

(defn getCandidates [node unvisited] (filter (fn [x] (some #(= node %) x)) unvisited))

(defn getUnvisited [graph visited] (filter #(not (contains? visited %)) graph))

(defn nextNode [edge prevNode] (if (= (first edge) prevNode) (second edge) (first edge)))

(defn walkGraph [graph] (letfn [
                                (addVisited [visited edge] (conj (conj visited edge) [(second edge) (first edge)]))
                                (getCandidates [node unvisited] (filter (fn [x] (some #(= node %) x)) unvisited))

                                (getUnvisited [graph visited] (filter #(not (contains? visited %)) graph))

                                (nextNode [edge prevNode] (if (= (first edge) prevNode) (second edge) (first edge)))
                                (tryCandidate [node graph visited] (let [unvisisted (getUnvisited graph visited)]
                                                                          (loop [todo (getCandidates node unvisisted)] (cond
                                                                                                                         (empty? unvisisted) true
                                                                                                                         (empty? todo) false
                                                                                                                         (tryCandidate (nextNode (first todo) node) graph (addVisited visited (first todo))) true
                                                                                                                         :else (recur (rest todo))
                                                                                                                         )
                                                                                                                       )))
                                ]

                          (if (not (= (count graph) (count (into #{}(map #(into #{} %) graph)))))
                            false
                            (tryCandidate (first (first graph)) graph #{(first graph)})
                            )))





;(loop [node (first (first graph)) visited #{}]
;  (let [unvisited (getUnvisited graph visited)
;        nextCandidate (first (getCandidates node unvisited))
;        nn (nextNode nextCandidate node)]
;    (cond
;      (empty? unvisited) true
;      (nil? nextCandidate) false
;      :else (recur nn (addVisited visited nextCandidate))
;      )

;println (walkGraph [[1 1] [2 2]]))

(println  (walkGraph [[:a :b] [:a :b] [:a :c] [:c :a]
           [:a :d] [:b :d] [:c :d]]))
(println (walkGraph [[:a :b] [:a :c] [:c :b] [:a :e]
                     [:b :e] [:a :d] [:b :d] [:c :e]
                     [:d :e] [:c :f] [:d :f]]))

(println (walkGraph [[1 2] [2 3] [3 4] [4 1]]))

(println (walkGraph [[1 2] [2 3] [2 4] [2 5]]))

