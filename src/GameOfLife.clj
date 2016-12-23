 (ns GameOfLife)

 ; find neighbors taking into account going off the grid


(defn update [m k f] (assoc m k (f (get m k))))
(def input1 ["      "
             " ##   "
             " ##   "
             "   ## "
             "   ## "
             "      "])


(defn getNeighbors [coord] (filter  (fn [c] (every? #(< -1 %) c)) (vector
                             (update coord 0 inc)
                             (update coord 1 inc)
                             (update coord 0 dec)
                             (update coord 1 dec)
                             (update coord 1 #(+ % 2))
                             (update coord 0 #(+ % 2))
                             (map dec coord)
                             (map inc coord)
                             )))

(defn lookup [coord board] (get (get board (second coord)) (first coord)))

(println (get "#    " 0))

(println (lookup [0 1] input1))



(println (getNeighbors [1 1]))

(println (getNeighbors [0 0]))



