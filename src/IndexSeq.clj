 (ns IndexSeq)


(defn ind [z] (map-indexed (fn [i x] (vector x i)) z))