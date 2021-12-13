(ns challenge03.db
  (:use clojure.pprint)
  (:require [datomic.api :as d]))

(def db-uri "datomic:dev://localhost:4334/challengeysc")

(defn connect-db []
  (d/create-database db-uri)
  (d/connect db-uri))

(defn delete-db []
  (d/delete-database db-uri))

(def schema [{:db/ident        :customer/id
              :db/valueType    :db.type/uuid
              :db/cardinality  :db.cardinality/one
              :db/unique       :db.unique/identity}
             {:db/ident        :customer/name
              :db/valueType    :db.type/string
              :db/cardinality  :db.cardinality/one}
             {:db/ident        :customer/CPF
              :db/valueType    :db.type/string
              :db/cardinality  :db.cardinality/one}
             {:db/ident        :customer/email
              :db/valueType    :db.type/string
              :db/cardinality  :db.cardinality/one}
             {:db/ident        :customer/card
              :db/valueType    :db.type/ref
              :db/cardinality  :db.cardinality/one}
             {:db/ident        :customer/purchase
              :db/valueType    :db.type/ref
              :db/cardinality  :db.cardinality/many}

             {:db/ident       :card/id
              :db/valueType   :db.type/uuid
              :db/cardinality :db.cardinality/one
              :db/unique      :db.unique/identity}
             {:db/ident       :card/number
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}
             {:db/ident       :card/CVV
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}
             {:db/ident       :card/validate
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}
             {:db/ident       :card/limit
              :db/valueType   :db.type/bigdec
              :db/cardinality :db.cardinality/one}
             {:db/ident       :card/closing-date
              :db/valueType   :db.type/long
              :db/cardinality :db.cardinality/one}

             {:db/ident       :purchase/id
              :db/valueType   :db.type/uuid
              :db/cardinality :db.cardinality/one
              :db/unique      :db.unique/identity}
             {:db/ident       :purchase/card-number
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}
             {:db/ident       :purchase/date
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}
             {:db/ident       :purchase/amount
              :db/valueType   :db.type/bigdec
              :db/cardinality :db.cardinality/one}
             {:db/ident       :purchase/establishment
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}
             {:db/ident       :purchase/category
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}])

(defn create-schema [conn]
  (d/transact conn schema))

(defn all-customers [db]
  (d/q '[:find (pull ?entity [*])
         :where [?entity :customer/name]] db))

(defn all-cards [db]
  (d/q '[:find (pull ?entity [*])
         :where [?entity :card/number]] db))

(defn all-purchases [db]
  (d/q '[:find (pull ?entity [*])
         :where [?entity :card/number]] db))

(defn one-customer [db customer-id]
  (d/pull db '[*] [:customer/id customer-id]))