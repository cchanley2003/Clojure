 (ns Distinct)


(println (apply merge-with concat (map #(assoc {} (identity (first %)) %) (partition-by identity (range 50)))))

