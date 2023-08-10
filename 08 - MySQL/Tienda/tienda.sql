DROP DATABASE IF EXISTS tienda;
CREATE DATABASE tienda CHARACTER SET utf8mb4;
USE tienda;

CREATE TABLE fabricante (
  codigo INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL
);

CREATE TABLE producto (
  codigo INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  precio DOUBLE NOT NULL,
  codigo_fabricante INT UNSIGNED NOT NULL,
  FOREIGN KEY (codigo_fabricante) REFERENCES fabricante(codigo)
);

INSERT INTO fabricante VALUES(1, 'Asus');
INSERT INTO fabricante VALUES(2, 'Lenovo');
INSERT INTO fabricante VALUES(3, 'Hewlett-Packard');
INSERT INTO fabricante VALUES(4, 'Samsung');
INSERT INTO fabricante VALUES(5, 'Seagate');
INSERT INTO fabricante VALUES(6, 'Crucial');
INSERT INTO fabricante VALUES(7, 'Gigabyte');
INSERT INTO fabricante VALUES(8, 'Huawei');
INSERT INTO fabricante VALUES(9, 'Xiaomi');

INSERT INTO producto VALUES(1, 'Disco duro SATA3 1TB', 86.99, 5);
INSERT INTO producto VALUES(2, 'Memoria RAM DDR4 8GB', 120, 6);
INSERT INTO producto VALUES(3, 'Disco SSD 1 TB', 150.99, 4);
INSERT INTO producto VALUES(4, 'GeForce GTX 1050Ti', 185, 7);
INSERT INTO producto VALUES(5, 'GeForce GTX 1080 Xtreme', 755, 6);
INSERT INTO producto VALUES(6, 'Monitor 24 LED Full HD', 202, 1);
INSERT INTO producto VALUES(7, 'Monitor 27 LED Full HD', 245.99, 1);
INSERT INTO producto VALUES(8, 'Portátil Yoga 520', 559, 2);
INSERT INTO producto VALUES(9, 'Portátil Ideapd 320', 444, 2);
INSERT INTO producto VALUES(10, 'Impresora HP Deskjet 3720', 59.99, 3);
INSERT INTO producto VALUES(11, 'Impresora HP Laserjet Pro M26nw', 180, 3);

