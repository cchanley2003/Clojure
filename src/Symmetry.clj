 (ns Symmetry)



(defn revTree [t]   (let [root (first t)
                              leftBranch (second t)
                              rightBranch (last t)] [root (if (nil? rightBranch) rightBranch (revTree rightBranch)) (if (nil? leftBranch) leftBranch (revTree leftBranch))]))

 (defn isSym? [tree]  (letfn [(reverseTree [t]   (let [root (first t)
                                                            leftBranch (second t)
                                                            rightBranch (last t)] [root (if (nil? rightBranch) rightBranch (reverseTree rightBranch)) (if (nil? leftBranch) leftBranch (reverseTree leftBranch))]))] (= (second tree) (reverseTree (last tree)))))

 (println (revTree [1 nil [2 [3 nil nil] nil]]))

 (println (isSym? '(:a (:b nil nil) (:b nil nil))))