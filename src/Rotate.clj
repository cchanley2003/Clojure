 (ns Rotate)


 (defn rotate [amount list]
   (if (= amount 0)
     list
     (if (< amount 0)
       (rotate (inc amount) (cons  (last list) (drop-last list)) )
       (rotate (dec amount) (conj (rest list) (first list))))))

(def input1 [1 2 3 4 5])

(println (rotate 2 input1))


