INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');
INSERT INTO usuarios(username, password) VALUES ('user1','$2a$12$CAHAvY/wI4wymulsEApzNu82dyLahCr1CwDLpkmle1/X.SGpmJvdm');
INSERT INTO usuarios(username, password) VALUES ('admin','$2a$12$CAHAvY/wI4wymulsEApzNu82dyLahCr1CwDLpkmle1/X.SGpmJvdm');
INSERT INTO usuarios_roles (codigo_usuario, codigo_rol) VALUES (1, 1); -- user1 with ROLE_USER
INSERT INTO usuarios_roles (codigo_usuario, codigo_rol) VALUES (2, 2); -- admin with ROLE_ADMIN

--Insertando cursos
INSERT INTO cursos (nombre, descripcion) VALUES ('Curso nivel principiante', 'Curso básico enfocado en los fundamentos esenciales para nuevos estudiantes.');
INSERT INTO cursos (nombre, descripcion) VALUES ('Curso nivel intermedio', 'Curso dirigido a quienes ya tienen conocimientos básicos y desean profundizar sus habilidades.');
INSERT INTO cursos (nombre, descripcion) VALUES ('Curso nivel avanzado', 'Curso diseñado para estudiantes con conocimientos previos que buscan dominar técnicas avanzadas y complejas en la materia.');

--Insertando nanosatelites
INSERT INTO nanosatelites (tipo, precio) VALUES ('NanoSat', 100);
INSERT INTO nanosatelites (tipo, precio) VALUES('CubeSat', 500);

--Insertando componentes
INSERT INTO componentes (nombre, descripcion, tipo, precio, peso, consumo) VALUES ('Transceptor de Comunicaciones', 'Dispositivo para enviar y recibir datos con la estación terrestre', 'Comunicaciones', 300, 40, 30);
INSERT INTO componentes (nombre, descripcion, tipo, precio, peso, consumo) VALUES ('Cámara Espacial', 'Cámara de alta resolución para observación terrestre', 'Instrumento', 400, 5, 50);
INSERT INTO componentes (nombre, descripcion, tipo, precio, peso, consumo) VALUES ('Panel Solar', 'Panel solar para alimentar el nanosatélite', 'Energía', 200, 20, 5);