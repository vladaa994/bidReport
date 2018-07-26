DROP TABLE IF EXISTS "user";
CREATE TABLE "user"(
  id SERIAL PRIMARY KEY ,
  username VARCHAR(255) NOT NULL ,
  firstname VARCHAR(255) NOT NULL ,
  lastname VARCHAR(255) NOT NULL ,
  password VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS client;
CREATE TABLE client(
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  street VARCHAR(255) NOT NULL,
  pib INT NOT NULL
);

DROP TABLE IF EXISTS report;
CREATE TABLE report(
  id SERIAL PRIMARY KEY,
  owner_name VARCHAR(255) NOT NULL,
  owner_street VARCHAR(255) NOT NULL,
  owner_website VARCHAR(255),
  phone INT NOT NULL,
  fax int,
  pib int NOT NULL,
  bank_account VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  report_number int NOT NULL,
  report_year INT NOT NULL,
  report_note VARCHAR(255) NOT NULL,
  sum_price DECIMAL NOT NULL,
  pdv_value DECIMAL NOT NULL,
  sum_pdv DECIMAL NOT NULL,
  client_id INT NOT NULL,
  report_content_id INT NOT NULL,
  user_id INT NOT NULL
);

DROP TABLE IF EXISTS report_content;
CREATE TABLE report_content(
  id SERIAL PRIMARY KEY,
  serial_number int,
  content VARCHAR(600) NOT NULL ,
  qty int NOT NULL,
  unit_measure VARCHAR(10) NOT NULL,
  price_per_measure DECIMAL NOT NULL
);

alter table report add foreign key (client_id) REFERENCES client(id);
alter table report add foreign key (report_content_id) REFERENCES report_content(id);
alter table report add foreign key (user_id) REFERENCES "user"(id);