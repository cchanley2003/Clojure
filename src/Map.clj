 (ns Map)


 (defn newMap [f s]
   (loop [result (lazy-seq) toDo s]
     (if (empty? toDo)
       result
       (recur (conj result (f (first toDo)))  (rest toDo)))))


 (println (newMap inc [1 2 3 4]))

(println (->> (newMap inc (range))
     (drop (dec 1000000))
     (take 2)))