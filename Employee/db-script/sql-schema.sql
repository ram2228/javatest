drop schema imaginnovatedemo;
create schema if not exists imaginnovatedemo;
use imaginnovatedemo;

drop table if exists employee_info;
drop table if exists emp_tax_information;

-- Create Table
create table `employee_info` (
	`id` int not null auto_increment,
    `first_name` varchar(50) not null,
    `last_name` varchar(50) not null,
    `email` varchar(50) unique not null,
    `phone_number` decimal(10, 0) unique not null,
    `doj` datetime not null,
    `salary` decimal(12, 2) not null,
    primary key(`id`)
);

create table `emp_tax_information`(
	`id` int not null auto_increment,
    `tax_percentage` decimal(4, 2) not null,
    `from_amount` decimal(12, 2) not null,
    `to_amount` decimal(12, 2) not null,
    primary key(id)
);

-- Insert Query
insert into emp_tax_information values(1, 0, 0, 250000);
insert into emp_tax_information values(2, 5, 250001, 500000);
insert into emp_tax_information values(3, 10, 500001, 1000000);
insert into emp_tax_information values(4, 20, 1000001, 10000000);
