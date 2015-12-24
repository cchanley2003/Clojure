 (ns InfixCalc)


(defn infix [a b c & x] (if (empty? x) (b a c) (apply infix (list* (b a c) x))))


 (println (infix 2 + 3 + 4))

 (println (infix 38 + 48 - 2 / 2))