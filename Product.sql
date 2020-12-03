create table Product
(
pno varchar(20) primary key,
pname varchar(20),
price int
),
insert into Product values('003','¿ÉÀÖ',3,400)
insert into Product values('004','Ñ©±Ì',3,500)
insert into Product values('005','ºÚ°ï½Ì¸¸',49,9999)
insert into Product values('006','test',1,9999)
insert into Product values('007','111',1,9999)
insert into Product values('008','WW',1,9999)
alter table Product add pnum int
delete from Product where pno='002'
select * from Product
SELECT PNAME FROM Product WHERE PNAME='¿ÉÀÖ'


create table UserInfo
( 
upname varchar(20) primary key,
uname varchar(20),
uprice int
)
alter table UserInfo add unum 
alter table UserInfo add balance int
update  UserInfo set balance=9999
insert into UserInfo values('¿ÉÀÖ','³ÂÐ¡Ðù¹þ',3,0)
delete from UserInfo where upname='test'
insert into UserInfo values('ºÚ°ï½Ì¸¸','³ÂÐ¡Ðù¹þ',49,0)
alter table  UserInfo drop primary key ;
alter table UserInfo add constraint Ö÷¼ü primary key(upname,uname);
select * from UserInfo

