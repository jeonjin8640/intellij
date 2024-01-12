-- 회원번호는 100001부터 시작

create table member(
id number(6) not null,
userid varchar2(20) not null,
username varchar2(10) not null,
userpwd varchar2(20) not null,
regdate date,
primary key(id)
);


create sequence member_seq start with 100001 increment by 1 nocycle;

insert into member values(member_seq.nextval, 'koreait', '홍길동', '1234', '20231214');

select * from member;

commit;