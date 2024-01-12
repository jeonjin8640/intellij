create table buseo(
buseo_code varchar2(3) not null,
buseo_name varchar2(20) not null,
primary key(buseo_code)
);

INSERT INTO buseo VALUES('100', '인사과');
INSERT INTO buseo VALUES('200', '자재과');
INSERT INTO buseo VALUES('300', '비서실');
INSERT INTO buseo VALUES('900', '임원실');

create sequence emp_seq start with 100001 increment by 1 nocycle;

create table employees(
emp_id number(6) not null,
emp_name varchar2(20) not null,
emp_email varchar2(100) not null,
emp_addr varchar2(100) not null,
buseo_code varchar2(3) not null,
primary key(emp_id),
foreign key(buseo_code) references buseo(buseo_code) 
ON DELETE cascade
);

INSERT INTO employees VALUES(emp_seq.nextval, '홍길동', 'mail@mail.com', '부산광역시 부산진구', '100');

commit;


SELECT B.buseo_name, B.buseo_code, count(emp_id) as cnt FROM 
buseo B INNER JOIN employees E ON B.buseo_code = E.buseo_code 
GROUP BY B.buseo_name, B.buseo_code;

인사과(1) 자재과(1) 비서실(0) 임원실(0)

SELECT B.buseo_name, B.buseo_code, count(emp_id) as cnt FROM 
buseo B LEFT JOIN employees E ON B.buseo_code = E.buseo_code 
GROUP BY B.buseo_name, B.buseo_code;


















