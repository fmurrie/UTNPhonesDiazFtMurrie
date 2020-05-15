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
	idPhoneLineOrigin int not null,
	idPhoneLineDestinity int not null,
	initTime datetime not null,
	endTime datetime not null,
	durationSeconds float,
	totalPrice float,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate datetime,
	constraint PK_calls_idCall primary key(idCall),
	constraint CHK_calls_idPhoneLines_not_equal check(idPhoneLineOrigin!=idPhoneLineDestinity),
	constraint CHK_calls_endTime_bigger_or_equal_than_initTime check(initTime<=endTime),
	constraint FK_calls_idBill foreign key(idBill) references bills(idBill) on update cascade on delete cascade,
	constraint FK_calls_idPhoneLineOrigin foreign key(idPhoneLineOrigin) references phoneLines(idPhoneLine) on update cascade,
	constraint FK_calls_idPhoneLineDestinity foreign key(idPhoneLineDestinity) references phoneLines(idPhoneLine) on update cascade
);