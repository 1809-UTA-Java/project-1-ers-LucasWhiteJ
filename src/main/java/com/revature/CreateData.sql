--Fill the position table
insert into position (positionid, position) values (1, 'manager');
insert into position (positionid, position) values (2, 'programmer');
insert into position (positionid, position) values (3, 'accountant');

--Fill the employee table with employees
insert into employee (eid, eusername, epassword, efirstname, elastname, email, positionid) values (eidincrement.nextval, 'lwhite', 'password', 'lucas', 'white', 'lucaswhitej@gmail.com', 1);
insert into employee (eid, eusername, epassword, efirstname, elastname, email, positionid) values (eidincrement.nextval, 'coral', 'password', 'carl', 'grimes', 'coral@gmail.com', 2);
insert into employee (eid, eusername, epassword, efirstname, elastname, email, positionid) values (eidincrement.nextval, 'jdoe', 'password', 'john', 'doe', 'jdoe@gmail.com', 3);
insert into employee (eid, eusername, epassword, efirstname, elastname, email, positionid) values (eidincrement.nextval, 'adum', 'password', 'adam', 'johnston', 'ajohnston@gmail.com', 2);

--Fill the reimbursement status table
insert into reimbursementstatus (rsid, rstatus) values (1, 'pending');
insert into reimbursementstatus (rsid, rstatus) values (2, 'approved');
insert into reimbursementstatus (rsid, rstatus) values (3, 'denied');

--Fill the reimbursement type table
insert into reimbursementtype (rtid, rtype) values (1, 'travel');
insert into reimbursementtype (rtid, rtype) values (2, 'supplies');
insert into reimbursementtype (rtid, rtype) values (3, 'rental');

commit;