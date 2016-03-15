 (ns DigitBases)

 (defn digits [num base] (Math/ceil (/ (Math/log num) (Math/log base))))

 (println (digits 320 10))

(println (digits 9 2))


(defn calcDigits [num base]
  (letfn [(digit [n b] (dec (Math/ceil (/ (Math/log n) (Math/log b)))))]
    (cond (= 0 num) [0]
          (= num base) [1 0]
                  :else (loop [n num d (digit num base) res []]
                    (let [factor (Math/pow base d) dig (quot n factor)]
                      (if (neg? d) res
                                   (recur (- n (* factor dig)) (dec d) (conj res (int dig)))))))))

(println (let [n (rand-int 100000)] (calcDigits n n)))

 (println (calcDigits 15 15))

 (println (calcDigits 320 10))

 (println (calcDigits 9 2))

