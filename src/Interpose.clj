 (ns Interpose)


 (def v [1 2 3])

 (println (count v))

 (println  (interleave (take (count v) (repeat 0)) v))

(defn inter [x v] (rest (interleave (take  (count v) (repeat x)) v)))

(println (inter 0 v))