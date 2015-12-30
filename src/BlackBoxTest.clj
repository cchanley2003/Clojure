 (ns BlackBoxTest)


(println (keys {:a 1, :b 2}))

(def aaset (set '(1 2 3 4)))
(def aamap {:a 1, :b 2})
(def alist '(1 2 3 4))
(def avec [1 2 3 4])

(defn f [x] (println x) :test)

(println (f "Test"))

(println (get #{1 2 4 5} 1))

(println (get aamap (first aamap)))

(println (get avec (first avec)))

(println (get aaset (first aaset)))

(println (get alist (first alist)))

(println (rest (butlast aamap)))

(defn bb [x] (if (associative? x) (if (empty? x)
                                    (if (= x {})
                                      :map
                                      :vector)
                                    (if (= (get x 0) (first x))
                                      :vector
                                      :map))
                                  (if (and (= (first (conj x 'a)) 'a) (= 2 (count (conj x 'a 'a)))) :list :set)))

(println (bb aamap))

(println (bb []))


(println (map bb [{} #{} [] ()]))


(println (merge [1 2 4 5] [1 2 3 4 5]))