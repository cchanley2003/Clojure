 (ns Pack)

(use 'clojure.set)

(defn f1 [x]
  (loop [y (first x) z (rest x) val true]
    (if (empty? z) val
                   (recur (first z) (rest z) (and val (reduce #(and %1 %2) (set (map #(empty? (clojure.set/intersection y %)) z))))))))

 (def input [1 1 2 1 1 1 3 3])
 (def input2 [:a :a :b :b :c])

(def res (conj []   (list (first input))))



(defn f2 [x]
  (loop [res '() toAdd (list (first x)) toDo (rest x)]
    (if (empty? toDo)
      (concat res (list toAdd))
      (if (= (first toAdd) (first toDo))
        (recur res  (conj toAdd (first toDo)) (rest toDo))
        (recur (concat res (list toAdd)) (list (first toDo)) (rest toDo))))))


(println (f2 input))

(println (f2 input2))
