(ns HappyNumbers)

(println (str 16))

(println (map #(Integer/parseInt (str %)) (seq (str 16))))

(defn intToDigits2 [x] (map #(Integer/parseInt (str %)) (seq (str x))))


(defn HappyNumbers [n] (println n) (if (= n 1) true (HappyNumbers (reduce + (map #(* % %) (intToDigits2 n))))))

(defn newHappy [n] (letfn
                     [(hNum [x] (reduce + (map #(* % %) (intToDigits x))))
                      (intToDigits [x] (map #(Integer/parseInt (str %)) (seq (str x))))]
                     (loop
                       [prev #{}
                        initial (hNum n)]
                       (cond
                         (= initial 1) true
                         (contains? prev initial) false
                         :else (recur (conj prev initial) (hNum initial))))))

;(println (HappyNumbers 3))

(println (newHappy 3))