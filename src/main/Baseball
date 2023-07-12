CREATE DATABASE BASEBALL;

USE BASEBALL;



------------

CREATE TABLE stadium_table(
	stadium_id int primary key auto_increment,
	stadium_name varchar(20) unique not null,
    stadium_created_at timestamp not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- TRUNCATE table stadium_table;
-- DROP table stadium_table;

select * from stadium_table;

-- 야구장 테이블(총 3개 야구장) 더미데이터
insert into stadium_table(stadium_name, stadium_created_at) values('사직야구장', now());
insert into stadium_table(stadium_name, stadium_created_at) values('잠실야구장', now());
insert into stadium_table(stadium_name, stadium_created_at) values('대구야구장', now());

---------------

CREATE TABLE team_table(
	team_id int primary key auto_increment,
    stadium_id int not null,
    team_name varchar(20) unique not null,
    team_created_at timestamp not null,
	FOREIGN KEY (stadium_id) REFERENCES stadium_table (stadium_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- TRUNCATE table team_table;
-- DROP table team_table;

select * from team_table;

-- 팀 테이블(총 3개 팀) 더미데이터
insert into team_table(stadium_id, team_name, team_created_at) values(1, '롯데자이언츠', now());
insert into team_table(stadium_id, team_name, team_created_at) values(2, 'LG트윈스', now());
insert into team_table(stadium_id, team_name, team_created_at) values(3, '삼성라이온즈', now());

---------------

CREATE TABLE player_table(
	player_id int primary key auto_increment,
    team_id int,
    player_name varchar(20) not null,
    player_position varchar(10) not null,
    player_created_at timestamp not null,
	FOREIGN KEY (team_id) REFERENCES team_table (team_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE player_table ADD CONSTRAINT position_unique UNIQUE (team_id, player_position);

-- TRUNCATE table player_table;
-- DROP table player_table;

select * from player_table;

-- 선수 테이블(각 9명) 더미데이터
insert into player_table(team_id, player_name, player_position, player_created_at) values(1, '박세웅', '투수', now());
insert into player_table(team_id, player_name, player_position, player_created_at) values(1, '유강남', '포수', now());
insert into player_table(team_id, player_name, player_position, player_created_at) values(1, '이대호', '1루수', now());
insert into player_table(team_id, player_name, player_position, player_created_at) values(1, '안치홍', '2루수', now());
insert into player_table(team_id, player_name, player_position, player_created_at) values(1, '한동희', '3루수', now());
insert into player_table(team_id, player_name, player_position, player_created_at) values(1, '마차도', '유격수', now());
insert into player_table(team_id, player_name, player_position, player_created_at) values(1, '전준우', '좌익수', now());
insert into player_table(team_id, player_name, player_position, player_created_at) values(1, '렉스', '중견수', now());
insert into player_table(team_id, player_name, player_position, player_created_at) values(1, '손아섭', '우익수', now());

insert into player_table(team_id, player_name, player_position, player_created_at) values(2, 'LG선수1', '투수', now());
insert into player_table(team_id, player_name, player_position, player_created_at) values(2, 'LG선수2', '포수', now());
insert into player_table(team_id, player_name, player_position, player_created_at) values(2, 'LG선수3', '1루수', now());
insert into player_table(team_id, player_name, player_position, player_created_at) values(2, 'LG선수4', '2루수', now());
insert into player_table(team_id, player_name, player_position, player_created_at) values(2, 'LG선수5', '3루수', now());
insert into player_table(team_id, player_name, player_position, player_created_at) values(2, 'LG선수6', '유격수', now());
insert into player_table(team_id, player_name, player_position, player_created_at) values(2, 'LG선수7', '좌익수', now());
insert into player_table(team_id, player_name, player_position, player_created_at) values(2, 'LG선수8', '중견수', now());
insert into player_table(team_id, player_name, player_position, player_created_at) values(2, 'LG선수9', '우익수', now());

insert into player_table(team_id, player_name, player_position, player_created_at) values(3, '삼성선수1', '투수', now());
insert into player_table(team_id, player_name, player_position, player_created_at) values(3, '삼성선수2', '포수', now());
insert into player_table(team_id, player_name, player_position, player_created_at) values(3, '삼성선수3', '1루수', now());
insert into player_table(team_id, player_name, player_position, player_created_at) values(3, '삼성선수4', '2루수', now());
insert into player_table(team_id, player_name, player_position, player_created_at) values(3, '삼성선수5', '3루수', now());
insert into player_table(team_id, player_name, player_position, player_created_at) values(3, '삼성선수6', '유격수', now());
insert into player_table(team_id, player_name, player_position, player_created_at) values(3, '삼성선수7', '좌익수', now());
insert into player_table(team_id, player_name, player_position, player_created_at) values(3, '삼성선수8', '중견수', now());
insert into player_table(team_id, player_name, player_position, player_created_at) values(3, '삼성선수9', '우익수', now());


---------------

CREATE TABLE out_table(
	out_id int primary key auto_increment,
    player_id int not null,
    out_reason varchar(100) not null,
    out_created_at timestamp not null,
	FOREIGN KEY (player_id) REFERENCES player_table (player_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- TRUNCATE table out_table;
-- DROP table out_table;

-- 선수 퇴출 목록 더미데이터
insert into out_table(player_id, out_reason, out_created_at) values(10, '방출', now());
insert into out_table(player_id, out_reason, out_created_at) values(16, '은퇴', now());
insert into out_table(player_id, out_reason, out_created_at) values(22, '군입대', now());
insert into out_table(player_id, out_reason, out_created_at) values(24, '도박', now());

select * from out_table;

---------------

-- DROP table stadium_table;
-- DROP table team_table;
-- DROP table player_table;
-- DROP table out_table;

select * from stadium_table;
select * from team_table;
select * from player_table;
select * from out_table;

-- 3.6 --
-- 팀별선수목록
select p.player_id as id
	 , p.player_name as name
     , p.player_position as position
     , p.player_created_at as created_at
  from player_table p
  left outer join team_table t
    on p.team_id = t.team_id
 where t.team_name like '%롯데%';

-- 3.7 선수 퇴출 등록 --
-- 요청 : 퇴출등록?playerId=1&reason=도박
-- 응답 : 성공이라는 메시지를 출력합니다.


-- 3.8 선수퇴출목록--
select * from player_table left outer join out_table on player_table.player_id = out_table.player_id;


-- 3.10 포지션별 팀 야구 선수 페이지 -- 
select max(case when player_position = '1루수' then player_position end) as 포지션,
       max(case when player_name = '이대호' then player_name end) as 롯데,
	   max(case when player_name = 'LG선수3' then player_name end) as LG,
       max(case when player_name = '삼성선수3' then player_name end) as 삼성
       from player_table
       
       union
       
select max(case when player_position = '2루수' then player_position end) as 포지션,
       max(case when player_name = '안치홍' then player_name end) as 롯데,
	   max(case when player_name = 'LG선수4' then player_name end) as LG,
       max(case when player_name = '삼성선수4' then player_name end) as 삼성
       from player_table;
       
