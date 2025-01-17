create database dogohuyhung;
use dogohuyhung;
create table app_user(
	user_id bigint auto_increment,
    phone_number bigint(20),
    user_name varchar(50) not null,
    email varchar(50),
    address varchar(255),
    encryted_password varchar(125) not null,
    enabled bit not null,
    constraint user_pk primary key (user_id),
    constraint user_uk unique (user_name)
);

insert into dogohuyhung.app_User (phone_number,user_name, email,address, ENCRYTED_PASSWORD, ENABLED) 
values ('0364516673','hung nguyen','hunghomhinh2310@gmail.com','kieu mai, ha noi', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1),
	('0367786012','hung2','hunghaui2310@gmail.com','cau giay, ha noi', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

create table app_role(
	role_id bigint auto_increment,
    role_name varchar(50) not null,
    constraint role_pk primary key (role_id),
    constraint role_uk unique (role_name)
);
insert into dogohuyhung.app_role(ROLE_ID, ROLE_NAME) 
values (1, 'ROLE_ADMIN'),
	(2, 'ROLE_USER');

create table user_role(
	id bigint auto_increment,
    user_id bigint,
    role_id bigint,
    constraint user_role_pk primary key (id),
    constraint user_role_fk1 foreign key (user_id) references app_user(user_id),
    constraint user_role_fk2 foreign key (role_id) references app_role(role_id)
);
insert into dogohuyhung.user_role(USER_ID, ROLE_ID) 
values (1, 1),
	(1, 2),
	(2, 2);

create table order_detail(
	order_detail_id bigint(50) NOT NULL auto_increment,
    amount double precision not null,
    price double precision not null,
    quantity int(50) not null,
    order_id bigint(50),
    product_id bigint(50),
    constraint user_role_pk primary key (order_detail_id)
);
        
create table orders(
	order_id bigint(50) not null auto_increment,
    amount double precision not null,
    customer_address varchar(255) not null,
    customer_email varchar(128) not null,
    customer_name varchar(255) not null,
    customer_phone varchar(128) not null,
    order_date datetime not null,
    order_num integer not null unique,
    constraint user_role_pk primary key (order_id)
);
alter table Order_Detail
        add constraint ORDER_DETAIL_ORD_FK
        foreign key (ORDER_ID)
        references Orders (order_id);

create table product(
	product_id bigint(100) NOT NULL auto_increment,
	product_name nvarchar(255) not null,
	price float ,
	des varchar(2000),
	image longblob,
    create_date DATE not null,
    num_like int(20),
    PRIMARY KEY  (product_id)
);

alter table product drop image;
alter table product drop file_id;
desc product;
alter table order_detail
        add constraint ORDER_DETAIL_PROD_FK
        foreign key (PRODUCT_ID)
        references Product (product_id);

create table file_info(
	file_id bigint(100) NOT NULL auto_increment,
    file_name nvarchar(256),
    url nvarchar(256),
    product_id bigint(100),
    primary key (file_id)
--    constraint file_fk foreign key (file_id) references product(file_id)
);
alter table file_info add column product_id bigint(100);
alter table file_info
	add constraint FILE_INFO_FK
    foreign key (product_id)
    references product(product_id);

insert into dogohuyhung.product (product_name, price,des, CREATE_DATE, num_like,category_id,link,discount)
values ('ke ti vi 1', 100,'san pham chat luong1', '2019-09-12',111,4,'http://532452555545342','20%'),
	('ke ti vi 2', 200,'san pham chat luong2', '2019-06-12',1000,4,'http://532452555545342','20%'),
    ('ke ti vi 3', 300,'san pham chat luong3', '2019-07-12',300,4,'http://532hfhf545342','20%'),
    ('ke ti vi 4', 400,'san pham chat luong4', '2018-09-12',500,4,'http://5324hfrh5545342','20%'),
    ('ke ti vi 5', 500,'san pham chat luong5', '2017-09-12',600,4,'http://53245hfhg55545342','90%'),
    ('ke ti vi 6', 600,'san pham chat luong6', '2019-09-20',320,4,'http://532452555545342','20%'),
    ('ke ti vi 7', 100,'san pham chat luong7', '2019-01-12',700,4,'http://532452hfhfg45342','20%'),
    ('ke ti vi 8', 100,'san pham rat chat luong', '2018-07-12',20,4,'http://532hfhfg2555545342','20%'),
    ('ke ti vi 9', 100,'san pham rat chat luong', '2019-01-12',2000,4,'http://5324gfrgh5545342','20%'),
    ('ke ti vi 10', 100,'san pham rat chat luong', '2019-11-12',400,4,'http://53264564hh545342','20%');
    
create table category(
	category_id bigint(100) NOT NULL auto_increment,
    category_name nvarchar(125),
    constraint category_pk primary key (category_id)
);
alter table product add category_id bigint(100);

insert into dogohuyhung.category(category_name)
values ('ban ghe phong khach'),('ban ghe phong an'),('tu'),('ke ti vi');
alter table product
add constraint product_fk
foreign key (category_id) references category(category_id);