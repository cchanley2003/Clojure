 (ns CountOccurs)

 (def input1 [1 1 2 3 2 1 1])

 (def f (group-by identity input1))

 (println (apply merge (map  #(assoc {} (count %) (first %)) (vals f))))

(defn co [input] (apply merge (map #(assoc {} (first %) (count %)) (vals (group-by identity input)))))

(println (co input1))

