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