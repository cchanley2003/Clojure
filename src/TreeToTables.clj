(ns TreeToTables)


(def input1 '{a {p 1, q 2}
              b {m 3, n 4}})

(println (vals input1))
(println input1)

(println (keys input1))

(defn firstwalk [i1] (for [x (keys i1)]  (map #(vector x %1) (keys (get i1 x)))))

(defn firstwalk2 [i1] (for [x (keys i1)]  (vals (get i1 x))))

(println (mapcat identity (firstwalk input1)))

(println (firstwalk2 input1))

(println (zipmap (mapcat identity (firstwalk input1))  (mapcat identity (firstwalk2 input1))))

(defn treeToTable [i] (letfn [(kw [i1] (for [x (keys i1)]  (map #(vector x %1) (keys (get i1 x)))))
                            (kv [i1] (for [x (keys i1)]  (vals (get i1 x))))] (zipmap (mapcat identity (kw i)) (mapcat identity (kv i)))))

(println (treeToTable input1))