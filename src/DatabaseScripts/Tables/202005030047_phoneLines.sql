/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 03/05/2020
 *  Description: create of table phoneLines
 */

use utnphones;

drop table if exists phoneLines;

create table if not exists phoneLines
(
	idPhoneLine int auto_increment,
	idLineType int not null,
	idLocalAreaCode int not null,
	phoneNumber varchar(100) not null,
	idUser int not null,
	suspended bit(1) default(0),
	logicDelete bit(1) default(0),
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate timestamp,
	constraint PK_phoneLines_idPhoneLine primary key(idPhoneLine),
	constraint UK_phoneLines_idLocalAreaCode_phoneNumber unique(idLocalAreaCode,phoneNumber),
	constraint FK_phoneLines_idLineType foreign key(idLineType) references lineTypes(idLineType) on update cascade,
	constraint FK_phoneLines_idLocalAreaCode foreign key(idLocalAreaCode) references localAreaCodes(idLocalAreaCode) on update cascade on delete cascade,
	constraint FK_phoneLines_idUser foreign key(idUser) references users(idUser) on update cascade on delete cascade
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists phoneLines_audit_creator;
delimiter //
create trigger phoneLines_audit_creator
before insert on phoneLines
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists phoneLines_audit_updater;
delimiter //
create trigger phoneLines_audit_updater
before update on phoneLines
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;