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

set linesize 1000;

column address format a50;

select * from member_tbl_02;

commit;

select max(custno) from member_tbl_02;

select max(custno)+1 from member_tbl_02;

NVL(값, 100001)

select nvl(max(custno)+1, 100001) from member_tbl_02;