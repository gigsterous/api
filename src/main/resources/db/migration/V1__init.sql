CREATE TABLE users (
    id BIGINT auto_increment,
    name VARCHAR(32) UNIQUE,
    email VARCHAR(128),
    PRIMARY KEY (`id`)
);

INSERT INTO users (id, name, email) VALUES 
	('1', 'Peter', 'peter@hotmail.com'),
	('2', 'John', 'john@email.cz');
