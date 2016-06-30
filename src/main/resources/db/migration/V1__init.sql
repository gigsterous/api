CREATE TABLE users (
    id BIGINT auto_increment,
    first_name VARCHAR(32),
    last_name VARCHAR(32),
    email VARCHAR(128) UNIQUE,
    PRIMARY KEY (`id`)
);
