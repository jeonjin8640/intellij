use koreaitdb;

    create table dept(
        dept_code char(3) not null,
        dept_name varchar(20) not null,
        primary key (dept_code)
    );

insert into dept values('100', '인사과');
insert into dept values('200', '자재과');