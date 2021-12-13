(defproject challenge03 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :repositories {"my.datomic.com" {:url "https://my.datomic.com/repo"
                                   :username "deborah.pereira@nubank.com.br"
                                   :password "55b1f0ba-eb36-4539-b644-bd4179ac69ac"}}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [com.datomic/datomic-pro "1.0.6344"]
                 [clj-time "0.15.2"]]
  :repl-options {:init-ns challenge03.core})
