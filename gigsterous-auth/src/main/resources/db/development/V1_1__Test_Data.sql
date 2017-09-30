INSERT INTO users (user_id, email, password, enabled) VALUES 
	('1', 'peter@hotmail.com', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', true),
	('2', 'john@email.cz', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', true);

INSERT INTO oauth_client_details (client_id, resource_ids, client_secret, scope,
authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity,
refresh_token_validity, additional_information, autoapprove) VALUES
	('gigsterous', 'resource', 'secret', 'read,write',
	'authorization_code,refresh_token,implicit,password,client_credentials', '',
	'', 3600, 2592000, '{}', 'true');