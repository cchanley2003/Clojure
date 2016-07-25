 (ns Intervals)

(def input [1 1 2 3 6 5 8])

(defn getEndPoints [x] (letfn [(getIntervals [is]
                                 (loop [res [] todo is]
                                   (if (empty? todo)
                                     res
                                     (let [intvlTuple (getInterval todo)] (recur (conj res (first intvlTuple)) (second intvlTuple))))))
                               (getInterval [i]
                                 (loop [newInterval [] remainder i] (cond
                                                                      (empty? remainder) (list newInterval remainder)
                                                                      (empty? newInterval) (recur (conj newInterval (first remainder)) (rest remainder))
                                                                      (= (inc (last newInterval)) (first remainder)) (recur (conj newInterval (first remainder)) (rest remainder))
                                                                      :default (list newInterval remainder))))]
                         (map #(if (> (count %) 1)
                                [(first %) (last %)]
                                [(first %) (first %)])
                              (getIntervals (sort (into #{} x))))))

(println (getEndPoints input))

(println (getEndPoints [1 2 3]))