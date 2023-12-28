-- 회원정보 member_tbl_02
create table member_tbl_02(
custno number(6),
custname varchar2(20),
phone char(13),
address varchar2(100),
joindate date,
grade char(1),
city char(2),
primary key(custno)
);

insert into member_tbl_02 values(100001, '김행복', '010-1111-2222', '서울 동대문구 휘경1동', '20151202', 'A', '01');

insert into member_tbl_02 values(100003, '이축복', '010-1111-3333', '서울 동대문구 휘경2동', '20151206', 'B', '01');
insert into member_tbl_02 values(100004, '장믿음', '010-1111-4444', '울릉군 울릉읍 독도1리', '20151001', 'B', '30');
insert into member_tbl_02 values(100005, '최사랑', '010-1111-5555', '울릉군 울릉읍 독도2리', '20151113', 'A', '30');
insert into member_tbl_02 values(100006, '진평화', '010-1111-6666', '제주도 제주시 외나무골', '20151225', 'B', '60');
insert into member_tbl_02 values(100007, '차공단', '010-1111-7777', '제주도 제주시 감나무골', '20151211', 'C', '60');

select max(custno) + 1 as custno from member_tbl_02;

-- 상품 money_tbl_02
create table money_tbl_02(
custno number(6),
saleno number(8),
pcost number,
amount number,
price number,
pcode varchar2(5),
sdate date,
primary key(custno, saleno)
);

insert into money_tbl_02 values(100001, 20160001, 500, 5, 2500, 'A100', '20160101');

insert into money_tbl_02 values(100001,20160002,1000,4,4000,'A002','20160101');
insert into money_tbl_02 values(100001,20160003,500,3,1500,'A008','20160101');
insert into money_tbl_02 values(100002,20160004,2000,1,2000,'A004','20160102');
insert into money_tbl_02 values(100002,20160005,500,1,500,'A001','20160103');
insert into money_tbl_02 values(100003,20160006,1500,2,3000,'A003','20160103');
insert into money_tbl_02 values(100004,20160007,500,2,1000,'A001','20160104');
insert into money_tbl_02 values(100004,20160008,300,1,300,'A005','20160104');
insert into money_tbl_02 values(100004,20160009,600,1,600,'A006','20160104');
insert into money_tbl_02 values(100004,20160010,3000,1,3000,'A007','20160106');

set linesize 1000;

column address format a50;

select * from member_tbl_02;

commit;

select max(custno) from member_tbl_02;

select max(custno)+1 from member_tbl_02;

NVL(값, 100001)

select nvl(max(custno)+1, 100001) from member_tbl_02;

--집계함수(결과가 하나인 것 : count, sum, max, min, distanct -> having에서 사용)
select A.custno, A.custname, decode(A.grade, 'A', 'VIP', 'B', '일반', '직원') as grade, sum(B.price) as price from member_tbl_02 A, money_tbl_02 B where A.custno = B.custno group by A.custno, A.custname, A.grade having sum(B.price) > 5000; 