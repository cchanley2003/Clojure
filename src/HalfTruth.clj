 (ns HalfTruth)


 (defn halftruth [& bools] (== 2 (count (set bools))))


 (println (halftruth false true false))