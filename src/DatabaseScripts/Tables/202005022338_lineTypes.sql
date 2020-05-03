/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 *  Description: create of table lineTypes
 */

use utnphones;

drop table if exists lineTypes;

create table if not exists lineTypes
(
	creatorUser varchar(100),
	createdDate datetime default(now()),
	updaterUser varchar(100),
	updatedDate timestamp,
	idLineType int auto_increment,
	description varchar(100) not null,
	constraint PK_lineTypes_idLineType primary key(idLineType),
	constraint UK_lineTypes_description unique(description)
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists lineTypes_audit_creator;
delimiter //
create trigger if not exists lineTypes_audit_creator
before insert on lineTypes
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists lineTypes_audit_updater;
delimiter //
create trigger if not exists lineTypes_audit_updater
before update on lineTypes
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;