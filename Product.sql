create table Product
(
pno varchar(20) primary key,
pname varchar(20),
price int
),
insert into Product values('003','����',3,400)
insert into Product values('004','ѩ��',3,500)
insert into Product values('005','�ڰ�̸�',49,9999)
insert into Product values('006','test',1,9999)
insert into Product values('007','111',1,9999)
insert into Product values('008','WW',1,9999)
alter table Product add pnum int
delete from Product where pno='002'
select * from Product
SELECT PNAME FROM Product WHERE PNAME='����'


create table UserInfo
( 
upname varchar(20) primary key,
uname varchar(20),
uprice int
)
alter table UserInfo add unum 
alter table UserInfo add balance int
update  UserInfo set balance=9999
insert into UserInfo values('����','��С����',3,0)
delete from UserInfo where upname='test'
insert into UserInfo values('�ڰ�̸�','��С����',49,0)
alter table  UserInfo drop primary key ;
alter table UserInfo add constraint ���� primary key(upname,uname);
select * from UserInfo

