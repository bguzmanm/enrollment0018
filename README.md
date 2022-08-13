# Proyecto en Spring Boot

## Modelo de Datos
Antes de comenzar, puedes implementar el siguiente modelo de base de datos en MySQL.

![](/img/modelomatriculas.png "Modelo de Datos")

Los siguientes son los scripts de creación e inserción de datos.

### DDL
Ejecuta este script para la creación de las tablas.
```sql
create database matriculas;
use matriculas;

create table estudiante (
    id int unsigned auto_increment,
    rut varchar(12),
    nombre varchar(100),
    email varchar(50),
    telefono varchar(20),
    last_update timestamp not null default current_timestamp,
primary key (id));

create table facilitador (
    id int unsigned not null auto_increment,
    rut varchar(12),    
    nombre varchar(100),    
    email varchar(50),    
    telefono varchar(20),    
    valorhora float default NULL,    
    banco varchar(255),    
    ctabancaria varchar(34),    
    last_update timestamp not null default current_timestamp,    
primary key (id));

create table curso (
    id int unsigned not null auto_increment,
    codigo varchar(10) not null,    
    nombre varchar(100) not null,    
    id_facilitador int unsigned,    
    last_update timestamp not null default current_timestamp,    
primary key(id),   
constraint facilitador_fk foreign key (id_facilitador) references facilitador(id) on delete restrict);

create table matricula (
    id_estudiante int unsigned not null,
    id_curso int unsigned not null,
    fecha date,
    last_update timestamp not null default current_timestamp,    
primary key (id_estudiante, id_curso),    
constraint matriculados_fk foreign key (id_estudiante) references estudiante(id) on delete restrict,    
constraint curso_con_matriculados_fk foreign key (id_curso) references curso(id) on delete restrict);
```
### DML
Ejecuta este script para llenar con datos.
```sql
insert into estudiante (rut, nombre, email, telefono) values 
    ('36596728-8','Lars Schneider','sed.hendrerit@google.org','+56 1 7623 5725'),  
    ('6490579-1','Emerald Neal','parturient.montes.nascetur@yahoo.com','+56 6 8693 3591'),  
    ('22598825-0','Driscoll Kaufman','lobortis.quam@yahoo.org','+56 8 8859 6556'),  
    ('3839216-6','Minerva Harmon','aliquam.arcu.aliquam@aol.org','+56 5 6764 6329'),  
    ('20582652-1','Yeo Bullock','fermentum.metus@hotmail.couk','+56 9 3616 2762'),  
    ('41483558-9','Jolene Bennett','imperdiet@yahoo.ca','+56 6 4733 2833'),  
    ('14763384-K','Quinn Perez','hendrerit.donec@hotmail.com','+56 1 8423 6656'),  
    ('20213514-5','Jada Garrett','primis.in@aol.edu','+56 5 2124 9335'),  
    ('2060666-5','Zoe Mcguire','rutrum.magna@outlook.org','+56 3 4332 8474'),  
    ('46406220-3','Palmer Church','dui@outlook.ca','+56 7 6424 4478'),  
    ('39996598-5','Damon Mullen','ut@aol.org','+56 3 2465 1985'),  
    ('49862328-K','Cheryl Kirk','dolor.fusce.feugiat@protonmail.couk','+56 2 3734 5529'), 
    ('43284656-3','Wing Browning','neque.tellus.imperdiet@yahoo.edu','+56 8 6337 7348'),  
    ('12620895-2','Garrison Barnes','lorem@hotmail.net','+56 3 1568 6384'),  
    ('41183941-9','Xavier Barnett','mi.aliquam@hotmail.net','+56 1 2746 4825'),  
    ('8643546-2','Hanna Russo','etiam.bibendum.fermentum@google.ca','+56 5 7487 3765'), 
    ('47400735-9','Hilda Jordan','est.nunc.ullamcorper@icloud.org','+56 6 6371 1876'),  
    ('34248-3','Natalie Paul','ultrices.vivamus.rhoncus@aol.com','+56 1 2923 6528'),  
    ('21778454-9','Rosalyn Carey','cras.interdum@aol.net','+56 6 8924 6597'),  
    ('25754877-5','Bruce Cline','odio.sagittis@yahoo.edu','+56 8 3499 4977');

insert into facilitador (rut, nombre, email, telefono, valorhora, banco, ctabancaria) values
    ('35930689-K','Lysandra Russo','eu.augue.porttitor@google.org','+56 2 2332 2686', 41.03,'Et Magna Praesent Inc.','ES8936232360318702725231'),  
    ('45972862-7','Giacomo Battle','lobortis.ultrices@protonmail.ca','+56 3 7491 2588', 28.12,'Donec Tincidunt Corporation','GL3908838962031128'),  
    ('46559777-1','Dolan Potter','non.dapibus.rutrum@protonmail.net','+56 3 5532 4294', 94.24,'Maecenas Libero Foundation','BG82XGSR17991586542355'),  
    ('21874170-3','Wynter Luna','ipsum.sodales@protonmail.org','+56 2 7472 2444', 70.33,'Elementum At Institute','SK2161840162640586711280'),  
    ('40727357-5','Cheyenne Dorsey','vestibulum.ut@outlook.net','+56 1 4672 6694', 77.21,'Sollicitudin Commodo Ipsum Company','DO26234865975122724417837163'),  
    ('2131017-4','Ora Mcdaniel','nec.luctus@protonmail.org','+56 4 6741 9512', 81.12,'Fusce Dolor Quam Incorporated','FI0604269745520626'),  
    ('15989492-4','Iris Beard','eget.metus@yahoo.org','+56 4 5575 5743', 60.13,'Vitae Limited','MR4632875136714720710161125'),  
    ('19462222-8','Carissa Trevino','donec@google.net','+56 5 5844 9412', 67.74,'Laoreet Ipsum Foundation','SI92137312556177276'), 
    ('12187316-8','Imelda Gardner','amet.consectetuer@yahoo.com','+56 3 8235 6689', 40.91,'Quisque Limited','CR5897824843014557287'),  
    ('34245451-8','Gretchen Chang','nunc.ullamcorper.eu@outlook.couk','+56 4 4688 5166', 4.58,'Cras LLC','LV63UKUJ7284825183662');

INSERT INTO curso (codigo, nombre, id_facilitador) VALUES  
    (8553,'Tech Support',1),  
    (6021,'Human Resources',2),  
    (6863,'Quality Assurance',3),  
    (8053,'Asset Management',4),  
    (9954,'Quality Assurance',5),  
    (7453,'Asset Management',6), 
    (1713,'Sales and Marketing',7),  
    (1453,'Tech Support',8),  
    (1745,'Sales and Marketing',9),  
    (4528,'Asset Management',10);

INSERT INTO matricula (id_estudiante, id_curso, fecha) VALUES
    (1,1, STR_TO_DATE('2021-05-06', '%Y-%m-%d')),  
    (2,1, STR_TO_DATE('2021-05-25', '%Y-%m-%d')),  
    (3,1, STR_TO_DATE('2021-05-06', '%Y-%m-%d')),  
    (4,2, STR_TO_DATE('2021-05-14', '%Y-%m-%d')),  
    (5,2, STR_TO_DATE('2021-05-24', '%Y-%m-%d')),  
    (6,2, STR_TO_DATE('2021-05-21', '%Y-%m-%d')),  
    (7,1, STR_TO_DATE('2021-05-19', '%Y-%m-%d')),  
    (8,1, STR_TO_DATE('2021-05-26', '%Y-%m-%d')),  
    (9,2, STR_TO_DATE('2021-05-29', '%Y-%m-%d')),  
    (10,2, STR_TO_DATE('2021-05-10', '%Y-%m-%d')),  
    (11,1, STR_TO_DATE('2021-05-25', '%Y-%m-%d')),  
    (12,1, STR_TO_DATE('2021-05-10', '%Y-%m-%d')),  
    (13,2, STR_TO_DATE('2021-05-09', '%Y-%m-%d')),  
    (14,2, STR_TO_DATE('2021-05-29', '%Y-%m-%d')),  
    (15,2, STR_TO_DATE('2021-05-22', '%Y-%m-%d')),  
    (16,1, STR_TO_DATE('2021-05-25', '%Y-%m-%d')),  
    (17,1, STR_TO_DATE('2021-05-01', '%Y-%m-%d')),  
    (18,1, STR_TO_DATE('2021-05-30', '%Y-%m-%d')),  
    (19,1, STR_TO_DATE('2021-05-25', '%Y-%m-%d')), 
    (20,2, STR_TO_DATE('2021-05-15', '%Y-%m-%d'));
```

