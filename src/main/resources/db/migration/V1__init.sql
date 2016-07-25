DROP TABLE IF EXISTS `users`;
CREATE TABLE users (
    id BIGINT auto_increment,
    first_name VARCHAR(32),
    last_name VARCHAR(32),
    email VARCHAR(128) UNIQUE,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `ensembles`;
CREATE TABLE ensembles(
    id BIGINT auto_increment,
    name VARCHAR(32),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
