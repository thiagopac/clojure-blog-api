(ns clojure-blog-api.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clojure-blog-api.article.article :as article]
            [clojure-blog-api.comment.comment :as comment]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body]]))

(defroutes all-routes
  (GET "/articles" []
    (article/find-all))
  (POST "/article" req
    (let [name (get-in req [:body "name"])
          text (get-in req [:body "text"])]
          (article/create name text)))
  (GET "/article/:id" [id]
    (article/find-by-id id))
  (PUT "/article/:id" req
    (let [id (read-string (get-in req [:params :id]))
          name (get-in req [:body "name"])
          text (get-in req [:body "text"])]
          (article/update-by-id id name text)
          (article/find-by-id id)))
  (DELETE "/article/:id" [id]
    (article/delete-by-id id)
    (str "Deleted article " id))

  (GET "/:id/comments" [id]
    (comment/find-all-for-article id))
  (POST "/comment" req
    (let [article_id (get-in req [:body "article_id"])
          author (get-in req [:body "author"])
          text (get-in req [:body "text"])]
          (comment/create article_id author text)))
  (DELETE "/comment/:id" [id]
    (comment/delete-by-id id)
    (str "Deleted comment " id))
  (route/not-found "Not Found"))
  
(def app
  (-> all-routes
      wrap-json-response
      wrap-json-body))