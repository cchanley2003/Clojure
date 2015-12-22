 (ns DotProduct)

(defn dot [x y] (reduce + (map * x y)))

 (println (dot [1 0 1] [0 1 0]))