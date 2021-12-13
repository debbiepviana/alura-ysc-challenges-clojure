(ns challenge03.model)

(defn uuid [] (java.util.UUID/randomUUID))

(defn new-customer [uuid name CPF email]
  {:customer/id     uuid
   :customer/name   name
   :customer/CPF    CPF
   :customer/email  email})

(defn new-card [uuid number CVV validate limit closing-date]
  {:card/id            uuid
   :card/number        number
   :card/CVV           CVV
   :card/validate      validate
   :card/limit         limit
   :card/closing-date  closing-date})

(defn new-purchase [uuid card-number date amount establishment category]
  {:purchase/id             uuid
   :purchase/card-number    card-number
   :purchase/date           date
   :purchase/amount         amount
   :purchase/establishment  establishment
   :purchase/category       category})