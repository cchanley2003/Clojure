 (ns SeqHorrible)



(defn shorrible
  ([num s] (shorrible num 0 s))
  ([num sum s]   (loop [todo s sum sum res []] (cond (number? (first todo)) (cond (> (+ sum (first todo)) num) res
                                                                                  :else (recur (next todo) (+ sum (first todo)) (conj res (first todo))))
                                                     (empty? todo) res
                                                     :else (let [subseq (shorrible num sum (first todo))]
                                                             (recur (next todo) (apply + sum (flatten subseq)) (conj res subseq )))
                                            ))
  ))




 (println (shorrible 7 [1 2 3]))

 (println (shorrible 9 (range)))

(println (shorrible 5 [1 2 [1 4]]))

(println (shorrible  10 [1 2 [3 [4 5] 6] 7]))

(println (=  (shorrible 10 [1 2 [3 [4 5] 6] 7])
    '(1 2 (3 (4)))))


