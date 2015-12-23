 (ns Distinct)


(println (apply merge-with concat (map #(assoc {} (identity (first %)) %) (partition-by identity (range 50)))))


 (defn dist [x] (if (empty? x) [] (cons (first x) (dist (filter #(not= (first x) %) (rest x))))))


 (println (filter even? (rest [1])) )

 (println (dist [1 2 1 3 1 2 4]))

 (println (dist (range 50)))