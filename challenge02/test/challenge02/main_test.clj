(ns challenge02.main-test
  (:require [clojure.test :refer :all]
            [challenge02.main :refer :all]
            [challenge02.db :as c.db]))

(def purchases-test (c.db/all-purchases))

(deftest purchases-by-category-test
  (testing "Que existe compras no agrupamento"
    (is (> (count (purchases-by-category purchases-test)) 0)))
  (testing "Que retorna vazio quando não há agrupamentos"
    (is (empty? (purchases-by-category {})))))