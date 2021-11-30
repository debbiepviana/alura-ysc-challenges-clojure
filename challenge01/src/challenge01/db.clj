(ns challenge01.db)

(def customers01 {:name    "Déborah Viana"
                  :CPF     "999.999.999-90"
                  :email   "deborahviana@gmail.com"
                  :card    {:number   "4116289645868243"
                            :CVV      "861"
                            :validate "05/2026"
                            :limit    2500.00}})

(def customers02 {:name  "Yure Galdino"
                  :CPF   "900.009.909-09"
                  :email "yuregaldino@gmail.com"})

(def customers03 {:name    "Edson Alves"
                  :CPF     "999.999.999-90"
                  :email   "deborahviana@gmail.com"
                  :card    {:number   "4468703432396642"
                            :CVV      "431"
                            :validate "08/2025"
                            :limit    2500.00}})

(def customers04 {:name    "Flávia Passos"
                  :CPF     "123.234.345-56"
                  :email   "flavoca@gmail.com"
                  :card    {:number   "4165282116099091"
                            :CVV      "245"
                            :validate "08/2024"
                            :limit    5500.00}})

(def customers05 {:name    "Caio Guedes"
                  :CPF     "234.345.567-78"
                  :email   "caioguedes@gmail.com"
                  :card    {:number   "4605996378527071"
                            :CVV      "872"
                            :validate "01/2030"
                            :limit    3500.00}})

(def customers06 {:name    "Bárbara Maria"
                  :CPF     "987.765.654-43"
                  :email   "barbaramaria@gmail.com"
                  :card    {:number   "4619151675370080"
                            :CVV      "185"
                            :validate "03/2028"
                            :limit    2500.00}})

(def customers07 {:name  "Amon Toca"
                  :CPF   "915.008.000-90"
                  :email "amontoca@gmail.com"})

(def customers08 {:name   "João Vinícius"
                  :CPF    "588.543.653-94"
                  :email  "joaovinicius@gmail.com"
                  :card   {:number   "4089929734127588"
                           :CVV      "209"
                           :validate "07/2029"
                           :limit    2500.00}})

(defn all-customers []
  [customers01, customers02, customers03, customers04, customers05, customers06, customers07, customers08])

(def p01 {:card-number   "4116289645868243"
          :date          "11/11/2021"
          :amount        250.00
          :establishment "kabum"
          :category      "eletronicos"})

(def p02 {:card-number   "4116289645868243"
          :date          "08/10/2021"
          :amount        55.00
          :establishment "pizzaria"
          :category      "restaurantes"})

(def p03 {:card-number   "4468703432396642"
          :date          "03/11/2021"
          :amount        450.00
          :establishment "Magazine Luiza"
          :category      "informatica"})

(def p04 {:card-number   "4468703432396642"
          :date          "08/10/2021"
          :amount        55.00
          :establishment "pizzaria"
          :category      "restaurantes"})

(def p05 {:card-number   "4165282116099091"
          :date          "01/05/2020"
          :amount        19.90
          :establishment "MCDonalds"
          :category      "restaurantes"})

(def p06 {:card-number   "4165282116099091"
          :date          "08/10/2021"
          :amount        55.00
          :establishment "pizzaria"
          :category      "restaurantes"})

(def p07 {:card-number   "4619151675370080"
          :date          "18/09/2020"
          :amount        35.00
          :establishment "amazon"
          :category      "livros"})

(def p08 {:card-number   "4619151675370080"
          :date          "30/07/2019"
          :amount        180.00
          :establishment "bemais"
          :category      "alimentacao"})

(def p09 {:card-number   "4619151675370080"
          :date          "08/10/2021"
          :amount        55.00
          :establishment "pizzaria"
          :category      "restaurantes"})

(def p10 {:card-number   "4089929734127588"
          :date          "13/02/2019"
          :amount        45.00
          :establishment "Pague Menos"
          :category      "saude"})

(def p11 {:card-number   "4089929734127588"
          :date          "08/10/2021"
          :amount        55.00
          :establishment "pizzaria"
          :category      "restaurantes"})

(defn all-purchases []
  [p01, p02, p03, p04, p05, p06, p07, p08, p09, p10, p11])
