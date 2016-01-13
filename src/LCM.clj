 (ns LCM)


;(defn gcd [a b] (if (= a b) a (if (> a b) (gcd (- a b) b) (gcd a (- b a)))))



 (defn lcd [& s] (letfn [(gcd [a b] (if (= a b)
                                      a (if (> a b)
                                          (gcd (- a b) b) (gcd a (- b a)))))]
                        (reduce #(/ (* %1 %2) (gcd %1 %2)) s)))


 (println (lcd 21 6))

 (println (lcd 3/4 1/6))



 (println (lcd 5 3 7))