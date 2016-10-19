(ns BalanceBracket)

(require 'clojure.set)





(def input1 "class Test {
      public static void main(String[] args) {
        System.out.println(\"Hello world.\");
      }
    }")


(println (seq input1))

;(println (filter #(contains? bracketSet %) (seq input1)))

(defn balanced? [i] (let [bracketMap {\] \[  \} \{  \) \(}
                          opens (set (vals bracketMap))
                          closes (set (keys bracketMap))
                          bracketSet (clojure.set/union opens closes)
                          brackets (filter #(contains? bracketSet %) (seq i))]
                      (loop [pendingClose [] toCheck brackets ] (println "Pending: " pendingClose " " toCheck) (cond
                                                                  (empty? toCheck) (empty? pendingClose)
                                                                  (contains? closes (first toCheck)) (if
                                                                                                       (= (bracketMap (first toCheck)) (last pendingClose))
                                                                                                       (recur (pop pendingClose) (rest toCheck))
                                                                                                       false
                                                                                                       )
                                                                  (contains? opens (first toCheck)) (recur (conj pendingClose (first toCheck)) (rest toCheck))
                                                                  )
                                                                )))

(println (balanced? input1))

(println (balanced? "([]([(()){()}(()(()))(([[]]({}()))())]((((()()))))))"))






