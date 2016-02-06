(ns Anagram)

(require 'clojure.set)

;(require 'clojure.set)

;(defn ana1? [x y] (= (set (seq x)) (set (seq y))))

;(println (ana1? "team" "meat"))


(defn finalAnswer [x] (into #{} (letfn [(ana? [first sec] (= (set (seq first)) (set (seq sec))))
                              (anaFinder1 [y] (map set
                                                  (filter #(> (count %) 1) (if (= 1 (count y))
                                                                             #{}
                                                                             (concat #{(conj (filter #(ana? (first y) %) (rest y)) (first y))}
                                                                                     (anaFinder1 (rest y)))))))
                              ]
                        (let [preResult (anaFinder1 x)] (filter
                          (fn [item] (reduce #(and (not (and (clojure.set/subset? item %2) (not= item %2))) %1) true preResult))
                          preResult)))))

(println (finalAnswer ["veer" "lake" "item" "kale" "mite" "ever"]))
(println (= (finalAnswer ["veer" "lake" "item" "kale" "mite" "ever"]) #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}}))

;(println (anaFinder1 ["meat" "mat" "team" "mate" "eat"]))
(println (finalAnswer ["meat" "mat" "team" "mate" "eat"]))

(println (clojure.set/subset? #{1 2} #{1 2 3}))
(println "what")
;(println (map set (anaFinder1 ["veer" "lake" "item" "kale" "mite" "ever"])))


(defn anaAgain [z] (letfn [(anaFinder [y]
                             (map set
                                  (letfn
                                        [(ana? [x y] (= (set (seq x)) (set (seq y))))]
                                    (filter #(> (count %) 1) (if (= 1 (count y))
                                                               #{}
                                                               (concat #{(conj (filter #(ana? (first y) %) (rest y)) (first y))}
                                                                       (anaFinder (rest y))))))))] (reduce #(conj #{} (clojure.set/union %1 %2))
                                                                                                           (map set (anaFinder z)))))
(println (anaAgain ["meat" "mat" "team" "mate" "eat"]))
(println (anaAgain ["veer" "lake" "item" "kale" "mite" "ever"]))

(println (letfn [(anaFinder [y] (map set (letfn [(ana? [x y] (= (set (seq x)) (set (seq y))))] (filter #(> (count %) 1) (if (= 1 (count y))
#{}
(concat #{(conj (filter #(ana? (first y) %) (rest y)) (first y))} (anaFinder (rest y))))))))] (reduce #(clojure.set/union %1 %2) (map set (anaFinder ["meat" "mat" "team" "mate" "eat"])))))

(println (reduce #(conj #{} (clojure.set/union %1 %2)) '(#{"meat" "mate" "team"} #{"mate" "team"})))