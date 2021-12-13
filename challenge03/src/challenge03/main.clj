(ns challenge03.main
  (:use clojure.pprint)
  (:require [datomic.api :as d]
            [challenge03.db :as db]
            [challenge03.model :as model]))

;[clj-time.core :as t]

(pprint (def conn (db/connect-db)))
(db/create-schema conn)

(defn add-new-customer
  [customer]
  (d/transact conn [customer]))

(defn add-new-card
  [card]
  (d/transact conn [card]))

(def customer01
  (model/new-customer (model/uuid), "Déborah Viana", "999.999.999-90", "deborahviana@gmail.com"))
(def customer02
  (model/new-customer (model/uuid), "Edson Alves", "999.999.999-90", "edsonalves@gmail.com"))
(def customer03
  (model/new-customer (model/uuid), "João Vinícius", "999.999.999-90", "jaovinicius@gmail.com"))
(def customer04
  (model/new-customer (model/uuid), "Yure Galdino", "999.999.999-90", "yuregaldino@gmail.com"))
(def customer05
  (model/new-customer (model/uuid), "Flávia Passos",  "999.999.999-90", "flaviapassos@gmail.com"))
(def customer06
  (model/new-customer (model/uuid), "Caio Guedes",  "999.999.999-90", "caioguedes@gmail.com"))

; Fazendo as transações diretamente
(pprint @(d/transact conn [customer01, customer02, customer03, customer04, customer05]))

(pprint (add-new-customer customer06))
(pprint (db/all-customers (d/db conn)))

; Adicionando Cartoes
(def card01 (model/new-card (model/uuid), "4116289645868243", "861", "05/2026", 2500M, 2))
(def card02 (model/new-card (model/uuid), "4468703432396642", "431", "08/2025", 2500M, 30))
(def card03 (model/new-card (model/uuid), "4165282116099091", "245", "08/2024", 5500M, 24))
(def card04 (model/new-card (model/uuid), "4605996378527071", "872", "01/2030", 3000M, 25))
(def card05 (model/new-card (model/uuid), "4116289645868244", "862", "05/2027", 2600M, 20))

; Fazendo as transações diretamente
(pprint @(d/transact conn [card01, card02, card03, card04]))
(pprint (db/all-cards (d/db conn)))

(pprint (add-new-card card05))

;Adicionando cartoes ao cliente Caio
(pprint(d/transact conn [[:db/add
                          [:customer/id (:customer/id customer01)]
                          :customer/card
                          [:card/id (:card/id card01)]]]))
(pprint (db/one-customer (d/db conn) (:customer/id customer01)))

(pprint(d/transact conn [[:db/add
                          [:customer/id (:customer/id customer02)]
                          :customer/card
                          [:card/id (:card/id card02)]]]))
(pprint (db/one-customer (d/db conn) (:customer/id customer02)))

(pprint(d/transact conn [[:db/add
                          [:customer/id (:customer/id customer03)]
                          :customer/card
                          [:card/id (:card/id card03)]]]))
(pprint (db/one-customer (d/db conn) (:customer/id customer03)))

(pprint(d/transact conn [[:db/add
                          [:customer/id (:customer/id customer04)]
                          :customer/card
                          [:card/id (:card/id card04)]]]))
(pprint (db/one-customer (d/db conn) (:customer/id customer04)))

(pprint(d/transact conn [[:db/add
                          [:customer/id (:customer/id customer06)]
                          :customer/card
                          [:card/id (:card/id card05)]]]))
(pprint (db/one-customer (d/db conn) (:customer/id customer05)))

; Vendo todos os clientes após adicionar o cartão
(pprint (db/all-customers (d/db conn)))

(def p01 (model/new-purchase (model/uuid), "4116289645868243", "2021 11 11", 250M, "kabum", "eletronicos"))
(def p02 (model/new-purchase (model/uuid), "4116289645868243", "2021 10 8", 55M, "pizzaria", "restaurantes"))
(def p03 (model/new-purchase (model/uuid), "4116289645868243", "2021 11 3", 450M, "Magazine Luiza", "eletronicos"))
(def p04 (model/new-purchase (model/uuid), "4116289645868242", "2021 11 3", 250M, "Magazine Luiza", "eletronicos"))
(def p05 (model/new-purchase (model/uuid), "4116289645868242", "2021 10 8", 55M, "pizzaria", "restaurantes"))
(def p06 (model/new-purchase (model/uuid), "4165282116099091", "2021 11 25", 19.9M, "MCDonalds", "restaurantes"))
(def p07 (model/new-purchase (model/uuid), "4165282116099091", "2021 11 25", 19.9M, "MCDonalds", "restaurantes"))
(def p08 (model/new-purchase (model/uuid), "4165282116099091", "2021 10 8", 55M, "pizzaria", "restaurantes"))
(def p09 (model/new-purchase (model/uuid), "4619151675370080", "2021 11 26", 35M, "amazon", "livros"))
(def p10 (model/new-purchase (model/uuid), "4619151675370080", "2021 11 30", 180M, "bemais", "alimentacao"))
(def p11 (model/new-purchase (model/uuid), "4619151675370080", "2021 11 28", 55M, "pizzaria", "restaurantes"))
(def p12 (model/new-purchase (model/uuid), "4089929734127588", "2021 2 13", 45M, "Pague Menos", "saude"))
(def p13 (model/new-purchase (model/uuid), "4089929734127588", "2021 10 8", 55M, "pizzaria", "restaurantes"))

; Fazendo as transações diretamente
(pprint @(d/transact conn [p01, p02, p03, p04, p05, p06, p07, p08, p09, p10, p11, p12, p13]))
(pprint (db/all-purchases (d/db conn)))

(pprint(d/transact conn [[:db/add
                          [:customer/id (:customer/id customer01)]
                          :customer/purchase
                          [:purchase/id (:purchase/id p01)]]]))
(pprint (db/one-customer (d/db conn) (:customer/id customer01)))

(pprint(d/transact conn [[:db/add
                          [:customer/id (:customer/id customer01)]
                          :customer/purchase
                          [:purchase/id (:purchase/id p02)]]]))
(pprint (db/one-customer (d/db conn) (:customer/id customer01)))

(pprint(d/transact conn [[:db/add
                          [:customer/id (:customer/id customer02)]
                          :customer/purchase
                          [:purchase/id (:purchase/id p04)]]]))
(pprint (db/one-customer (d/db conn) (:customer/id customer02)))

(pprint (db/all-customers (d/db conn)))

(pprint (db/customer-without-purchase (d/db conn)))
;(pprint (db/delete-db))