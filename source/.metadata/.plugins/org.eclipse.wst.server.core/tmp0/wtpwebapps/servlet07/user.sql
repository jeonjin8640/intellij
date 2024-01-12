create database demo;

create table demo(
	id int not null auto_increment,
	username varchar(100),
	email varchar(100),
	passwd varchar(100),
	primary key(id)
);