## Configuración
Indica en el archivo application.properties lo siguiente

```properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/[nombre de base de datos]
spring.datasource.username=[usuario]
spring.datasource.password=[clave]
```

## Ejecución

Start

```shell
./mvnw spring-boot:start
```

Stop

```shell
./mvnw spring-boot:stop
```
Run

```shell
./mvnw spring-boot:run
```
## App
Hemos implementado una arquitectura basada en MVC, que se compone de los siguientes elementos:
### Model
#### Domain
- **dto**: Data Transfer Object, nos permiten entregar la información requerida por los Request.
- **repository**: Interfaces que son conocidas por Service.
- **dervice**: Servicios que satisfacen los requerimientos de los Controladores.
#### Persistence
- **crud**: Interfaces que heredan de CrudRepository.
- **entity**: Clases que implementan el estereotipo @Entity y que mapean las tablas de la base de datos.
- **mapper**: Interfaces que trabajan con MapStruct y que gestionan el mapeo entre la clase Entity y el DTO.
- **repository**: Implementan las interfaces de domain.repository, e utilizan las interfaces crud para relizar el CRUD a la Base de Datos.
### Web
- **controller**: Implementae el esterotipo @Controller, para la interacción con las vistas.
- **restcontroller**: Implementa el estereotipo @RestController, para la interacción vía Rest.

[Más información en el Instructivo](/img/Spring_Boot_Security.pdf) 