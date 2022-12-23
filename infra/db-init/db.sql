CREATE TABLE partner
(
    id  SERIAL PRIMARY KEY NOT NULL,
    name   VARCHAR(50) NOT NULL,
    email      VARCHAR(255) UNIQUE NOT NULL,
    created_on  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    active  BOOLEAN NOT NULL
);

CREATE TABLE customer
(
    id  SERIAL PRIMARY KEY NOT NULL,
    name     VARCHAR(100) NOT NULL ,
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    active BOOLEAN NOT NULL
);

CREATE TABLE api_key
(
    id SERIAL PRIMARY KEY NOT NULL,
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    key VARCHAR(32) NOT NULL,
    active BOOLEAN NOT NULL
);

INSERT INTO public.partner (id, name, email, created_on, active)
VALUES (1, 'Partner1', 'prtnr1@prtnr.com', '2022-02-18 19:46:57.000000', true);
INSERT INTO public.partner (id, name, email, created_on, active)
VALUES (2, 'Partner2', 'prtnr2@prtnr.com', '2022-02-20 19:46:57.000000', false);