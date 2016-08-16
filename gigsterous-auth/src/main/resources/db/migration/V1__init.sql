/* USERS */
DROP TABLE IF EXISTS users;
CREATE TABLE users (
    user_id BIGINT PRIMARY KEY auto_increment,
    email VARCHAR(128) UNIQUE,
    username VARCHAR(32) UNIQUE,
    password VARCHAR(32),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;