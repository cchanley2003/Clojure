 (ns SeqRed)

 (println (+ 1))

 (println (empty? (rest [1])))

 (println (reduce + [1]))

 (println (second [1]))
 (println (lazy-seq [1]))

 (defn newReductions
   ([f c] (newReductions f (first c) (rest c)))
   ([f i c] (cond
               (empty? c) (lazy-seq [i])
               :else (lazy-cat (lazy-seq [i]) (newReductions f (f i (first c)) (rest c))))))

(println (newReductions + [1 2 3]))