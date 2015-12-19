 (ns CartesianProduct)


 (println "one")

(def input1 #{"ace" "king" "queen"})

 (def input2 #{"♠" "♥" "♦" "♣"})

 (println input2)

 (defn cart [x y] (loop [toMap (first x) result #{} toDo (rest x)]
                   (if (empty? toDo)
                     (into result (map (fn [z] (vector toMap z)) y))
                    (recur
                     (first toDo)
                     (into result (map (fn [z] (vector toMap z)) y))
                     (rest toDo)))))

 (println (cart input1 input2))