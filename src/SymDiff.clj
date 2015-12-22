 (ns SymDiff)

 (require 'clojure.set)


 (println (clojure.set/difference  #{1 3 5 7} #{1 2 3 4 5 6} ))


 (defn symDiff [x y] (clojure.set/union (clojure.set/difference x y) (clojure.set/difference y x)))


 (println (symDiff  #{1 3 5 7} #{1 2 3 4 5 6}))