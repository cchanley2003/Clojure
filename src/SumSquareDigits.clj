 (ns SumSquareDigits)

 (defn numToDigits [x] (if (< x 10) [x] (conj  (numToDigits (int (/ x 10))) (rem x 10))))



 (println (> (reduce #(+ (* %2 %2) %1) (numToDigits 15)) 15))


 (defn sumSquare [x]
   (count (filter #(= % 1) (map
     (fn [y]
       (if (> (reduce #(+ (* %2 %2) %1) 0 (numToDigits y)) y)
         1
         -1))
     x))))


(defn numbers [x]
  (map
    (fn [y] (reduce #(+ (* %2 %2) %1) 0 (numToDigits y)))
    x))


 (println (numbers (range 10)))

(println (sumSquare (range 10)))

 (println (numToDigits 15))

 (println (numToDigits 10))