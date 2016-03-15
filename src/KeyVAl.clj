 (ns KeyVal)


 (println (take-while #(number? %) '(:a :b)))
 (defn kv [s] (if (empty? s) {} (conj (kv (drop-while #(number? %) (rest s)) ) {(first s) (take-while #(number? %) (rest s))})))

 (println (kv []))

 (println (kv [:a 1]))

 (println (kv [:a 1 2 3 :b :c 4]))

 (println (kv [:a 1, :b 2]))