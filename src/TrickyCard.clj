 (ns TrickyCard)







(defn playTricky [trump]
  (letfn [(playHand [trump lead hand] (cond
                                             (= (:suit hand) trump) (if (not (= (:suit lead) trump))
                                                                      hand
                                                                      (if (> (:rank hand) (:rank lead))
                                                                        hand
                                                                        lead))
                                             (= (:suit hand) (:suit lead)) (if (> (:rank hand) (:rank lead))
                                                                             hand
                                                                             lead)

                                             :else lead
                                             ))]
  (partial (fn [trump hands] (loop [lead (first hands) toPlay (rest hands)]
                               (if (empty? toPlay)
                                 lead
                                 (recur (playHand trump lead (first toPlay)) (rest toPlay))
                                 ))) trump)))

(println ((playTricky :club) [{:suit :spade :rank 2}
                      {:suit :club :rank 10}]))

(println (let [notrump (playTricky nil)]
  (and (= {:suit :club :rank 9}  (notrump [{:suit :club :rank 4}
                                           {:suit :club :rank 9}]))
       (= {:suit :spade :rank 2} (notrump [{:suit :spade :rank 2}
                                           {:suit :club :rank 10}])))))