insert into users 
(idUserType,dni,firstName,lastName,idCity,username,userpassword) 
values
(1,'123','fmurrie','fmurrie',1,'fmurrie','fmurrie'),
(1,'456','jmurrie','jmurrie',2,'jmurrie','jmurrie');

insert into phoneLines
(idLineType,phoneNumber,idUser)
values
(1,'123',1),(1,'456',1),
(1,'456',2),(1,'123',2); 


insert into calls
(idPhoneLineOrigin,idPhoneLineDestiny,initTime,endTime)
values
(1,3,DATE_ADD(now(), INTERVAL -1 hour),now());

insert into calls
(idPhoneLineOrigin,idPhoneLineDestiny,initTime,endTime)
values
(1,4,DATE_ADD(now(), INTERVAL -1 hour),now());

insert into calls
(idPhoneLineOrigin,idPhoneLineDestiny,initTime,endTime)
values
(2,3,DATE_ADD(now(), INTERVAL -1 hour),now());

insert into calls
(idPhoneLineOrigin,idPhoneLineDestiny,initTime,endTime)
values
(2,4,DATE_ADD(now(), INTERVAL -1 hour),now());

insert into calls
(idPhoneLineOrigin,idPhoneLineDestiny,initTime,endTime)
values
(3,1,DATE_ADD(now(), INTERVAL -1 hour),now());

insert into calls
(idPhoneLineOrigin,idPhoneLineDestiny,initTime,endTime)
values
(3,2,DATE_ADD(now(), INTERVAL -1 hour),now());

insert into calls
(idPhoneLineOrigin,idPhoneLineDestiny,initTime,endTime)
values
(4,1,DATE_ADD(now(), INTERVAL -1 hour),now());

insert into calls
(idPhoneLineOrigin,idPhoneLineDestiny,initTime,endTime)
values
(4,2,DATE_ADD(now(), INTERVAL -1 hour),now());

select * from calls;
select * from bills;

SET SQL_SAFE_UPDATES = 0;

call bills_monthFacturation();



