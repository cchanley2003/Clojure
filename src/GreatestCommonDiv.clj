 (ns GreatestCommonDiv)


 (println (reverse (range 1 6)))

 (defn gcd [x y ] (first (drop-while #(or (not= (rem x %) 0) (not= (rem  y %) 0)) (reverse (range 1  (inc (min x y)))))))

 (println (gcd 1023 858))

 (println (rem 1023 858))