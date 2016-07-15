 (ns minPath)

(defn minPath [input] (let [triangle (into [] input)] (letfn [

                               (score [node orig] (get (get orig (first node)) (second node)))
                               (addAdjacents [path] (loop [toAdd (adjacents (last path)) res []] (if (empty? toAdd) res (recur (rest toAdd) (cons (conj path (first toAdd)) res)))))
  (adjacents [node] (list (list (inc (first node)) (second node)) (list (inc (first node)) (inc (second node)))))
  (addAllAdjacents [paths] (loop [toAdd paths res []] (if (empty? toAdd) res (recur (rest toAdd) (concat res (addAdjacents (first toAdd)))))))
  (generatePaths [triangle] (loop [res [['(0 0)]]] (if (= (first (last (first res)))
                                                          (dec (count triangle)))
                                                     res
                                                     (recur (addAllAdjacents res)))))

]
(apply min
       (map (fn [l] (apply + (map (fn [x] (score x triangle)) l))) (generatePaths triangle))))))




;(def simple [[1] [2 4] [5 1 4] [2 3 4 5]])
;(println (minPath simple))

(def simple2 '([1]
   [2 4]
   [5 1 4]
   [2 3 4 5]))

(println (minPath simple2))

(println (reduce
  (fn [a v] (println a v) (map min
                 (map + (cons Double/POSITIVE_INFINITY a) v)
                 (map + (concat a [Double/POSITIVE_INFINITY]) v)))
   simple2))

(println (map + (cons Double/POSITIVE_INFINITY '(3 5)) [5 1 4]))

(println (map min [1 2 3 4] [5 4 3 1]))