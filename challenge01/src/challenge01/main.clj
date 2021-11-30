(ns challenge01.main
  (:require [challenge01.db :as c.db]
            [challenge01.logic :as c.logic]))

 ;Listas todos os Clientes
(println "LISTANDO TODOS OS CLIENTES\n" (c.db/all-customers) "\n")

 ;Listas todas as Compras
(println "LISTANDO TODAS AS COMPRAS\n" (c.db/all-purchases) "\n")

(def customers (c.db/all-customers))
(def purchases (c.db/all-purchases))

; Valor dos gastos agrupados por categoria;
(->> purchases
     (group-by :category)
     (map c.logic/all-purchases-by-category)
     (println "COMPRAS POR CATEGORIAL\n"))

(println "\n")

; Calcular a fatura aberta de cada cliente
(->> purchases
     (group-by :card-number)
     (map #(c.logic/invoice-card % customers))
     (println "FATURA POR CLIENTE\n"))