 (ns ReadBinary)

(defn readBinary [x] (int (reduce + (reduce-kv (fn [m k v] (conj m (if (= v \0) 0 (Math/pow 2 k)))) []  (into [] (reverse (seq x)))))))

 (def input1 "10101010101")

 (println (= (first (seq input1)) \1))

 (println (into [] (reverse (seq input1))))

 (println (readBinary input1))

 (println (int (readBinary "111")))