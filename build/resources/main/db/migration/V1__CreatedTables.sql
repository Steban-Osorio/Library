create table books
(
    id int auto_increment
        primary key,
    bookname varchar(250) null,
    author varchar(250) null,
    category varchar(250) null,
    cuantity_available int null,
    reserved_amount int null,
    rate int null
);

create table reserve
(
    id int auto_increment
        primary key,
    return_date date null,
    cuantity_books int null,
    id_user int not null,
    id_book int not null
);

create table users
(
    id int not null
        primary key,
    typeuser varchar(250) not null,
    username varchar(250) not null,
    lastname varchar(250) not null
);

