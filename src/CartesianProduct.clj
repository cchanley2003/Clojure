 (ns CartesianProduct)


 (println "one")

(def input1 #{"ace" "king" "queen"})

 (def input2 #{"♠" "♥" "♦" "♣"})

 (println input2)

 (defn cart [x y] (loop [result #{} toDo x]
                   (if (empty? toDo)
                     result
                    (recur
                     (into result (map (fn [z] (vector (first toDo) z)) y))
                     (rest toDo)))))

 (println (cart input1 input2))