 (ns PascalsTriangle)




(defn ptri [row]
  (letfn [
          (factorial [x] (loop [num x result 1] (if (= num 0) result (recur (dec num) (* result num)))))
          (pascColRow [row col] (/ (factorial row) (* (factorial col) (factorial (- row col)))))
          ]
    (if (= 1 row)
    [1]
    (loop [col 0 result []]
      (if (= col (dec row))
        (conj result 1)
        (recur (inc col)  (conj result (pascColRow (dec row) col))))))))



 (println (ptri 4))