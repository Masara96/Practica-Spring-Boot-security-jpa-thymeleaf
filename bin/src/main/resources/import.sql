/* Populate tables */
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Martin', 'Sara', 'martin@practica.com', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Natalia', 'Fulana', 'martin@practica.com', '2021-04-02', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Amadeo', 'Mengana', 'martin@practica.com', '2002-08-03', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Tomas', 'Sultana', 'martin@practica.com', '1994-08-04', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Josefina', 'Ingana', 'martin@practica.com', '1996-08-05', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Agustina', 'Engana', 'martin@practica.com', '1954-08-06', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Maria', 'Bengana', 'martin@practica.com', '1997-08-07', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Ramon', 'Jonada', 'martin@practica.com', '1994-08-08', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Roberta', 'Quesada', 'martin@practica.com', '1925-08-09', '');


/* Populate tabla productos */
INSERT INTO productos (nombre, precio, create_at) VALUES('SONY PANTALLA PLANA', 25990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('NOBLEX TELEFONO', 14349, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('NOTEBOOK DELL', 14990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('TELEFONO MOTOROLA E6', 3990, NOW());


/* Creamos algunas facturas */
INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura cosas', null, 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 3);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 2);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura random', 'Observacion', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 2);


INSERT INTO users (username,password,enabled) VALUES ('martin','$2a$10$pDZ.jALuKpMkWysprXquGOihMi.jmDCgiF7pKAA9.ud/ZsBpDSqem',1);
INSERT INTO users (username,password,enabled) VALUES ('admin','$2a$10$NfxB4gK29Pl0u/CyJMqQvu5TDH9Y4tLyv973ZslWrR/NavbXxyMLy',1);

INSERT INTO authorities (user_id,authority) VALUES (1,'ROLE_USER');
INSERT INTO authorities (user_id,authority) VALUES (2,'ROLE_ADMIN');
INSERT INTO authorities (user_id,authority) VALUES (2,'ROLE_USER');