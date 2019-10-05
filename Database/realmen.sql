create database realmen;
use realmen;
create table app_user(
	user_id bigint auto_increment,
    phone_number bigint(20),
    user_name varchar(50) not null,
    email varchar(50),
    avatar longblob,
    address varchar(255),
    encryted_password varchar(125) not null,
    enabled bit not null,
    constraint user_pk primary key (user_id),
    constraint user_uk unique (email)
);
Desc realmen.app_user;
insert into realmen.app_User (phone_number, email,avatar,address, ENCRYTED_PASSWORD, ENABLED) 
values ('0364516673','hunghomhinh2310@gmail.com',LOAD_FILE('C:/Users/Admin/Downloads/1.jpg'),'kieu mai, ha noi', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1),
	('0367786012','hunghaui2310@gmail.com',LOAD_FILE('C:/Users/Admin/Downloads/2.jpg'),'cau giay, ha noi', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
select * from realmen.app_user;
create table app_role(
	role_id bigint auto_increment,
    role_name varchar(50) not null,
    constraint role_pk primary key (role_id),
    constraint role_uk unique (role_name)
);
insert into realmen.app_role(ROLE_ID, ROLE_NAME) 
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
insert into realmen.user_role(USER_ID, ROLE_ID) 
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
alter table Order_Detail
        add constraint ORDER_DETAIL_ORD_FK
        foreign key (ORDER_ID)
        references Orders (order_id);
alter table order_detail
        add constraint ORDER_DETAIL_PROD_FK
        foreign key (PRODUCT_ID)
        references Product (product_id);
        
create table orders(
	order_id bigint(50) not null auto_increment,
    amount double precision not null,
    customer_address varchar(255) not null,
    customer_email varchar(128) not null,
    customer_name varchar(255) not null,
    customer_phone varchar(128) not null,
    order_date datetime not null,
    order_num integer not null,
    constraint user_role_pk primary key (order_id)
);

create table product(
	product_id bigint(100) NOT NULL auto_increment,
	product_name nvarchar(255) not null,
	price float ,
    size varchar(5),
	des varchar(2000),
	image longblob,
    create_date DATE not null,
    num_like int(20),
    PRIMARY KEY  (product_id)
);

insert into dogohuyhung.product (product_name, price,des,image, CREATE_DATE, num_like)
values ('Quan 1', 100,'san pham chat luong1',LOAD_FILE('C:/Users/Admin/Downloads/3.jpg'), '2019-09-12',111),
	('Quan 2', 200,'san pham chat luong2',LOAD_FILE('C:/Users/Admin/Downloads/4.jpg'), '2019-06-12',1000),
    ('Quan 3', 300,'san pham chat luong3',LOAD_FILE('C:/Users/Admin/Downloads/5.jpg'), '2019-07-12',300),
    ('Quan 4', 400,'san pham chat luong4',LOAD_FILE('C:/Users/Admin/Downloads/6.jpg'), '2018-09-12',500),
    ('Ao 1', 500,'san pham chat luong5',LOAD_FILE('C:/Users/Admin/Downloads/3.jpg'), '2017-09-12',600),
    ('Ao 2', 600,'san pham chat luong6',LOAD_FILE('C:/Users/Admin/Downloads/3.jpg'), '2019-09-20',320),
    ('Ao 3', 100,'san pham chat luong7',LOAD_FILE('C:/Users/Admin/Downloads/4.jpg'), '2019-01-12',700),
    ('Giay 1', 100,'san pham rat chat luong',LOAD_FILE('C:/Users/Admin/Downloads/3.jpg'), '2018-07-12',20),
    ('Giay 2', 100,'san pham rat chat luong',LOAD_FILE('C:/Users/Admin/Downloads/5.jpg'), '2019-01-12',2000),
    ('Giay 3', 100,'san pham rat chat luong',LOAD_FILE('C:/Users/Admin/Downloads/6.jpg'), '2019-11-12',400);
    
DESC realmen.product;
alter table Orders
        add constraint UK_sxhpvsj665kmi4f7jdu9d2791  unique (order_Num);
	
        

 