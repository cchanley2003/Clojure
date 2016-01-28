 (ns CamelCase)

(println (clojure.string/replace "multi-word-key" #"-\w"  #(subs (clojure.string/upper-case %1) 1)))