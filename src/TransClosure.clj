 (ns TransClosure)
(require 'clojure.set)

(def input #{[8 4] [9 3] [4 2] [27 9]})

(def input2 #{["cat" "man"] ["man" "snake"] ["spider" "cat"]})

(println (map #(vector 27 (second %1)) (filter #(= (first %1) 9) '([8 4] [4 2] [9 3]))))





(defn finalSolution [i] (letfn [(nextOrder [x]
                                  (loop [res x todo x]
                                    (let [[a b] (first todo) r (rest todo)]
                                      (if
                                        (empty? todo)
                                        res
                                        (recur (clojure.set/union res (set (map #(vector a (second %1)) (filter #(= (first %1) b) x)))) r)))))
                                ]
                          (loop
                            [ latest i]
                            (let
                              [c (count latest)
                               new (nextOrder latest)
                               newCount (count new)]
                              (if (= c newCount)
                                latest
                                (recur new))))))
(println (finalSolution input))

(println (finalSolution input2))