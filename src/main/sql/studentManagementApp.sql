
Create database if not exists StudentManagementApp;
Use StudentManagementApp;
 create table students (
    id int not null primary key auto_increment,
    name varchar(100) not null,
    email varchar(100) not null,
    mobile_no varchar(10) not null,
    password varchar(100) not null,
    gender char(1) not null,
    dob date not null,
    created_date timestamp not null default current_timestamp,
    unique (email),
    check ( gender in ('M','F'))
  );
  drop table students;
	Select *  from students ;
    
      create table student_class (
    id int primary key auto_increment,
    student_id int not null,
    class int not null,
    status varchar(20) not null,
    foreign key (student_id) references students(id),
    check( class >= 1 and class <=12),
    check (status in ('ACTIVE','INACTIVE'))
  );
  
  