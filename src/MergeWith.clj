 (ns MergeWith)

;Get a set of all the keys
;For each key reduce using function




(defn ks [f & m] (apply merge (map (fn [y]  {(first y) (reduce f (second y))}) (for [item (set (reduce #(into (keys %2) %1) '() m))]
                  [item (filter (complement nil?) (map #(get %1 item) m))]))))

(println (ks * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5}))
