 (ns LexicalClosure)


 (defn power [x] (fn [y] (reduce * (repeat x y))))

 (println ((power 2) 4))

