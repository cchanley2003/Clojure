 (ns PascalsTrapezoid)


 (defn ptrap [v] (letfn [(computeMiddle [m] (if (= (count m) 2)
                                              (list (+' (first m) (last m)))
                                              (conj  (computeMiddle (rest m))
                                                     (+' (first m) (second m)))))]
                        (iterate #(if (= (count %) 1)
                                   [(first %) (first %)]
                                   (concat (concat (list (first %)) (vec (computeMiddle %))) (list (last %)))) v)))


 (println (take 5 (ptrap [1])))