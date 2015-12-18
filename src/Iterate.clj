 (ns Iterate)


(defn iter [a b] (lazy-seq (cons b (iter a (a b)))))

(println (take 5 (iter #(* 2 %) 1)))