 (ns LongSubSeq)


(defn longestSub [x] (reduce #(if (= 1 (count %2)) %1 (if (> (count %1) (count %2)) %1 %2)) '() (loop [result [] currentSeq [(first x)]toDo (rest x)] (if (empty? toDo)
                                                              (conj result currentSeq)
                                                               (if (= (first toDo) (inc (last currentSeq)))
                                                                 (recur result (conj currentSeq (first toDo)) (rest toDo))
                                                                 (recur (conj result currentSeq) [(first toDo)] (rest toDo)))))))

(println (longestSub [1 0 1 2 3 0 4 5]))

(println (longestSub [7 6 5 4]))






