create table user (
    id int primary key,
    name varchar(64),
    phone varchar(32)
);

insert into user (id, name, phone) values (1, 'Jack', 12345678910), (2, 'Tom', 12345678911), (3, 'Michael', 12345678912);
