 (ns Partition)


 (defn part [p s] (if (< (count s) p) '() (concat (list (take p s)) (part p (drop p s)))))

 (println (part 3 (range 9)))