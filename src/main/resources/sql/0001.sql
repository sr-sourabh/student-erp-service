CREATE TABLE admin
(
    id       INTEGER(5),
    username VARCHAR(30)  NOT NULL,
    password VARCHAR(512) NOT NULL
);

INSERT INTO admin
VALUES (1, 'test', 'test');

create table domain
(
    domain_id     INTEGER(3) primary key,
    program       varchar(10) not null,
    batch         INTEGER(6)  not null,
    capacity      integer(6)  not null,
    qualification varchar(20)
);

insert into domain
values (1, 'MS', 2020, 40, 'Btech');
insert into domain
values (2, 'MT', 2020, 150, 'Btech');
insert into domain
values (3, 'IMT', 2020, 120, '12th');
insert into domain
values (4, 'PHD', 2020, 10, 'PG');

create table specialisation
(
    specialisation_id INTEGER(3) primary key,
    code              integer(3) unique not null,
    name              varchar(10)       not null,
    description       varchar(20),
    year              varchar(6),
    credits_required  integer(5)
);

insert into specialisation
values (1, 1, 'CSE', null, 2020, 48);
insert into specialisation
values (2, 2, 'ECE', null, 2020, 48);

CREATE TABLE student
(
    student_id      INTEGER(10) PRIMARY KEY,
    roll_no         VARCHAR(30) NOT NULL,
    first_name      VARCHAR(30) NOT NULL,
    last_name       VARCHAR(30),
    email           VARCHAR(30) NOT NULL,
    photograph_path VARCHAR(100),
    cgpa            FLOAT(10)   NOT NULL DEFAULT 0.0,
    total_credits   INTEGER(10) NOT NULL,
    graduation_year date,
    domain          integer(3),
    specialisation  integer(3),
    is_deleted      boolean              default false,
    foreign key (domain) references domain (domain_id),
    foreign key (specialisation) references specialisation (specialisation_id)
);

INSERT INTO student
VALUES (1, 'MT2020054', 'shourabh', 'payal', 'test@test.com', '/null', 4.0, 8, '2022-01-01', 2, 1, false);

INSERT INTO student
VALUES (2, 'MT2020055', 'ayush', 'gaurav', 'test1@test.com', '/null', 4.0, 8, '2022-01-01', 2, 1, false);

update admin
set password = '768412320f7b0aa5812fce428dc4706b3cae50e02a64caa16a782249bfe8efc4b7ef1ccb126255d196047dfedf17a0a9';
