 (ns Cards)


(def suites {\H :hearts \D :diamond \S :spades \C :clubs})

(println (suites \H))

(def ranks (into (zipmap  (map #(first (seq (str %))) (range 2 10)) (range 0 9)) {\T 8 \J 9 \Q 10 \K 11 \A 12}))

(println ranks)

 (println (seq "DQ"))

(defn cards [s] (let [cs (seq s)] (assoc (assoc {} :suit (suites (first cs))) :rank (ranks (second cs)))))

 (println (cards "DQ"))

 (println (cards "S9"))

 (println (second (seq "S9")))

 (println (ranks (second (seq "H5"))))

 (println (str 5))



(println (map (comp :rank cards str)
     '[S2 S3 S4 S5 S6 S7
       S8 S9 ST SJ SQ SK SA]))