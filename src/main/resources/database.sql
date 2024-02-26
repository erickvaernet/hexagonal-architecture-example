CREATE DATABASE hexagonalDb;
USE hexagonalDb;

CREATE TABLE product_statuses (
                                  id INT IDENTITY(1,1) PRIMARY KEY,
                                  name VARCHAR(255)
);

CREATE TABLE products (
                          id BIGINT IDENTITY(1,1) PRIMARY KEY,
                          name VARCHAR(255),
                          status_id INT,
                          quantity INT,
                          price DOUBLE PRECISION,
                          FOREIGN KEY (status_id) REFERENCES product_statuses(id)
);

INSERT INTO product_statuses (name) VALUES ('AVAILABLE');
INSERT INTO product_statuses (name) VALUES ('UNAVAILABLE');