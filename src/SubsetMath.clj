 (ns SubsetMath)
(require 'clojure.set)

(def input1 #{-10 9 -8 7 -6 5 -4 3 -2 1})

(def input2 #{-1 1 99} )


(defn sumInCommon? [& s]
  (letfn [(comb [k l]
            (if (= 1 k) (map vector l)
                        (apply concat
                               (map-indexed
                                 #(map (fn [x] (conj x %2))
                                       (comb (dec k) (drop (inc %1) l)))
                                 l))))
          (all-subsets [s]
            (apply concat
                   (for [x (range 1 (inc (count s)))]
                     (map #(into #{} %) (comb x s)))))
          (sumSets [x] (let [sums (map #(apply + %) (all-subsets x))] (into #{} sums)))
          (sumAllSets [& s] (map sumSets s))

          ]
  (not (empty? (apply clojure.set/intersection (apply sumAllSets s))))))





(println (sumInCommon? #{-1 1 99}
                     #{-2 2 888}
                     #{-3 3 7777}))

