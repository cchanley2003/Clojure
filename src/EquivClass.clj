 (ns EquivClass)


 (defn binEquiv [f s] (map #(assoc {} (f %) %) s))

 (println (binEquiv #(* % %) #{-2 -1 0 1 2}))

 (defn newBin [f s] (set (map #(into #{} %) (vals (group-by f s)))))

 (println (newBin #(* % %) #{-2 -1 0 1 2}))