SELECT * FROM FABRICANTE RIGHT JOIN PRODUCTO ON FABRICANTE.CODIGO = PRODUCTO.CODIGO;
/* 1. Lista el nombre de todos los productos que hay en la tabla producto. */
SELECT NOMBRE FROM PRODUCTO;
SELECT * FROM PRODUCTO;
SELECT * FROM FABRICANTE;
/* 2. Lista los nombres y los precios de todos los productos de la tabla producto. */
SELECT NOMBRE, PRECIO FROM PRODUCTO;
/* 3. Lista todas las columnas de la tabla producto. */
SELECT * FROM PRODUCTO;
/* 4. Lista los nombres y los precios de todos los productos de la tabla producto, redondeando el valor del precio.*/
SELECT NOMBRE, ROUND(PRECIO) FROM PRODUCTO;
/* 5. Lista el código de los fabricantes que tienen productos en la tabla producto. */
SELECT CODIGO_FABRICANTE FROM PRODUCTO;
/* 6. Lista el código de los fabricantes que tienen productos en la tabla producto, sin mostrar los repetidos. */
SELECT CODIGO_FABRICANTE FROM PRODUCTO GROUP BY CODIGO_FABRICANTE;
SELECT DISTINCT CODIGO_FABRICANTE FROM PRODUCTO;
/* 7. Lista los nombres de los fabricantes ordenados de forma ascendente. */
SELECT NOMBRE FROM FABRICANTE ORDER BY NOMBRE;
/* 8. Lista los nombres de los productos ordenados en primer lugar por el nombre de forma ascendente y en segundo lugar por el precio de forma descendente. */
SELECT NOMBRE, PRECIO FROM PRODUCTO ORDER BY NOMBRE;
SELECT NOMBRE, PRECIO FROM PRODUCTO ORDER BY PRECIO DESC;
SELECT NOMBRE, PRECIO FROM PRODUCTO ORDER BY NOMBRE, PRECIO DESC;
/* 9. Devuelve una lista con las 5 primeras filas de la tabla fabricante. */
SELECT * FROM FABRICANTE LIMIT 5;
/* 10. Lista el nombre y el precio del producto más barato. (Utilice solamente las cláusulas ORDER BY y LIMIT) */
SELECT NOMBRE, PRECIO FROM PRODUCTO ORDER BY PRECIO LIMIT 1;
/* 11. Lista el nombre y el precio del producto más caro. (Utilice solamente las cláusulas ORDER BY y LIMIT) */
SELECT NOMBRE, PRECIO FROM PRODUCTO ORDER BY PRECIO DESC LIMIT 1;
/* 12. Lista el nombre de los productos que tienen un precio menor o igual a $120. */
SELECT NOMBRE, PRECIO FROM PRODUCTO WHERE PRECIO <= 120;
/* 13. Lista todos los productos que tengan un precio entre $60 y $200. Utilizando el operador BETWEEN. */
SELECT * FROM PRODUCTO WHERE PRECIO BETWEEN 60 AND 200;
/* 14. Lista todos los productos donde el código de fabricante sea 1, 3 o 5. Utilizando el operador IN. */
SELECT * FROM PRODUCTO WHERE CODIGO_FABRICANTE IN(1, 3, 5);
/* 15. Devuelve una lista con el nombre de todos los productos que contienen la cadena Portátil en el nombre. */
SELECT NOMBRE FROM PRODUCTO WHERE NOMBRE LIKE "%PORTATIL%";
/* Consultas Multitabla
1. Devuelve una lista con el código del producto, nombre del producto, código del fabricante y nombre del fabricante, de todos los productos de la 
base de datos. */
SELECT FABRICANTE.NOMBRE, FABRICANTE.CODIGO, PRODUCTO.NOMBRE, PRODUCTO.CODIGO FROM FABRICANTE INNER JOIN PRODUCTO ON FABRICANTE.CODIGO = PRODUCTO.CODIGO_FABRICANTE;
/* 2. Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la base de datos. Ordene el resultado 
por el nombre del fabricante, por orden alfabético. */
SELECT PRODUCTO.NOMBRE, PRECIO, FABRICANTE.NOMBRE FROM PRODUCTO INNER JOIN FABRICANTE ON FABRICANTE.CODIGO = PRODUCTO.CODIGO_FABRICANTE ORDER BY FABRICANTE.NOMBRE;
/* 3. Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más barato. */
SELECT PRODUCTO.NOMBRE, PRECIO, FABRICANTE.NOMBRE FROM PRODUCTO INNER JOIN FABRICANTE ON FABRICANTE.CODIGO = PRODUCTO.CODIGO_FABRICANTE ORDER BY PRECIO LIMIT 1;
/* 4. Devuelve una lista de todos los productos del fabricante Lenovo. */
SELECT * FROM PRODUCTO INNER JOIN FABRICANTE ON PRODUCTO.CODIGO_FABRICANTE = FABRICANTE.CODIGO WHERE FABRICANTE.NOMBRE = "LENOVO";
SELECT * FROM PRODUCTO INNER JOIN FABRICANTE ON PRODUCTO.CODIGO_FABRICANTE = FABRICANTE.CODIGO WHERE FABRICANTE.NOMBRE LIKE "%LENOVO%";
/* 5. Devuelve una lista de todos los productos del fabricante Crucial que tengan un precio mayor que $200. */
SELECT * FROM PRODUCTO INNER JOIN FABRICANTE ON PRODUCTO.CODIGO_FABRICANTE = FABRICANTE.CODIGO WHERE FABRICANTE.NOMBRE = "CRUCIAL" AND PRECIO > 200;
/* 6. Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packard. Utilizando el operador IN. */
SELECT * FROM PRODUCTO INNER JOIN FABRICANTE ON PRODUCTO.CODIGO_FABRICANTE = FABRICANTE.CODIGO WHERE FABRICANTE.NOMBRE IN("ASUS", "HEWLETT-PACKARD")GROUP BY PRODUCTO.CODIGO;
/* 7. Devuelve un listado con el nombre de producto, precio y nombre de fabricante, de todos los productos que tengan un precio mayor o igual a $180. 
Ordene el resultado en primer lugar por el precio (en orden descendente) y en segundo lugar por el nombre (en orden ascendente) */
SELECT PRODUCTO.NOMBRE, PRECIO, FABRICANTE.NOMBRE FROM PRODUCTO INNER JOIN FABRICANTE ON PRODUCTO.CODIGO_FABRICANTE = FABRICANTE.CODIGO WHERE PRECIO >= 180 ORDER BY PRECIO DESC;
SELECT PRODUCTO.NOMBRE, PRECIO, FABRICANTE.NOMBRE FROM PRODUCTO INNER JOIN FABRICANTE ON PRODUCTO.CODIGO_FABRICANTE = FABRICANTE.CODIGO WHERE PRECIO >= 180 ORDER BY PRODUCTO.NOMBRE;
/* Consultas Multitabla - Resuelva todas las consultas utilizando las cláusulas LEFT JOIN y RIGHT JOIN.
1. Devuelve un listado de todos los fabricantes que existen en la base de datos, junto con los productos que tiene cada uno de ellos. 
El listado deberá mostrar también aquellos fabricantes que no tienen productos asociados. */
SELECT * FROM FABRICANTE RIGHT JOIN PRODUCTO ON FABRICANTE.CODIGO = PRODUCTO.CODIGO;
/* 2. Devuelve un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún producto asociado. */
SELECT * FROM FABRICANTE LEFT JOIN PRODUCTO ON FABRICANTE.CODIGO = PRODUCTO.CODIGO_FABRICANTE WHERE PRODUCTO.CODIGO_FABRICANTE IS NULL;
/* Subconsultas (En la cláusula WHERE) - Con operadores básicos de comparación
1. Devuelve todos los productos del fabricante Lenovo. (Sin utilizar INNER JOIN). */
SELECT * FROM PRODUCTO WHERE (SELECT FABRICANTE.CODIGO FROM FABRICANTE WHERE FABRICANTE.NOMBRE LIKE "LENOVO") = PRODUCTO.CODIGO_FABRICANTE;
/* 2. Devuelve todos los datos de los productos que tienen el mismo precio que el producto más caro del fabricante Lenovo. (Sin utilizar INNER JOIN). */
SELECT NOMBRE, PRECIO FROM PRODUCTO WHERE PRECIO = (SELECT MAX(PRECIO) FROM PRODUCTO WHERE CODIGO_FABRICANTE = 2);
/* 3. Lista el nombre del producto más caro del fabricante Lenovo. */
SELECT PRODUCTO.NOMBRE, MAX(PRODUCTO.PRECIO) FROM PRODUCTO WHERE (SELECT FABRICANTE.CODIGO FROM FABRICANTE WHERE FABRICANTE.NOMBRE LIKE "LENOVO") = PRODUCTO.CODIGO_FABRICANTE;
/* 4. Lista todos los productos del fabricante Asus que tienen un precio superior al precio medio de todos sus productos. */
SELECT * FROM PRODUCTO WHERE (SELECT AVG((SELECT FABRICANTE.CODIGO FROM FABRICANTE WHERE FABRICANTE.NOMBRE LIKE "ASUS") = PRODUCTO.CODIGO_FABRICANTE) PRECIO) > PRODUCTO.PRECIO;
/* Subconsultas con IN y NOT IN
1. Devuelve los nombres de los fabricantes que tienen productos asociados. (Utilizando IN o NOT IN).*/
SELECT * FROM PRODUCTO INNER JOIN FABRICANTE ON PRODUCTO.CODIGO_FABRICANTE = FABRICANTE.CODIGO WHERE FABRICANTE.CODIGO IN(PRODUCTO.CODIGO_FABRICANTE) GROUP BY PRODUCTO.CODIGO;
/* 2. Devuelve los nombres de los fabricantes que no tienen productos asociados. (Utilizando IN o NOT IN). 
************************************* */
SELECT * FROM PRODUCTO INNER JOIN FABRICANTE ON PRODUCTO.CODIGO_FABRICANTE = FABRICANTE.CODIGO WHERE (SELECT FABRICANTE.CODIGO NOT IN (PRODUCTO.CODIGO_FABRICANTE)) ORDER BY FABRICANTE.CODIGO;
/* Subconsultas (En la cláusula HAVING)
1. Devuelve un listado con todos los nombres de los fabricantes que tienen el mismo número de productos que el fabricante Lenovo. */
SELECT FABRICANTE.NOMBRE FROM FABRICANTE INNER JOIN PRODUCTO ON FABRICANTE.CODIGO = PRODUCTO.CODIGO_FABRICANTE GROUP BY FABRICANTE.NOMBRE HAVING COUNT(PRODUCTO.CODIGO) = (SELECT COUNT(CODIGO) FROM PRODUCTO WHERE CODIGO_FABRICANTE = 2);
