(defproject clojure-blog-api "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-json "0.4.0"]
                 [korma "0.4.3"]
                 [mysql/mysql-connector-java "5.1.6"]]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler clojure-blog-api.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]]}})
