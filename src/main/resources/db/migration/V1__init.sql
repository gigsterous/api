DROP TABLE IF EXISTS users;
CREATE TABLE users (
    user_id BIGINT auto_increment,
    first_name VARCHAR(32),
    last_name VARCHAR(32),
    email VARCHAR(128) UNIQUE,
    gender VARCHAR(8),
    PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS ensembles;
CREATE TABLE ensembles(
    ensemble_id BIGINT auto_increment,
    name VARCHAR(32),
    PRIMARY KEY (ensemble_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS users_ensembles;
CREATE TABLE users_ensembles (
  user_id BIGINT NOT NULL,
  ensemble_id BIGINT NOT NULL,
  PRIMARY KEY (user_id, ensemble_id),
  CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (user_id),
  CONSTRAINT fk_ensemble FOREIGN KEY (ensemble_id) REFERENCES ensembles (ensemble_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



