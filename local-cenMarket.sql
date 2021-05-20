drop table tbl_view;
drop table tbl_sboard;
drop table tbl_member;
drop table tbl_category;
drop table tbl_reply;
drop table tbl_bookMark;
show tables;

create table tbl_member(
    id nvarchar2(50) primary key,  
    password nvarchar2(150) not null,
    name nvarchar2(20) not null,
    nickname nvarchar2(20) not null unique,
    email nvarchar2(50) not null unique,
    -- phnum varchar(50) not null unique,
    phnum nvarchar2(50) not null,
    org_name nvarchar2(50),							/* 소속기관 이름 */ 
    recent_address nvarchar2(150), 					/* 최근 배송지 */    
    regdate date default sysdate,				/* 회원 가입일 */
    updatedate date DEFAULT NULL 				/* 정보수정일 */    
);


create table tbl_sboard(
    sb_num int(50) not null auto_increment,		/* 게시글 번호를 정수로 */
    sb_writer varchar(50) not null,  			/* 작성자의 아이디(FK) */
    sb_nickname varchar(20) not null,			/* 작성자의 닉네임 +++++추가+++ */
    sb_name varchar(50) not null,  				/* 게시글의 제목 */
    sb_detail varchar(2000),		 			/* 판매상품의 설명 */
    Total_price int(50) not null,				/* 총 판매 금액 */ 
    Total_quantity int(50) not null,			/* 총 판매수량 */
	sb_regdate timestamp default now(),			/* 게시글 등록일 */
    ct_num int(50) not null,					/* 카테고리 번호(FK) */
    trade_shape	varchar(50) not null,			/* 거래 형태 */
    trade_progress varchar(50) default "판매중",	/* 거래 진행 상황 */  
    sb_view varchar(50) not null,				/* 대표사진이름 */
    trade_area varchar(150) not null,			/* 거래지역 */
    primary key(sb_num),
    foreign key(sb_writer) references tbl_member(id)
	ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key(ct_num) references tbl_category(ct_num)
	ON DELETE CASCADE ON UPDATE CASCADE
-- foreign key(sb_num) references tbl_reply(sb_num)
-- 	ON DELETE CASCADE ON UPDATE CASCADE   
);


create table tbl_category(
    ct_num int(50) not null, 			/* 카테고리번호 */
    ct_main varchar(50) not null,		/* 대 분 류 */
    ct_middle varchar(50),				/* 중 분 류 */
	ct_sub varchar(50),					/* 소 분 류 */
    primary key(ct_num)    
);


create table tbl_bookMark(
	sb_num int(50) not null,					/* 게시글 번호를 정수로 */
    sb_writer varchar(50) not null,  			/* 작성자의 아이디(FK) */
    bm_regdate timestamp default now(),			/* 찜한날짜 */
    primary key(sb_num, sb_writer),
    foreign key(sb_writer) references tbl_member(id)
 	ON DELETE CASCADE ON UPDATE CASCADE
);

create table tbl_view( 					/* 게시글에 올라가는 사진 */
    sb_num int(50) not null,			/* 게시글 번호 */
    view_name varchar(50) not null,		/* 사진이름 */    
    primary key(sb_num, view_name)		
);

create table tbl_reply(
	rp_num int(50) not null auto_increment,		/* 댓글 인조키 */
    sb_num int(50) not null,					/* 게시글 번호를 정수로 */
    sb_writer varchar(50) not null,  			/* 작성자의 아이디(FK) */
    sb_nickname varchar(20) not null,			/* 작성자의 닉네임 */
    sb_detail varchar(2000) not null, 			/* 판매상품의 설명 */
    rp_regdate timestamp default now(),			/* 댓글 등록일 */
    primary key(rp_num)
);





































