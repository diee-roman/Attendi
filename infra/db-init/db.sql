CREATE TABLE partner
(
    id  SERIAL NOT NULL,
    name   VARCHAR(50) NOT NULL,
    email      VARCHAR(255) UNIQUE NOT NULL,
    created_on  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    active  BOOLEAN NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE customer
(
    id  SERIAL NOT NULL,
    partner_id integer NOT NULL,
    name     VARCHAR(100) NOT NULL ,
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    active BOOLEAN NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_partner
        FOREIGN KEY(partner_id)
            REFERENCES partner(id)
);

CREATE TABLE api_key
(
    id SERIAL NOT NULL,
    customer_id integer NOT NULL,
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    key VARCHAR(32) NOT NULL,
    active BOOLEAN NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_customer
        FOREIGN KEY(customer_id)
            REFERENCES customer(id)
);

INSERT INTO public.partner (name, email, created_on, active)
VALUES ('Partner1', 'prtnr1@prtnr.com', '2022-02-18 19:46:57.000000', true);
INSERT INTO public.partner (name, email, created_on, active)
VALUES ('Partner2', 'prtnr2@prtnr.com', '2022-02-20 19:46:57.000000', false);
