INSERT INTO people (person_id, first_name, last_name, email, gender, location, date_birth) VALUES 
	('1', 'Peter', 'Smith', 'peter@hotmail.com', 'MALE', 'London', '1980-04-08'),
	('2', 'John', 'Doe', 'john@email.cz', 'MALE', 'London', '1985-06-12'),
	('3', 'Gandalf', 'Grey', 'grey@gmail.com', 'MALE', 'New York', '1990-03-01'),
	('4', 'Gandal', 'White', 'white@gmail.com', 'MALE', 'Mordor', '1978-06-06'),
	('5', 'Aragorn', 'Paragon', 'aragorn@email.cz', 'MALE', 'Rohan', '1982-01-08'),
	('6', 'Samuel', 'Jaxon', 'jaxon@hotmail.com', 'MALE', 'Prague', '1987-11-25'),
	('7', 'Leopold', 'Janacek', 'leo.janak@seznam.cz', 'MALE', 'Prague', '1995-08-28'),
	('8', 'Sue', 'Widow', 'sue@email.com', 'FEMALE', 'Prague', '1967-10-12');
	
INSERT INTO ensembles (ensemble_id, ensemble_type, name) VALUES 
	('1', 'BAND', 'Skull Crashers'),
	('2', 'ORCHESTRA', 'Abortion Orchestra'),
	('3', 'BAND', 'Lalas');
	
INSERT INTO people_ensembles (person_id, ensemble_id) VALUES 
	('1', '1'),
	('2', '1'),
	('3', '1'),
	('3', '2'),
	('4', '2'),
	('4', '3'),
	('5', '2'),
	('6', '3');
	
INSERT INTO skills (person_id, instrument, level) VALUES 
	('1', 'GUITAR', 'BEGINNER'),
	('2', 'BASS', 'ADVANCED'),
	('3', 'DRUMS', 'BEGINNER'),
	('3', 'PIANO', 'PROFESSIONAL'),
	('4', 'GUITAR', 'ADVANCED'),
	('4', 'VIOLIN', 'BEGINNER'),
	('5', 'DRUMS', 'PROFESSIONAL'),
	('6', 'BASS', 'ADVANCED');
	
INSERT INTO events (event_id, venue, name, event_date) VALUES 
	('1', 'Vagon', 'Hard Rock Night', '2016-12-01 20:00:00'),
	('2', 'Rudolfinum', 'Christmas Chill', '2016-12-24 19:00:00');
	
INSERT INTO people_events (person_id, event_id) VALUES 
	('1', '1'),
	('2', '1'),
	('3', '2'),
	('4', '2');
