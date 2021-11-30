(ns challenge01.logic
  (:require [clj-time.core :as t]
            [clj-time.local :as l]))

; Valor total das compras passadas como parametro
(defn total-purchases
  [purchases]
  (->> purchases
       (map :amount)
       (reduce +)))

; Total de Compras por Categoria
(defn all-purchases-by-category
  [[category purchases]]
  {:category category
   :total (total-purchases purchases)})

; Verificando se o numero do cartão bate
(defn my-equal?
  [customer card-number]
  (= card-number (:number (:card customer))))

; Procurando a qual cliente pertence o cartão
(defn who-owns-the-card?
  [card-number customers]
  (->> customers
       (filter #(my-equal? % card-number))
       (vec)))

; Descobrindo quando foi o último dia de fechamento da fatura
(defn last-invoice-closing
  [[customer]]
  (let
    [closing-date (:closing-date (:card customer))
     today (l/local-now)
     today-day (t/day (l/local-now))]

    (if (> today-day closing-date)
      (t/date-time (t/year today) (t/month today) closing-date)            ; se maior, mês atual
      (t/date-time (t/year today) (- (t/month today) 1) closing-date))))   ; se não, mês passado

; Verificando se a compra esta dentro da fatura
(defn within-the-time-span
  [closing-date purchase]

  (let [today (l/local-now)
        purchase-date (:date purchase)]
    (and (t/after? purchase-date closing-date)
         (t/before? purchase-date today))))

; Fatura de cada cliente
(defn invoice-card
  [[card-number purchases] customers]

  (let [customer (who-owns-the-card? card-number customers)
        closing-date (last-invoice-closing customer)
        invoice-purchases (filter #(within-the-time-span closing-date %) purchases) ]
    {:customer (:name (first customer))
     :invoice (total-purchases invoice-purchases)}))

; (defn compras-por-cliente)
; (defn total-das-compras)
; (defn total-por-cliente)
; (defn filtrar-por-categoria)
; (defn total-por-categoria)
; (defn buscar-por-valor-ou-estabelecimento)
; (defn fatura-do-cliente)