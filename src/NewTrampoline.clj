 (ns NewTrampoline)

(require 'clojure.test)

(defn newTramp [f & v ]
  (if (empty? v)
    (if (fn? f)
      (newTramp (f)) f)
    (newTramp (apply f v))))


(println 1)

 (println (letfn [(triple [x] #(sub-two (* 3 x)))
                  (sub-two [x] #(stop?(- x 2)))
                  (stop? [x] (if (> x 50) x #(triple x)))]
            (newTramp triple 2)))

(println 2)

