 (ns BalancedN)

(defn intToDigits2 [x] (map #(Integer/parseInt (str %)) (seq (str x))))

 (defn splitNum [s] (+ (int (/ (count s) 2)) (rem (count s) 2)))


 (println (splitNum [1 2 3 4]))

 (println (splitNum [1 2 3 4 5]))


 (defn balancedN [b] (let [
                           intoDigits (fn [x] (map #(Integer/parseInt (str %)) (seq (str x))))
                           splitN (fn [s] (+ (int (/ (count s) 2)) (rem (count s) 2)))
                           numSeq (intoDigits b)
                           splitVal (splitN numSeq)
                           ] (= (reduce + (take  splitVal numSeq)) (reduce + (take-last splitVal numSeq)))))

 (println (balancedN 111))

(println (take 20 (filter balancedN (range))))