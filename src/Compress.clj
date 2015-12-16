 (ns Compress)


 (def input1 "Leeeeeerrroyyy")

(def parts (partition-by identity (seq input1)))

 (println parts)

 (def res (map first parts))

 (println res)

 (println (apply str res))

 (fn [x] (map first (partion-by indentity (seq x))))