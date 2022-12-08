use talukaproject;
drop table customer;
create table customer(id int,name varchar(25),current_city varchar(200), base_city varchar(200),address varchar(20),mobile_number varchar(10),is_shop_owner boolean,birth_date date);
create table shop(id int,name varchar(25),address varchar(200),mobileNumber varchar(10),ownerId int);