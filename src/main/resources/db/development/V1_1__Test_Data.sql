INSERT INTO users (user_id, first_name, last_name, email, gender) VALUES 
	('1', 'Peter', 'Smith', 'peter@hotmail.com', 'MALE'),
	('2', 'John', 'Doe', 'john@email.cz', 'MALE'),
	('3', 'Gandalf', 'Grey', 'grey@gmail.com', 'MALE'),
	('4', 'Gandal', 'White', 'white@gmail.com', 'MALE'),
	('5', 'Aragorn', 'Paragon', 'aragorn@email.cz', 'MALE'),
	('6', 'Samuel', 'Jaxon', 'jaxon@hotmail.com', 'MALE'),
	('7', 'Leopold', 'Janacek', 'leo.janak@seznam.cz', 'MALE'),
	('8', 'Sue', 'Widow', 'sue@email.com', 'FEMALE');
	
INSERT INTO ensembles (ensemble_id, ensemble_type, name) VALUES 
	('1', 'BAND', 'Skull Crashers'),
	('2', 'ORCHESTRA', 'Abortion Orchestra'),
	('3', 'BAND', 'Lalas');
	
INSERT INTO users_ensembles (user_id, ensemble_id) VALUES 
	('1', '1'),
	('2', '1'),
	('3', '1'),
	('3', '2'),
	('4', '2'),
	('4', '3'),
	('5', '2'),
	('6', '3');
	
INSERT INTO skills (user_id, instrument, level) VALUES 
	('1', 'GUITAR', 'BEGINNER'),
	('2', 'BASS', 'ADVANCED'),
	('3', 'DRUMS', 'BEGINNER'),
	('3', 'PIANO', 'PROFESSIONAL'),
	('4', 'GUITAR', 'ADVANCED'),
	('4', 'VIOLIN', 'BEGINNER'),
	('5', 'DRUMS', 'PROFESSIONAL'),
	('6', 'BASS', 'ADVANCED');