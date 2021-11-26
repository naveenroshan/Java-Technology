show databases;

create database ProductCouponDB;

use ProductCouponDB;

# This table is for the Product service 
create table product(
id int AUTO_INCREMENT PRIMARY KEY,
name varchar(20),
description varchar(100),
price decimal(8,3) 
);

#This table is for the Coupon service
create table coupon(
id int AUTO_INCREMENT PRIMARY KEY,
code varchar(20) UNIQUE,
discount decimal(8,3),
exp_date varchar(100) 
);

Select * from coupon;

select * from product;