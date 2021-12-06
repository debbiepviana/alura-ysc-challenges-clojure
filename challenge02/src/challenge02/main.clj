(ns challenge02.main
  (:require [challenge02.db :as c.db]
            [challenge02.logic :as c.logic]))

;Listas todos os Clientes
(println "LISTANDO TODOS OS CLIENTES\n" (c.db/all-customers) "\n")

;Listas todas as Compras
(defn all-purchases []
  (c.db/all-purchases))
(println "LISTANDO TODAS AS COMPRAS\n" all-purchases "\n")

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