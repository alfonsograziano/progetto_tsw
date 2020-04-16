drop database web;
create database web;
use web;


CREATE TABLE product (
    name VARCHAR(32),
    description text,
    price NUMERIC,
    id int NOT NULL PRIMARY KEY auto_increment,
    brand VARCHAR(32)
);

create table category (
	name varchar(32),
    slug varchar(64) NOT NULL PRIMARY KEY
); 

create table belongs (
	id_product int not null,
    category_slug varchar(64) not null,
    foreign key(id_product) references product(id),
    foreign key(category_slug) references category(slug),
    primary key(id_product, category_slug)
);

create table product_picture (
	id int not null primary key auto_increment,
    id_product int,
    picture mediumblob,
    foreign key(id_product) references product(id)
);

create table shipping_types(
	id int not null primary key auto_increment,
    name varchar(32),
    price numeric,
    day int
);

create table admin_user(
	hashed_password varchar(64),
    email varchar(64)not null primary key,
    name varchar(32),
    surname varchar(32)
    );
    
create table customer(
	id int not null primary key auto_increment,
    name varchar(32),
    surname varchar(32),
    email varchar(64),
    phone varchar(16),
    hashed_password varchar(64)
);

create table shipping_info(
	id int not null primary key auto_increment,
    address varchar(64),
    state varchar(32),
    zip_code varchar(16),
    details text
);

create table payment_info(
	id int not null primary key auto_increment,
	card_number varchar(16),
    cvv int,
    expire_date varchar(5)
);

create table shipping(
	id int not null primary key auto_increment,
    address varchar(64),
    state varchar(32),
    zip_code varchar(16),
    details text,
    track_id varchar(64),
    cost numeric
);

create table payment(
	id int not null primary key auto_increment,
	card_number varchar(16),
    cvv int,
    expire_date varchar(5)
);

create table ordination(
	id int not null primary key auto_increment,
    shipping_id int,
    payment_id int,
    date datetime,
    iva int,
	foreign key(shipping_id) references shipping(id),
    foreign key(payment_id) references payment(id)
);

create table wants_sent(
	id_customer int,
    id_s_info int,
    foreign key(id_customer) references customer(id),
    foreign key(id_s_info) references shipping_info(id),
    primary key(id_customer, id_s_info)
);

create table pay_with(
	id_customer int,
    id_p_info int,
    foreign key(id_customer) references customer(id),
    foreign key(id_p_info) references payment_info(id),
    primary key(id_customer, id_p_info)
);

create table make(
	id_customer int,
    id_order int,
    foreign key(id_customer) references customer(id),
    foreign key(id_order) references ordination(id),
    primary key(id_customer, id_order)
);

create table ordered_product(
	price numeric,
    id int not null primary key auto_increment,
    name varchar(32),
    product_link text
);

create table contains(
	quantity int,
    id_order int not null,
    id_ordered_product int not null,
    foreign key(id_order) references ordination(id),
    foreign key(id_ordered_product) references ordered_product(id),
    primary key(id_order, id_ordered_product)
);