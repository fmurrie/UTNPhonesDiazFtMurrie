/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 03/05/2020
 * 	Description: create of table calls
 */

use utnphones;

create table if not exists calls
(
	idCall int auto_increment,
	idCallType int not null,
	idBill int,
	idPhoneLineOrigin int not null,
	idPhoneLineDestiny int not null,
	initTime datetime not null,
	endTime datetime not null,
	durationSeconds float not null,
	totalPrice float default(0),
    creatorUser varchar(100) not null,
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate datetime,
	constraint PK_calls_idCall primary key(idCall),
	constraint CHK_calls_idPhoneLines_not_equal check(idPhoneLineOrigin!=idPhoneLineDestiny),
	constraint CHK_calls_endTime_bigger_or_equal_than_initTime check(initTime<=endTime),
	constraint FK_calls_idCallType foreign key(idCallType) references callTypes(idCallType) on update cascade on delete cascade,
	constraint FK_calls_idBill foreign key(idBill) references bills(idBill) on update cascade on delete cascade,
	constraint FK_calls_idPhoneLineOrigin foreign key(idPhoneLineOrigin) references phoneLines(idPhoneLine) on update cascade,
	constraint FK_calls_idPhoneLineDestiny foreign key(idPhoneLineDestiny) references phoneLines(idPhoneLine) on update cascade
);

/*Indexes for the searchs in the table calls*/

create index if not exists idx_calls_origin_destiny_init_end on calls(idPhoneLineOrigin,idPhoneLineDestiny,initTime,endTime) using btree;
create index if not exists idx_calls_origin_destiny_init on calls(idPhoneLineOrigin,idPhoneLineDestiny,initTime) using btree;
create index if not exists idx_calls_origin_destiny_end on calls(idPhoneLineOrigin,idPhoneLineDestiny,endTime) using btree;
create index if not exists idx_calls_origin_init_end on calls(idPhoneLineOrigin,initTime,endTime) using btree;
create index if not exists idx_calls_origin_init on calls(idPhoneLineOrigin,initTime) using btree;
create index if not exists idx_calls_origin_end on calls(idPhoneLineOrigin,endTime) using btree;
create index if not exists idx_calls_destiny_init_end on calls(idPhoneLineDestiny,initTime,endTime) using btree;
create index if not exists idx_calls_destiny_init on calls(idPhoneLineDestiny,initTime) using btree;
create index if not exists idx_calls_destiny_end on calls(idPhoneLineDestiny,endTime) using btree;
create index if not exists idx_calls_init_end on calls(initTime,endTime) using btree;
create index if not exists idx_calls_init on calls(initTime) using btree;
create index if not exists idx_calls_end on calls(endTime) using btree;