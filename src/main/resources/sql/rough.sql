create table t1
(
    name varchar(2),
    primary key (name)
);

create table t2
(
    name ,
    foreign key (name) references t1 (name)
);