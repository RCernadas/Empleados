DROP DATABASE IF EXISTS bdempleados;
CREATE DATABASE bdempleados;
USE bdempleados;
CREATE TABLE Empleados (
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(10),
apellido VARCHAR(25),
fecha_nacimiento DATE,
salario DOUBLE
);
