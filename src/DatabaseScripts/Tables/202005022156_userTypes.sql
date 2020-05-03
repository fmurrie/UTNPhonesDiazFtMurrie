/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 * 	Description: create of table userTypes
 */

use utnphones;

drop table if exists userTypes;

create table if not exists userTypes
(
	creatorUser varchar(100),
	createdDate datetime default(now()),
	updaterUser varchar(100),
	updatedDate timestamp,
	idUserState int auto_increment,
	description varchar(100) not null,
	constraint PK_userTypes_idUserState primary key(idUserState),
	constraint UK_userTypes_description unique(description)
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists userTypes_audit_creator;
delimiter //
create trigger if not exists userTypes_audit_creator
before insert on userTypes
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists userTypes_audit_updater;
delimiter //
create trigger if not exists userTypes_audit_updater
before update on userTypes
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;
