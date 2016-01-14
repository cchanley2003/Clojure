(ns Anagram)

(require 'clojure.set)

;(require 'clojure.set)

;(defn ana1? [x y] (= (set (seq x)) (set (seq y))))

;(println (ana1? "team" "meat"))

(defn anaFinder1 [y] (map set (letfn [(ana? [x y] (= (set (seq x)) (set (seq y))))] (filter #(> (count %) 1) (if (= 1 (count y))
                                                                                                               #{}
                                                                                                               (concat #{(conj (filter #(ana? (first y) %) (rest y)) (first y))} (anaFinder1 (rest y))))))))



(println (anaFinder1 ["veer" "lake" "item" "kale" "mite" "ever"]))
(println (anaFinder1 ["meat" "mat" "team" "mate" "eat"]))
(println "what")
(println (map set (anaFinder1 ["veer" "lake" "item" "kale" "mite" "ever"])))


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