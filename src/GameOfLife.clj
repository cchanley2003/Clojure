 (ns GameOfLife)

 ; find neighbors taking into account going off the grid


(defn update [m k f] (assoc m k (f (get m k))))
(def input1 ["      "
             " ##   "
             " ##   "
             "   ## "
             "   ## "
             "      "])
(def input2 ["     "
             "     "
             " ### "
             "     "
             "     "])

(defn getNeighbors [coord] (filter  (fn [c] (every? #(< -1 %) c)) (vector
                                                                    (update coord 0 inc)
                                                                    (update coord 1 inc)
                                                                    (update coord 0 dec)
                                                                    (update coord 1 dec)
                                                                    [(inc (first coord)) (dec (second coord))]
                                                                    (vector (dec (first coord)) (inc (second coord)))
                                                                    (map dec coord)
                                                                    (map inc coord)
                                                                    )))

(defn lookup [coord board] (get (get board (second coord)) (first coord)))

(defn countAliveNeigbors [coord board] ((frequencies (map #(lookup % board) (getNeighbors coord))) \#))

(defn applyRules [coord board] (let [aliveNeighbors (countAliveNeigbors coord board)] (if (= (lookup coord board) \#) (cond
                                                                                                                        (< aliveNeighbors 2) " "
                                                                                                                        (< aliveNeighbors 4) "#"
                                                                                                                        :else " "
                                                                                                                        )
                                                                                                                      (if (= aliveNeighbors 3)
                                                                                                                        "#"
                                                                                                                        " "))))


(defn getAllCoords [board] (for [x (range (count board)) y (range (count (first board)))] [x y]))


(defn runRound [board]

  (letfn [
          (update [m k f] (assoc m k (f (get m k))))

          (getNeighbors [coord] (filter  (fn [c] (every? #(< -1 %) c)) (vector
                                                                              (update coord 0 inc)
                                                                              (update coord 1 inc)
                                                                              (update coord 0 dec)
                                                                              (update coord 1 dec)
                                                                              [(inc (first coord)) (dec (second coord))]
                                                                              (vector (dec (first coord)) (inc (second coord)))
                                                                              (map dec coord)
                                                                              (map inc coord)
                                                                              )))

          (lookup [coord board] (get (get board (second coord)) (first coord)))

          (countAliveNeigbors [coord board] ((frequencies (map #(lookup % board) (getNeighbors coord))) \#))

          (applyRules [coord board] (let [aliveNeighbors (countAliveNeigbors coord board)] (if (= (lookup coord board) \#) (cond
                                                                                                                                  (< aliveNeighbors 2) " "
                                                                                                                                  (< aliveNeighbors 4) "#"
                                                                                                                                  :else " "
                                                                                                                                  )
                                                                                                                                (if (= aliveNeighbors 3)
                                                                                                                                  "#"
                                                                                                                                  " "))))


          (getAllCoords [board] (for [x (range (count board)) y (range (count (first board)))] [y x]))


          ]
  (let [allCoords (getAllCoords board)] (into [] (map #(apply str %) (partition (count (first board)) (map #(applyRules % board) allCoords)))))))

(println (lookup [0 1] input1))

(println  "Apply rules:" (applyRules [2 1] input2))
(println "Neighbors: " (getNeighbors [2 1]))
(println "Alive Neihbors: " (countAliveNeigbors [2 1] input2))
(println (map #(applyRules % input2) (getAllCoords input2)))

(println (getAllCoords input2))


(println (apply str (seq ["1" "2" "3"])))
(println "Run round")
(println (runRound input2))
(println ["     "
          "  #  "
          "  #  "
          "  #  "
          "     "])


(println "Compare" (= (runRound input1) ["      "
                                         " ##   "
                                         " #    "
                                         "    # "
                                         "   ## "
                                         "      "]))
(println input1)
(println (getNeighbors [1 1]))

(println (getNeighbors [0 0]))



