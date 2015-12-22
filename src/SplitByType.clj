 (ns SplitByType)


 (def input1 [1 :a 2 :b 3 :c])

 (println  (vals (group-by type input1)))