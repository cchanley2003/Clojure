 (ns PrimeNumbers)


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


 (println (isPrime 2))
 (println (isPrime 5))
 (println (isPrime 11))
 (println (isPrime 10))

 (defn primeNums [n] (take  n (filter #(isPrime %) (range))) )

 (println (primeNums 2))