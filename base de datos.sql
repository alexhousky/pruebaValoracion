CREATE DATABASE fidelidad_bd;
USE fidelidad_bd;

-- Tipos de identificación
CREATE TABLE tipo_identificacion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

-- Países
CREATE TABLE paises (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE
);

-- Departamentos
CREATE TABLE departamentos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    pais_id INT NOT NULL,
    FOREIGN KEY (pais_id) REFERENCES paises(id),
    UNIQUE(nombre, pais_id)
);

-- Ciudades
CREATE TABLE ciudades (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    departamento_id INT NOT NULL,
    FOREIGN KEY (departamento_id) REFERENCES departamentos(id),
    UNIQUE(nombre, departamento_id)
);

-- Marcas
CREATE TABLE marcas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

-- Clientes
CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_identificacion_id INT NOT NULL,
    numero_identificacion VARCHAR(20) NOT NULL UNIQUE,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    direccion VARCHAR(150),
    ciudad_id INT NOT NULL,
    FOREIGN KEY (tipo_identificacion_id) REFERENCES tipo_identificacion(id),
    FOREIGN KEY (ciudad_id) REFERENCES ciudades(id)
);

-- Fidelización (relación muchos a muchos entre clientes y marcas)
CREATE TABLE fidelizacion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT NOT NULL,
    marca_id INT NOT NULL,
    fecha_inicio DATE NOT NULL,
    estado ENUM('activo', 'inactivo') DEFAULT 'activo',
    FOREIGN KEY (cliente_id) REFERENCES clientes(id),
    FOREIGN KEY (marca_id) REFERENCES marcas(id),
    UNIQUE(cliente_id, marca_id)
);


INSERT INTO tipo_identificacion (nombre) VALUES
('Cédula de Ciudadanía'),
('Cédula de Extranjería'),
('Pasaporte');

INSERT INTO paises (nombre) VALUES
('Colombia'),
('Perú'),
('Venezuela');

INSERT INTO departamentos (nombre, pais_id) VALUES
-- Colombia
('Antioquia', 1),
('Cundinamarca', 1),
('Valle del Cauca', 1),

-- Perú
('Lima', 2),
('Cusco', 2),
('Arequipa', 2),

-- Venezuela
('Distrito Capital', 3),
('Zulia', 3),
('Carabobo', 3);

INSERT INTO ciudades (nombre, departamento_id) VALUES
-- Colombia
('Medellín', 1),           -- Antioquia
('Envigado', 1),
('Bogotá', 2),             -- Cundinamarca
('Soacha', 2),
('Cali', 3),               -- Valle del Cauca
('Palmira', 3),

-- Perú
('Lima', 4),               -- Lima
('Miraflores', 4),
('Cusco', 5),              -- Cusco
('Urubamba', 5),
('Arequipa', 6),           -- Arequipa
('Camana', 6),

-- Venezuela
('Caracas', 7),            -- Distrito Capital
('Maracaibo', 8),          -- Zulia
('Valencia', 9);           -- Carabobo


INSERT INTO marcas (nombre) VALUES
('Americanino'),
('American Eagle'),
('Chevignon'), 
('Esprit'),
('Naf Naf'),
('Rifle');

ALTER TABLE clientes AUTO_INCREMENT = 1;

TRUNCATE TABLE ciudades;

SET SQL_SAFE_UPDATES = 0;

drop table cliente;

drop database fidelidad_bd;

ALTER TABLE fidelizacion ADD COLUMN estado VARCHAR(20) DEFAULT 'ACTIVO';


SHOW CREATE TABLE clientes;
SHOW CREATE TABLE ciudades;
SHOW CREATE TABLE tipo_identificacion;
SELECT * FROM clientes LIMIT 3;

DELETE FROM clientes
WHERE tipo_identificacion_id IS NULL
   OR numero_identificacion IS NULL
   OR nombres IS NULL
   OR apellidos IS NULL
   OR fecha_nacimiento IS NULL
   OR ciudad_id IS NULL;
   
   INSERT INTO clientes (
    tipo_identificacion_id,
    numero_identificacion,
    nombres,
    apellidos,
    fecha_nacimiento,
    direccion,
    ciudad_id,
    correo
) VALUES (
    1, -- Cédula de Ciudadanía
    '1234567890',
    'Juan',
    'Pérez',
    '1990-05-15',
    'Calle 123',
    1,
    'aaaaa@gmail.com'-- Medellín
);

ALTER TABLE clientes DROP COLUMN nombre;
ALTER TABLE clientes DROP COLUMN telefono;


SELECT c.*
FROM clientes c
LEFT JOIN tipo_identificacion t ON c.tipo_identificacion_id = t.id
LEFT JOIN ciudades ciu ON c.ciudad_id = ciu.id
WHERE t.id IS NULL OR ciu.id IS NULL;

ALTER TABLE clientes 
MODIFY correo VARCHAR(255) NULL;

SELECT * FROM paises;