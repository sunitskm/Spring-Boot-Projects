insert into department (dept_id,dept_name) values(1001,'Fooding');
insert into department (dept_id,dept_name) values(1002,'Bedding');
insert into department (dept_id,dept_name) values(1003,'Clothes');

insert into employee (emp_id,email_id,first_name,is_valid,last_name,password) values('emp1','emp1.com','first1',0,'last1','fistlast1');
insert into employee (emp_id,email_id,first_name,is_valid,last_name,password) values('emp2','emp2.com','first2',1,'last2','fistlast2');

insert into CQT_REL_EMP_DEPT values(1001,'emp1');
insert into CQT_REL_EMP_DEPT values(1002,'emp2');


insert into customer (c_id,email_id,first_name,is_valid,last_name,password) values('cust1','cust1@cust.com','first1',1,'last1','firstlast1');
insert into customer (c_id,email_id,first_name,is_valid,last_name,password) values('cust2','cust2@cust.com','first2',0,'last2','firstlast2');

insert into query (q_id,rating, status) values (1001,4,'Resolved');
insert into query (q_id,rating, status) values (1002,0,'Unassigned');

insert into cqt_rel_query_dept values (1003,1001);
insert into cqt_rel_query_dept values (1001,1002);

insert into cqt_rel_query_cust values ('cust1',1001);
insert into cqt_rel_query_cust values ('cust2',1002);


insert into cqt_rel_query_emp values ('emp2',1002);