 (ns GroupSeq)




 (defn groupSeq [func s]  (apply merge-with concat (map #(assoc {} (func (first %)) %) (partition-by func s))))

 (println  (groupSeq  #(> % 5) [1 3 6 8] ))

 (defn app [x] (apply / x))

 (println (partition-by app [[1 2] [2 4] [4 6] [3 6]]))

 (println (map #(assoc (array-map) (app (first %)) %) (partition-by app [[1 2] [2 4] [4 6] [3 6]])))

 (println (groupSeq #(apply / %) [[1 2] [2 4] [4 6] [3 6]]))

