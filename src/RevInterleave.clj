 (ns RevInterleave)


(defn revInter [x y] (if (= y 0) x (concat (list (take-nth y x)) (revInter (flatten (map #(rest %) (partition y x))) (dec y)))))


 (println (take-nth 3 (range 9)))
 (println  (take-nth 2 (flatten (map #(rest %) (partition 3 (range 9))))))

 (println (revInter (range 9 ) 3))

 (println (partition 3 (range 9)))

