 (ns Rotate)


 (defn rotate [amount ls]
   (if (= amount 0)
     ls
     (if (< amount 0)
       (rotate (inc amount) (cons  (last ls) (drop-last ls)) )
       (rotate (dec amount) (concat (rest ls) (list (first ls)))))))

(def input1 [1 2 3 4 5])

(println (rotate 2 input1))

 (println (concat (rest input1)  (list (first input1))))


