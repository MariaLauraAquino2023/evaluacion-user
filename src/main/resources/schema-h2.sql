CREATE TABLE USERS (
    id UUID PRIMARY KEY,
    name VARCHAR(300),
    email VARCHAR(150),
    password VARCHAR(100),
    created TIMESTAMP,
    modified TIMESTAMP,
    last_login TIMESTAMP,
    access_token  CHARACTER LARGE OBJECT,
    is_active BOOLEAN
);

CREATE TABLE PHONES (
    id UUID PRIMARY KEY,
    user_id UUID,
    number VARCHAR(100),
    city_code VARCHAR(50),
    country_code VARCHAR(50)
);

ALTER TABLE PHONES ADD FOREIGN KEY (user_id) REFERENCES USERS(id);
