(ns challenge01.main
  (:require [challenge01.db :as c.db]))

; Listas todos os Clientes
(println (c.db/all-customers))

; Listas todas as Compras
(println (c.db/all-purchases))