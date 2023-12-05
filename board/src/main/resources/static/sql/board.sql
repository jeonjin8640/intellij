-- 기본 정렬은 id
create table temp(
    id int not null auto_increment,
    subject varchar(255),
    grp int, -- 게시물 그룹화
    seq int, -- 그룹화한 자료를 2차 정렬
    depth int, -- 들여쓰기
    primary key(id)
);

insert into temp values(null, '1번째 게시물', 1, 1, 1);
insert into temp values(null, '2번째 게시물', 2, 1, 1);
insert into temp values(null, '3번째 게시물', 3, 1, 1);

-- 사용자1
insert into temp values(null, '[사용자1답글]2번째 게시물', 2, 1, 2);
-- 사용자2
insert into temp values(null, '[사용자2답글]2번째 게시물', 2, 2, 2);
-- 사용자1 에 대한 답글
insert into temp values(null, '[사용자1답글에 대한 답글]2번째 게시물', 2, 1, 3);


select * from temp order by grp desc, seq asc;
-- 누구에게 달건지/grp/, 게시물(답글)순서/seq/
insert into temp values(null, '[홍길동의-답글] 1번째 게시물', 1, 1, 2);
insert into temp values(null, '[코리아의-답글] 1번째 게시물', 1, 2, 2);

create table board(
    id int not null auto_increment,
    subject varchar(255) not null,
    writer varchar(10) not null,
    content text,
    visit int,
    regdate date,
    orgName varchar(255),
    savedFileName varchar(255),
    savedPathFileName varchar(255),
    savedFileSize bigint,
    folderName varchar(10),
    ext varchar(20),
    grp int,
    seq int,
    depth int,
    primary key(id)
);

-- 검색: 조건(where)
-- subject
select * from board where subject = '텍스트 테스트용 게시글' order by id desc;

-- writer
select count(*) from board where writer = '관리자' order by id desc;

-- content 유사어 검색
select count(*) from board where content like '%텍스트%' order by id desc;

select writer from board where writer = '관리자';
select content from board where content like '%텍스트%';



