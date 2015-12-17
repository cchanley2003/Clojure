 (ns SplitSeq)


 (def input1   [1 2 3 4 5 6])
 (def input2 3)

 (def res1 (take input2 input1))

 (def res2 (drop input2 input1))

 (println res1)

 (println res2)

 (println (concat (list res1) (list res2)))

 (println (list  res1))

 (defn splitSeq [x y] (concat (list (take x y)) (list (drop x y))))

 (println  (splitSeq input2 input1))

(println (= (splitSeq input2 input1) [[1 2 3] [4 5 6]]))
