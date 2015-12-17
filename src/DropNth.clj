 (ns DropNth)

 (def input1 [1 2 3 4 5 6 7 8])

 (def input2 [:a :b :c :d :e :f])

 (println (partition-all 3 input1))



(println (map #(if (== (count %) 3) (drop-last %) %) (partition-all 3 input1)))

(def result (map #(if (== (count %) 3) (drop-last %) %) (partition-all 3 input1)))

 (println (flatten result))

(fn [x y] (flatten (map #(if (== (count %) y) (drop-last %) %) (partition-all y x))))