 (ns MathMaze)




(defn applyOp [number op] (cond
                            (= op :double) (* number 2)
                            (and (= op :halve) (even? number)) (/ number 2)
                            (= op :add2) (+ number 2)
                            :else nil))

(defn applyOps [number ops] (for [op ops] (applyOp number op)))

(defn countPath [start end] (letfn [(applyOp [number op] (cond
                                                                (= op :double) (* number 2)
                                                                (and (= op :halve) (even? number)) (/ number 2)
                                                                (= op :add2) (+ number 2)
                                                                :else nil))

                                    (applyOps [number ops] (for [op ops] (applyOp number op)))]
                              (let [ops #{:double :add2 :halve}]
                              (loop [step 1 todo (list start :step)] (let [cand (first todo)]
                                                                       (cond
                                                                         (= cand end) step
                                                                         (nil? cand) (recur step (rest todo))
                                                                         (= cand :step) (recur (inc step) (rest (conj (into [] todo) :step)))
                                                                         :else (recur step (concat (rest todo) (applyOps cand ops)))))))))

(println (countPath 1 1))

(println (countPath 3 12))

(println (countPath 9 2))

(println (countPath 9 12))

