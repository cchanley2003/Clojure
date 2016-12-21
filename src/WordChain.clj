 (ns WordChain)


(def chain #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"})
 ;find children for any word

(defn diffSameSize [w1 w2]  (apply + (map #(if (= %1 %2) 0 1) w1 w2)))

(defn diffDiffSize [w1 w2] (loop [todo1 w1 todo2 w2 skipped false] (cond
                                                                     (or (empty? todo1) (empty? todo2)) true
                                                                     (= (first todo1) (first todo2)) (recur (rest todo1) (rest todo2) skipped)
                                                                     skipped false
                                                                     :else (let [longer (if (> (count todo1) (count todo2)) todo1 todo2)
                                                                           shorter (if (> (count todo1) (count todo2)) todo2 todo1)] (recur (rest longer) shorter true))
                                                                     )
                                                                   )
  )

(defn isChild? [word candidate] (let [wordSeq (seq word)
                                      candSeq  (seq candidate)
                                      lengthDiff (Math/abs (- (count wordSeq) (count candSeq))) ]
                                  (cond
                                    (= word candidate) false
                                    (> lengthDiff 1) false
                                    (= 0 lengthDiff ) (< (diffSameSize wordSeq candSeq) 2)
                                    :else (diffDiffSize word candidate)
                                    )))
(defn findChildren [word words] (loop [res '() todo words] (cond
                                                             (empty? todo) res
                                                             (isChild? word (first todo)) (recur (cons (first todo) res) (rest todo))
                                                             :else (recur res (rest todo))
                                                             )))

(defn findAllChildren [words]  (apply merge
                                      (map
                                        #(hash-map % (findChildren % words))
                                        words)))


(defn walkChain [word chainMap visited goal] (let [newVisited (conj visited word)]
                                               (cond
                                                 (= newVisited goal) true
                                                 (contains? visited word) false
                                                 :else (loop [todo (chainMap word)]
                                                         (cond
                                                           (empty? todo) false
                                                           (walkChain (first todo) chainMap newVisited goal) true
                                                           :else (recur (rest todo))
                                                                                      )))
                                               ))

(defn canChain? [lw] (letfn [

                             (diffSameSize [w1 w2]  (apply + (map #(if (= %1 %2) 0 1) w1 w2)))

                             (diffDiffSize [w1 w2] (loop [todo1 w1 todo2 w2 skipped false] (cond
                                                                                                  (or (empty? todo1) (empty? todo2)) true
                                                                                                  (= (first todo1) (first todo2)) (recur (rest todo1) (rest todo2) skipped)
                                                                                                  skipped false
                                                                                                  :else (let [longer (if (> (count todo1) (count todo2)) todo1 todo2)
                                                                                                              shorter (if (> (count todo1) (count todo2)) todo2 todo1)] (recur (rest longer) shorter true))
                                                                                                  )
                                                                                                )
                               )

                             (isChild? [word candidate] (let [wordSeq (seq word)
                                                                   candSeq  (seq candidate)
                                                                   lengthDiff (Math/abs (- (count wordSeq) (count candSeq))) ]
                                                               (cond
                                                                 (= word candidate) false
                                                                 (> lengthDiff 2) false
                                                                 (= 0 lengthDiff ) (< (diffSameSize wordSeq candSeq) 2)
                                                                 :else (diffDiffSize word candidate)
                                                                 )))
                             (findChildren [word words] (loop [res '() todo words] (cond
                                                                                          (empty? todo) res
                                                                                          (isChild? word (first todo)) (recur (cons (first todo) res) (rest todo))
                                                                                          :else (recur res (rest todo))
                                                                                          )))

                             (walkChain [word chainMap visited goal] (let [newVisited (conj visited word)]
                                                                            (cond
                                                                              (= newVisited goal) true
                                                                              (contains? visited word) false
                                                                              :else (loop [todo (chainMap word)]
                                                                                      (cond
                                                                                        (empty? todo) false
                                                                                        (walkChain (first todo) chainMap newVisited goal) true
                                                                                        :else (recur (rest todo))
                                                                                        )))
                                                                            ))

                             (findAllChildren [words]  (apply merge
                                                                   (map
                                                                     #(hash-map % (findChildren % words))
                                                                     words)))
                             ]
                       (let [wordsWithChildren (findAllChildren lw)]
                       (not (= nil (some #(walkChain % wordsWithChildren #{} lw) lw)))))
  )



;(println (map #({% 1}) chain))

(println (findAllChildren chain))

(println (findAllChildren #{"to" "top" "stop" "tops" "toss"}))

(println (walkChain "dog" (findAllChildren chain) #{} chain))

(println (canChain? chain))


(println (= false (canChain? #{"cot" "hot" "bat" "fat"})))