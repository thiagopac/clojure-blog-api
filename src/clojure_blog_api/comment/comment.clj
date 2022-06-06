(ns clojure-blog-api.comment.comment
    (:require [korma.db :refer :all]
              [korma.core :refer :all]
              [clojure-blog-api.db :refer :all]))
  
  (defentity comment)

  (defn find-all-for-article [id]
    (select comment
      (where {:id id})))
  
  (defn create [article_id author text]
    (insert comment
      (values {:article_id article_id :author author :text text})))
  
  (defn delete-by-id [id]
    (delete comment
      (where {:id id})))