 (ns SeqHorrible)



(defn shorrible
  ([num s] (shorrible num s 0))
  ([num s sum]   (seq (loop [todo s sum sum res []] (cond (number? (first todo)) (cond (> (+ sum (first todo)) num) res
                                                                                  :else (recur (next todo) (+ sum (first todo)) (conj res (first todo))))
                                                     (empty? todo) res
                                                     :else (let [subseq (shorrible num (first todo) sum)]
                                                             (recur (next todo) (apply + sum subseq) (conj res subseq )))
                                            )))
  ))




 (println (shorrible 7 [1 2 3]))

 (println (shorrible 9 (range)))

(println (shorrible 5 [1 2 [1 4]]))

