create database if not exists trucks;

use trucks;

drop table if exists brands;
drop table if exists truck_sizes;

create table brands ( 
	id int(10) not null auto_increment,
	brand varchar(25) not null,
	primary key(id)
);

create table truck_sizes (
	id int(10) not null auto_increment,
	size varchar(25) not null,
	gas_type varchar(20) not null,
	brand_id int(10) not null,
	primary key(id),
	foreign key(brand_id) references brands(id)
);