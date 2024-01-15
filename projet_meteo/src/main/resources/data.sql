DROP TABLE villes IF EXISTS;
CREATE TABLE villes (
    name VARCHAR(250) PRIMARY KEY,
    departement VARCHAR(250)
);
INSERT INTO villes(departement, name) VALUES ('hauts-de-france', 'Lille');
INSERT INTO villes(departement, name) VALUES ('ile-de-france','Paris');
INSERT INTO villes(departement, name) VALUES ('nouvelle aquitaine', 'Bordeaux');