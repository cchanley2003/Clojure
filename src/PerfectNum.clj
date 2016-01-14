 (ns PerfectNum)

 (println (range 1 6))

 (defn perfNum [x] (= x (reduce + (filter #(= 0 (rem x %)) (range 1 x)))))

 (println (reduce + (filter #(= 0 (rem 6 %)) (range 1 6))))

 (println (perfNum 6))