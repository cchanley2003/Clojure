 (ns Map)


(defn newMap [f s] (if (empty? s) (lazy-seq) (lazy-cat (lazy-seq (list (f (first s)))) (newMap f (rest s)))))


 (println (newMap inc [1 2 3 4]))

(println (->> (newMap inc (range))
     (drop (dec 1000000))
     (take 2)))