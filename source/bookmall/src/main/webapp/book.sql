create table smallCategory(
smallC number(6),
smallName varchar2(20),
bigCod char(13),
primary key(smallc)
);

INSERT INTO smallCategory VALUES(100, '소설/시', '100');
INSERT INTO smallCategory VALUES(200, '인문', '100');
INSERT INTO smallCategory VALUES(300, '예술', '100');
INSERT INTO smallCategory VALUES(400, '사회', '100');
INSERT INTO smallCategory VALUES(500, 'IT모바일', '100');
INSERT INTO smallCategory VALUES(600, 'ELT사전', '200');
INSERT INTO smallCategory VALUES(700, '문학/소설', '200');
INSERT INTO smallCategory VALUES(800, '경제/경영', '200');

SELECT MAX(smallC) + 1 AS smallC FROM smallCategory;


CREATE TABLE books(
book_id number(6),
book_name varchar2(255),
book_price number,
book_stock number,
book_discount varchar2(5),
book_type varchar2(20),
book_content varchar2(255),
book_reg date,
smallC number(6),
primary key(smallC)
);

INSERT INTO books VALUES(101, '이것이 자바다', 25000, 10, 10, 'NEW', '이것이 자바다 도서는..' ,'20231226', 500);
INSERT INTO books VALUES(102, '자바의 정석', 30000, 5, 20, 'NORMAL', '자바의 정석 도서는' ,'20231226', 500);
INSERT INTO books VALUES(103, '명견만리', 12000, 5, 20, 'BEST', 'KBS 명견만리 제작진이...' ,'20231229', 200);
INSERT INTO books VALUES(104, '콜린스,코빌드 영어 사전', 99000, 5, 10, 'BEST', '콜린스 코빌드 영어 사전은 옥스포드..' ,'20231229', 600);
INSERT INTO books VALUES(105, '황순원의 소나기', 1000, 100, 10, 'NORMAL', '교육부 권장도서, 황순원의 소나기' ,'20231229', 700);


commit;


SELECT MAX(smallC) FROM smallCategory;

SELECT MAX(smallC)+1 FROM smallCategory;


SELECT NVL(MAX(smallC)+1, 101) FROM smallCategory;
























