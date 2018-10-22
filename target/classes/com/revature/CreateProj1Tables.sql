drop table reimbursements;
drop sequence ridincrement;
drop table reimbursementstatus;
drop sequence rsidincrement;
drop table reimbursementtype;
drop sequence rtidincrement;
drop table employee;
drop sequence eidincrement;
drop table position;
drop sequence positionidincrement;

--Creates the reimbursements table
create table reimbursements (
	rid number(*,0) primary key,
	ramount number(22,2),
	rdescription varchar2(100),
	--rreceipt blob,
	rsubmitted timestamp,
	rresolved timestamp,
	uidauthor number(*,0),
	uidresolver number(*,0),
	rtype number(*,0),
	rstatus number(*,0)
);

--Creates a sequence to auto incerment the reimbursement id by 1
create sequence ridincrement start with 1 increment by 1;

--Creates the reimbursement status table
create table reimbursementstatus (
	rsid number(*,0) primary key,
	rstatus varchar2(30)
);

--Creates a sequence to auto incerment the reimbursement id by 1
create sequence rsidincrement start with 1 increment by 1;

--Creates the reimbursement type table
create table reimbursementtype (
	rtid number(*,0) primary key,
	rtype varchar2(30)
);

--Creates a sequence to auto incerment the reimbursement id by 1
create sequence rtidincrement start with 1 increment by 1;

--Creates the Employee table
create table employee (
	eid integer primary key,
	eusername varchar2(40),
	epassword varchar2(40),
	efirstname varchar2(30),
	elastname varchar2(30),
	email varchar2(100),
	positionid number(*,0)
);

--Creates a sequence to auto incerment the employee id by 1
create sequence eidincrement start with 1 increment by 1;

--Creates the position table
create table position (
	positionid number(*,0) primary key,
	position varchar2(40)
);

--Creates a sequence to auto incerment the reimbursement id by 1
create sequence positionidincrement start with 1 increment by 1;

--Sets reimbursements table's Foreign Keys
alter table reimbursements add constraint fkstatus
foreign key (rstatus)
references reimbursementstatus (rsid)
on delete cascade;

alter table reimbursements add constraint fktype
foreign key (rtype)
references reimbursementtype (rtid)
on delete cascade;

alter table reimbursements add constraint fkauthor
foreign key (uidauthor)
references employee (eid)
on delete cascade;

alter table reimbursements add constraint fkresolver
foreign key (uidresolver)
references employee (eid)
on delete cascade;

--Sets employee table's Foreign Keys
alter table employee add constraint fkposition
foreign key (positionid)
references position (positionid)
on delete cascade;
