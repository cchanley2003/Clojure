 (ns computeMachina)

(defn fullEval [input] (letfn [
                             (exprEval [argMap vals] (map (fn [val] (cond
                                                                      (number? val) val
                                                                      (coll? val) (let [expr (exprEval argMap val)] (apply (first expr) (rest expr)))
                                                                      (= val '+) +
                                                                      (= val '*) *
                                                                      (= val '/) /
                                                                      (= val '-) -
                                                                      :default (argMap val))) vals))
                             ]

                       (fn [argMap] (let [e (exprEval argMap input)] (apply (first e) (rest e))))))
