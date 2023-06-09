create database if not exists appshop;
use appshop;

create table account(
	id int unsigned auto_increment key,
    name varchar(45) not null,
    gender bit not null,
    date_of_birth date not null,
    email varchar(45) not null,
    phone varchar(20) not null,
    address varchar(45) not null,
    password varchar(20) not null,
    deleted bit
);

create table role (
	id int unsigned auto_increment primary key,
    name varchar(45) not null
);

create table account_role (
	id int unsigned auto_increment key,
    role_id int unsigned,
    foreign key (role_id) references role(id),
    account_id int unsigned,
    foreign key (account_id) references account(id)
);

create table category(
	id int unsigned auto_increment primary key,
    name varchar(45) not null
);

create table product(
	id int unsigned auto_increment primary key,
    code varchar(45) not null,
    name varchar(45) not null,
    price double not null,
    quantity int unsigned not null,
    brand varchar(45) not null,
    description text,
    image text,
    deleted bit,
    category_id int unsigned,
    foreign key (category_id) references category(id)
);

create table `order`(
	id int unsigned auto_increment primary key,
    code_order varchar(45) not null,
    day_order date not null,
    deleted bit,
    account_id int unsigned,
    foreign key (account_id) references account(id)
);

create table order_detail (
	id int unsigned auto_increment key,
    amount int unsigned not null,
    product_id int unsigned,
    foreign key (product_id) references product(id),
    order_id int unsigned,
    foreign key (order_id) references `order`(id)
);
