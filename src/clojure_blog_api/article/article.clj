(ns clojure-blog-api.article.article
    (:require [korma.db :refer :all]
              [korma.core :refer :all]
              [clojure-blog-api.db :refer :all]
              [clojure-blog-api.comment.comment :as comment]))
  
  (defentity comment)
  (defentity article (has-many comment))


  (defn find-all []
    (select article (with comment)))
  
  (defn find-by-id [id]
      (select article
        (where {:id id})
        (limit 1) (with comment)))
  
  (defn create [name text]
    (insert article
      (values {:name name :text text})))
  
  (defn update-by-id [id name text]
    (update article
      (set-fields {:name name :text text})
      (where {:id id})))
  
  (defn delete-by-id [id]
    (delete article
      (where {:id id})))