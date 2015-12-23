 (ns Juxt)

 (println (apply + [1 2 3 4 5]))


(fn [& fs]
  (fn [& args]
    (loop [fx (apply (last fs) args) fs (butlast fs)]
      (if fs
        (recur ((last fs) fx) (butlast fs))
        fx))))

(fn [& functions]
  (let [reverseFunctions (reverse functions)
        zeroFunction (first reverseFunctions)
        restFunctions (rest reverseFunctions)]
    (fn [& parameters]
      (reduce #(%2 %1) (apply zeroFunction parameters) restFunctions))))

(fn [& xs] (fn [& ys] (reduce #(%2 %1) (apply (last xs) ys) (rest (reverse xs)))))


(fn [& fns]
  (fn [& args]
    (loop [rfns (rest (reverse fns))
           v (apply (last fns) args)]
      (if (seq rfns) (recur (rest rfns) ((first rfns) v))
                     v))))


 (println (apply (first [+ max min])  [2 3 5 1 6 4]))

 (defn juxy [& fns]
   (fn [& args]
     (loop [remainder fns result []]
       (if (empty? remainder)
         result
         (recur (rest remainder) (conj result (apply (first remainder) args)))))))

 (println  ((juxy + max min) 2 3 5 1 6 4))

(println  (class java.lang.Class))

