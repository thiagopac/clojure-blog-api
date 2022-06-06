CREATE DATABASE IF NOT EXISTS clojure_blog_api;
USE clojure_blog_api;

-- --------------------------------------------------------

CREATE TABLE `article` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `text` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `article_id` int(11) NOT NULL,
  `author` varchar(255) NOT NULL,
  `text` varchar(500) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `article`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `article`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `comment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
