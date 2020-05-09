/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 03/05/2020
 * 	Description: create of table calls
 */

use utnphones;

drop table if exists calls;

create table if not exists calls
(
	idCall int auto_increment,
	idBill int,
	idPhoneLineOrigin int,
	idPhoneLineDestinity int,
	initTime datetime not null,
	endTime datetime,
	duration float,
	totalPrice float,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate datetime,
	constraint PK_calls_idCall primary key(idCall),
	constraint CHK_calls_idPhoneLineOrigin_not_null check(idPhoneLineOrigin!=null),
	constraint CHK_calls_idPhoneLineDestinity_not_null check(idPhoneLineDestinity!=null),
	constraint CHK_calls_idPhoneLines_not_equal check(idPhoneLineOrigin!=idPhoneLineDestinity),
	constraint CHK_calls_initTime_bigger_than_endTime check((initTime>=endTime) or ((initTime!=null) and (endTime=null))),
	constraint FK_calls_idBill foreign key(idBill) references bills(idBill) on update cascade on delete cascade,
	constraint FK_calls_idPhoneLineOrigin foreign key(idPhoneLineOrigin) references phoneLines(idPhoneLine) on update cascade,
	constraint FK_calls_idPhoneLineDestinity foreign key(idPhoneLineDestinity) references phoneLines(idPhoneLine) on update cascade
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists calls_audit_creator;
delimiter //
create trigger calls_audit_creator
before insert on calls
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists calls_audit_updater;
delimiter //
create trigger calls_audit_updater
before update on calls
for each row
begin
set new.updaterUser=getDbUserName();
set new.updatedDate=now();
end //
delimiter ;