/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 03/05/2020
 * 	Description: create of table calls
 */

use utnphones;

create table if not exists calls
(
	idCall int auto_increment,
	idBill int,
	idPhoneLineOrigin int not null,
	idPhoneLineDestiny int not null,
	initTime datetime not null,
	endTime datetime not null,
	durationSeconds float,
	totalPrice float,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate datetime,
	constraint PK_calls_idCall primary key(idCall),
	constraint CHK_calls_idPhoneLines_not_equal check(idPhoneLineOrigin!=idPhoneLineDestiny),
	constraint CHK_calls_endTime_bigger_or_equal_than_initTime check(initTime<=endTime),
	constraint CHK_calls_endTime_less_or_equal_than_now check(endTime<=now()),
	constraint FK_calls_idBill foreign key(idBill) references bills(idBill) on update cascade on delete cascade,
	constraint FK_calls_idPhoneLineOrigin foreign key(idPhoneLineOrigin) references phoneLines(idPhoneLine) on update cascade,
	constraint FK_calls_idPhoneLineDestiny foreign key(idPhoneLineDestiny) references phoneLines(idPhoneLine) on update cascade
);