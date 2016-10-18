create table member(
	id int not null auto_increment primary key,
	memberNo int(3) zerofill not null unique key,
	level varchar(50) not null,
	name varchar(50) not null,
	phone varchar(50),
	email varchar(100)
)default charset = utf8;

insert into member(memberNo, level, name, phone, email) values(1, 'developer', 'wonny1', '010-0000-0000', 'wonny1@wonny.com');
insert into member(memberNo, level, name, phone, email) values(2, 'developer', 'wonny2', '010-0000-0001', 'wonny2@wonny.com');
insert into member(memberNo, level, name, phone, email) values(3, 'developer', 'wonny3', '010-0000-0002', 'wonny3@wonny.com');
insert into member(memberNo, level, name, phone, email) values(4, 'developer', 'wonny4', '010-0000-0003', 'wonny4@wonny.com');
insert into member(memberNo, level, name, phone, email) values(5, 'developer', 'wonny5', '010-0000-0004', 'wonny5@wonny.com');
insert into member(memberNo, level, name, phone, email) values(6, 'developer', 'wonny6', '010-0000-0005', 'wonny6@wonny.com');

