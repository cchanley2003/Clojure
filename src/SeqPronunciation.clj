 (ns SeqPronunciation)


 (def toFlatten (map #(vector (count %) (first %)) (partition-by identity [1 1 1 4 4])))

 (println (flatten toFlatten))

 (defn lazyPronunc [s]
              (letfn
                [(pronuncSeq [x]
                   (flatten (map #(vector (count %) (first %)) (partition-by identity x))))]
                (cons (pronuncSeq s) (lazy-seq (lazyPronunc (pronuncSeq s))))))

 (println (take 3 (lazyPronunc [1 1 1 4 4])))