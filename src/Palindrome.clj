 (ns Palindrome)


(defn convertToIntSeq [x] (map #(read-string (str %)) (seq (str x))))

(println (read-string (apply str (convertToIntSeq 111))))

(defn convertIntSeqToNum [s]  s)

(defn prevEven [i] (- i (rem i 2)))

(println (prevEven 4))

(println (prevEven 3))

(println (convertToIntSeq 122))

(defn fixOverflow [x] (if (some #(> % 9) x) (let [overs (filter #(< 9 (second %)) (map-indexed vector x))
                                                  zeroes (map #(assoc % 1 0 ) overs)
                                                  zeroed (apply assoc x (flatten zeroes))] zeroed) x))

 ;Get indexes to increase (- 1 min keys) (+ 1 max keys) if (min -1 add to the outside)

(println (cons 0 (conj [1 2 3] 4)))

(println (fixOverflow [1 10 2]))

(println (fixOverflow [1 2 1]))

(println (into [] {1 2 3 4}))


(defn isPalindrome? [x] (let [s (convertToIntSeq x)]
                          (= s (reverse s))))

(defn nextPalindrome [x] (let [s (into [] (convertToIntSeq x))
                               i (int (/ (count s) 2))]

                           (println i)
                           (cond
                             (odd? (count s)) (update s i inc)
                             :else (update (update s i inc) (dec i) inc)
                             )
                           )
  )

(println (nextPalindrome 11111))

(println (isPalindrome? 111))

(println (nextPalindrome 1111))

(println (map-indexed vector [1 2 3 4]))

(println (filter #(< 9 (second %)) (map-indexed vector [1 8 10 3 4 11 2])))

;(println (isPalindrome? (nextPalindrome 111)))
