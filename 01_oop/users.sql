CREATE TABLE users (
    id integer primary key autoincrement,
    name varchar(20) not null unique,
    password varchar(200) not null,
    email varchar(200) unique,
    firstname varchar(50) not null,
    lastname varchar(50) not null,
    remember_token varchar(200) default null
);

INSERT INTO users VALUES
(1,'bidkar','123','bidkar.aragon@udo.mx','Bidkar','Aragón Cárdenas',NULL);