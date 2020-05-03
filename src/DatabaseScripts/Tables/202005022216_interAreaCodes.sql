/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 * 	Description: create of table interAreaCodes
 */

use utnphones;

drop table if exists interAreaCodes;

create table if not exists interAreaCodes
(
	creatorUser varchar(100),
	createdDate datetime default(now()),
	updaterUser varchar(100),
	updatedDate timestamp,
	idInterAreaCode int auto_increment,
	code varchar(100) not null,
	constraint PK_interAreaCodes_idInterAreaCode primary key(idInterAreaCode),
	constraint UK_interAreaCodes_code unique(code)
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists interAreaCodes_audit_creator;
delimiter //
create trigger if not exists interAreaCodes_audit_creator before insert on interAreaCodes
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists interAreaCodes_audit_updater;
delimiter //
create trigger if not exists interAreaCodes_audit_updater before update on interAreaCodes
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;