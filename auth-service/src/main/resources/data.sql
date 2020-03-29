CREATE EXTENSION pgcrypto;

-- add some users
INSERT INTO users (name, password) VALUES ('David', crypt('david_password', gen_salt('bf')));
INSERT INTO users (name, password) VALUES ('Admin', crypt('admin_password', gen_salt('bf')));
INSERT INTO users (name, password) VALUES ('Peter', crypt('peter_password', gen_salt('bf')));

-- add book-service client
INSERT INTO oauth_client_details (client_id, client_secret, scope, authorized_grant_types,
                                  web_server_redirect_uri, authorities, access_token_validity,
                                  refresh_token_validity, additional_information, autoapprove)
VALUES ("book-service", crypt('bookServiceSecret', gen_salt('bf')), "server",
        "password", null, "read,write,update", 36000, 36000, null, "true");

-- add music-service client
INSERT INTO oauth_client_details (client_id, client_secret, scope, authorized_grant_types,
                                  web_server_redirect_uri, authorities, access_token_validity,
                                  refresh_token_validity, additional_information, autoapprove)
VALUES ("music-service", crypt('musicServiceSecret', gen_salt('bf')), "server",
        "password", null, "read,write,update", 36000, 36000, null, "true");

-- add movie-service client
INSERT INTO oauth_client_details (client_id, client_secret, scope, authorized_grant_types,
                                  web_server_redirect_uri, authorities, access_token_validity,
                                  refresh_token_validity, additional_information, autoapprove)
VALUES ("movie-service", crypt('movieServiceSecret', gen_salt('bf')), "server",
        "password", null, "read,write,update", 36000, 36000, null, "true");

-- add game-service client
INSERT INTO oauth_client_details (client_id, client_secret, scope, authorized_grant_types,
                                  web_server_redirect_uri, authorities, access_token_validity,
                                  refresh_token_validity, additional_information, autoapprove)
VALUES ("game-service", crypt('gameServiceSecret', gen_salt('bf')), "server",
        "password", null, "read,write,update", 36000, 36000, null, "true");

-- add statistic-service client
INSERT INTO oauth_client_details (client_id, client_secret, scope, authorized_grant_types,
                                  web_server_redirect_uri, authorities, access_token_validity,
                                  refresh_token_validity, additional_information, autoapprove)
VALUES ("statistic-service", crypt('statisticServiceSecret', gen_salt('bf')), "server",
        "password", null, "read,write,update", 36000, 36000, null, "true");
