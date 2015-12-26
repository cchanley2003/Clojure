 (ns WordSorting)


 (println (sort #(< (int (first (seq (clojure.string/capitalize %1)))) (int (first (seq (clojure.string/capitalize %2))))) (clojure.string/split "Have a nice day" #" ")))

(defn wordSort[x] (sort #(< (int (first (seq (clojure.string/capitalize %1)))) (int (first (seq (clojure.string/capitalize %2))))) (clojure.string/split x #" ")))

 (println (wordSort "Have a nice day"))

(println (wordSort "Fools fall for foolish follies."))


 (println (sort (clojure.string/split "Fools fall for foolish follies" #" ")))