INSERT INTO users (user_id, first_name, last_name, email) VALUES 
	('1', 'Peter', 'Smith', 'peter@hotmail.com'),
	('2', 'John', 'Doe', 'john@email.cz'),
	('3', 'Gandalf', 'Grey', 'grey@gmail.com'),
	('4', 'Gandal', 'White', 'white@gmail.com'),
	('5', 'Aragorn', 'Paragon', 'aragorn@email.cz'),
	('6', 'Samuel', 'Jaxon', 'jaxon@hotmail.com'),
	('7', 'Leopold', 'janacek', 'leo.janak@seznam.cz');
	
INSERT INTO ensembles (ensemble_id, name) VALUES 
	('1', 'Skull Crashers'),
	('2', 'Abortion Orchestra'),
	('3', 'Lalas');
	
INSERT INTO users_ensembles (user_id, ensemble_id) VALUES 
	('1', '1'),
	('2', '1'),
	('3', '1'),
	('3', '2'),
	('4', '2'),
	('4', '3'),
	('5', '2'),
	('6', '3');