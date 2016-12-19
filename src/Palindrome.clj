 (ns Palindrome)


;(defn convertToIntSeq [x] (map #(read-string (str %)) (seq (str x))))

;(println (read-string (apply str (convertToIntSeq 111))))
;
;(defn convertIntSeqToNum [s]  (read-string (apply str s)))
;
;(defn prevEven [i] (- i (rem i 2)))
;
;(println (prevEven 4))
;
;(println (prevEven 3))
;
;(println (convertToIntSeq 122))

;(defn fixOverflow [x] (if (some #(> % 9) x) (let [adjusted (if (= 10 (first x)) (into [] (cons 0 (conj x 0))) x)
;                                                  overs (filter #(< 9 (second %)) (map-indexed vector adjusted))
;                                                  zeroes (map #(assoc % 1 0 ) overs)
;                                                  zeroed (apply assoc adjusted (flatten zeroes))
;                                                  left (dec (first (reduce #(if(< (first %1) (first %2)) %1 %2) zeroes)))
;                                                  right (inc (first (reduce #(if(> (first %1) (first %2)) %1 %2) zeroes)))]
;                                              (fixOverflow (update (update zeroed left inc) right inc))) x))

 ;Get indexes to increase (- 1 min keys) (+ 1 max keys) if (min -1 add to the outside)

;(println (cons 0 (conj [1 2 3] 4)))
;
;(println "Overflow: "(fixOverflow [1 10 1]))
;
;(println "Overflow 2: " (fixOverflow [1 10 10 1]))
;
;(println "Overflow 3: " (fixOverflow [10 1 1 10]))
;
;
;(println (fixOverflow [1 2 1]))
;
;(println (into [] {1 2 3 4}))




;(defn isPalindrome? [x] (let [s (convertToIntSeq x)]
;                          (= s (reverse s))))

;(defn nextPalindrome [x] (if (< x 11) (inc x)
;                                      (convertIntSeqToNum (fixOverflow (let [s (into [] (convertToIntSeq x))
;                                                                             i (int (/ (count s) 2))]
;                                                                         (cond
;                                                                           (odd? (count s)) (update s i inc)
;                                                                           :else (update (update s i inc) (dec i) inc)
;                                                                           )
;                                                                         )
;                                                                       )
;                                                          )
;                                      )
;  )

;(defn nextPalFromAny [i] (if (isPalindrome? i) i  (let [s (convertToIntSeq i)
;                                                        start (take (int (/ (count s) 2)) s)
;                                                        middle (if (odd? (count s)) [0] [])
;                                                        end (reverse start)
;                                                        finish (concat start middle end)
;                                                        num (convertIntSeqToNum finish) ] (loop [t num] (if (> t i) t (recur (nextPalindrome t)))))))

(defn genPalindromeLazySeq
  ([p] (genPalindromeLazySeq p (lazy-seq [p]) ))
  ([p s] (letfn [
                 (convertToIntSeq [x] (map #(read-string (str %)) (seq (str x))))

                 (convertIntSeqToNum [s]  (read-string (apply str s)))
                 (nextPalFromAny [i] (if (isPalindrome? i) i  (let [s (convertToIntSeq i)
                                                                   start (take (int (/ (count s) 2)) s)
                                                                   middle (if (odd? (count s)) [0] [])
                                                                   end (reverse start)
                                                                   finish (concat start middle end)
                                                                   num (convertIntSeqToNum finish) ] (loop [t num] (if (> t i) t (recur (nextPalindrome t)))))))

                 (nextPalindrome [x] (if (< x 11) (inc x)

                                                  (let [s (into [] (convertToIntSeq x))
                                                                                        i (int (/ (count s) 2))]
                                                    (if (every? #(= 9 %) s)
                                                      (+ x 2)
                                                      (convertIntSeqToNum
                                                        (fixOverflow
                                                          (cond
                                                            (odd? (count s)) (update s i inc)
                                                            :else (update (update s i inc) (dec i) inc)
                                                            )
                                                          )
                                                        ))
                                                    )
                                                 ))
                 (isPalindrome? [x] (let [s (convertToIntSeq x)]
                                           (= s (reverse s))))
                 (fixOverflow [x] (if (some #(> % 9) x) (let [adjusted (if (= 10 (first x)) (into [] (cons 0 (conj x 0))) x)
                                                                   overs (filter #(< 9 (second %)) (map-indexed vector adjusted))
                                                                   zeroes (map #(assoc % 1 0 ) overs)
                                                                   zeroed (apply assoc adjusted (flatten zeroes))
                                                                   left (dec (first (reduce #(if(< (first %1) (first %2)) %1 %2) zeroes)))
                                                                   right (inc (first (reduce #(if(> (first %1) (first %2)) %1 %2) zeroes)))]
                                                               (fixOverflow (update (update zeroed left inc) right inc))) x))
                 ] (let [add (nextPalFromAny p)] (cons add (lazy-seq (genPalindromeLazySeq (nextPalindrome add) s))
                                                             )
                                              )
                                        )
    )
  )

;(println "Next" (nextPalFromAny 12))
;
;(println "Next" (nextPalFromAny 132))
;
;(println (take 7 (genPalindromeLazySeq 5)))
;
;(println (nextPalindrome 11111))
;
;(println (isPalindrome? 111))
;(println (isPalindrome? 1))
;
;(println (nextPalindrome 1111))
;
;(println (map-indexed vector [1 2 3 4]))
;
;(println (filter #(< 9 (second %)) (map-indexed vector [1 8 10 3 4 11 2])))

;(println (isPalindrome? (nextPalindrome 111)))



(println (take 16 (genPalindromeLazySeq 162)))

(println (= (take 26 (genPalindromeLazySeq 0))
   [0 1 2 3 4 5 6 7 8 9
    11 22 33 44 55 66 77 88 99
    101 111 121 131 141 151 161]))

(println (take 26 (genPalindromeLazySeq 0)))