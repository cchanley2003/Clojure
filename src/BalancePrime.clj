 (ns BalancePrime)


(println (take 5 (iterate inc 6)))

(defn isPrime [x]
  (if (<= x 1)
    false
    (if (<= x 3) true
                 (if  (or (= (rem x 2) 0) (= (rem x 3) 0))
                   false
                   (loop [i 5]
                     (if (> (* i i) x)
                       true
                       (if (or (= (rem x i) 0) (= (rem x (+ i 2)) 0))
                         false
                         (recur (+ i 6))
                         )))))))

(println (first (filter isPrime (iterate inc 5))))

(println (first (filter isPrime (iterate dec 4))))

(defn balancePrime [c] (letfn [
                     (isPrime? [x]
                       (if (<= x 1)
                         false
                         (if (<= x 3) true
                                      (if  (or (= (rem x 2) 0) (= (rem x 3) 0))
                                        false
                                        (loop [i 5]
                                          (if (> (* i i) x)
                                            true
                                            (if (or (= (rem x i) 0) (= (rem x (+ i 2)) 0))
                                              false
                                              (recur (+ i 6))
                                              )))))))
                           (nextPrimeF [f n] (first (filter isPrime? (iterate f n))))
                           (nextPrime [num] (nextPrimeF inc  (inc num)))
                           (prevPrime [num] (nextPrimeF dec  (dec num)))


 ]  (and (isPrime? c) (> c 2) (= c (/ (+ (prevPrime c) (nextPrime c)) 2) ))))

(println (balancePrime 563))

(println (balancePrime 11))
(println (balancePrime 4))

(println (balancePrime 1103))

(println (filter balancePrime (range 10)))