 (ns WordSorting)


 (println (sort #(< (int (first (seq (clojure.string/capitalize %1)))) (int (first (seq (clojure.string/capitalize %2))))) (clojure.string/split "Have a nice day" #" ")))

(defn wordSort [x] (sort #(< (int (first (seq (clojure.string/capitalize %1)))) (int (first (seq (clojure.string/capitalize %2))))) (clojure.string/split x #" ")))

 (println (wordSort "Have a nice day"))

(println (wordSort "Fools fall for foolish follies."))

(defn dropPunc [x] (clojure.string/replace x #"[^\w\s]" ""))


(def input1 "Fools fall for foolish follies!")

(println (dropPunc input1))

(defn sortStr [x] (sort #(compare (clojure.string/capitalize %1)
                                  (clojure.string/capitalize %2))
                        (clojure.string/split (dropPunc x) #" ")))

 (println (sortStr input1))

 (println (sort (clojure.string/split "Fools fall for foolish follies" #" ")))