
INSERT INTO city(departement, name) VALUES ('hauts-de-france', 'Lille');
INSERT INTO city(departement, name) VALUES ('ile-de-france','Paris');
INSERT INTO city(departement, name) VALUES ('nouvelle aquitaine', 'Bordeaux');

create table user (id integer not null primary key, name varchar(255), password varchar(255));

INSERT INTO user(`name`,`password`,'id') VALUES ('admin','admin',1);
INSERT INTO user(`name`,`password`,'id') VALUES ('malo','malo',2);