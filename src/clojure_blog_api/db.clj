(ns clojure-blog-api.db
    (:use korma.db))
  
    (defdb db (mysql
              { :classname "com.mysql.jdbc.Driver"
                :subprotocol "mysql"
                :subname "//localhost/clojure_blog_api"
                :user "web_user"
                :password "web_userPASS"}))