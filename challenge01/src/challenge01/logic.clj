(ns challenge01.logic)

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
