 (ns PerfectSquares)


 (println (Math/sqrt 16))

 (println (= (Math/sqrt 10) (int (Math/sqrt 10))))

(println (= (Math/sqrt 16) (double (int (Math/sqrt 16)))))

(defn  squares [x] (clojure.string/join "," (filter #(= 0 (compare (Math/sqrt %) (int (Math/sqrt %)))) (map #(read-string %) (clojure.string/split x #",")))))

(println (clojure.string/join "," (squares "1,2,5,16,25,30")))

(println (map #(read-string %) (clojure.string/split "1,4,5,7,16,25" #",")))
