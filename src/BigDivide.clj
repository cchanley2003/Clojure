 (ns BigDivide)

(defn largestFactor [ceiling factor] (loop [candidate (dec ceiling)] (if (= 0 (mod candidate factor)) candidate (recur (dec candidate)))))

(println (largestFactor 100 5))

(println (largestFactor 100 3))

(defn bigDivide [c x y] (let [
                              largestFactor (fn [ceiling factor] (loop [candidate (dec ceiling)] (if (= 0 (mod candidate factor)) candidate (recur (dec candidate)))))
                              sumFactors (fn [num largest] (* (+ num largest) (/ (/ largest num) 2)))
                              sumX (sumFactors x (largestFactor c x))
                              sumY (sumFactors y (largestFactor c y))
                              backOut (sumFactors (* x y) (largestFactor c (* x y)))
                              ](- (+ sumX sumY) backOut)))

(println (largestFactor 1000 5))
(println (largestFactor 1000 3))

(defn sumFactors [num largest] (* (+ num largest) (/ (/ largest num) 2)))

(println (sumFactors 5 995))
(println (sumFactors 3 999))

(println (bigDivide 1000 3 5))

(println (largestFactor 1000 15))
(println (sumFactors 15 990))

(println (= "2333333316666668" (str (bigDivide 100000000 3 5))))

(println (str (bigDivide 100000000 3 5)))