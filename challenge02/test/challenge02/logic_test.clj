(ns challenge02.logic-test
  (:require [clojure.test :refer :all]
            [challenge02.logic :refer :all]
            [clj-time.core :as t]))

(def customer-test {:name    "Déborah Viana"
                    :CPF     "999.999.999-90"
                    :email   "deborahviana@gmail.com"
                    :card    {:number   "4116289645868243"
                              :CVV      "861"
                              :validate "05/2026"
                              :limit    2500.00
                              :closing-date 2}})

(def purchases-test [{:card-number   "4089929734127588"
                          :date          (t/date-time 2021 2 13)
                          :amount        45.00
                          :establishment "Pague Menos"
                          :category      "saude"},
                         {:card-number   "4089929734127588"
                          :date          (t/date-time 2021 10 8)
                          :amount        55.00
                          :establishment "pizzaria"
                          :category      "restaurantes"}])

(deftest my-equal?-test
  (testing "Que existe os números do cartões de crédito batem"
    (is (my-equal? customer-test "4116289645868243")))
  (testing "Que existe os números do cartões de crédito não são compatíveis"
    (is (not (my-equal? customer-test "4468703432396642"))))
  (testing "Que retorna false quando o customer não existe"
    (is (not (my-equal? {:name  "Yure Galdino"
                         :CPF   "900.009.909-09"
                         :email "yuregaldino@gmail.com"} "4116289645868243")))))

(deftest total-purchases-test
  (testing "Que o total das compras bata com o valor esperado"
    (is (== (total-purchases purchases-test) 100.0)))
  (testing "Que retorna 0 quando não há compras para somar"
    (is (== (total-purchases []) 0))))