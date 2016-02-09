 (ns EulersTotient)





(defn ET [n] (letfn [(gcd [x y ] (first (drop-while #(or (not= (rem x %) 0) (not= (rem  y %) 0)) (reverse (range 1  (inc (min x y)))))))](count (filter #(= (gcd % n) 1) (range (inc n))))))

(println (ET 10))

(println (ET 1))