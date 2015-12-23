 (ns FunctionComp)


(defn fc [& funs] (loop [toDo funs] (if (= (count toDo) 1) (first toDo) ((last toDo) (recur (drop-last toDo))))) )

(println ((fc rest reverse) [1 2 3 4 5]))