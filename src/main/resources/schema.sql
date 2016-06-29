CREATE TABLE users (
    id BIGINT auto_increment,
    name VARCHAR(32) UNIQUE,
    email VARCHAR(128),
    PRIMARY KEY (`id`)
);