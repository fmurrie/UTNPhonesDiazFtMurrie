/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 *  Description: create of table billStates
 */

use utnphones;

drop table if exists billStates;

create table if not exists billStates
(
	idBillState int auto_increment,
	description varchar(100) not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate datetime,
	constraint PK_billStates_idBillState primary key(idBillState),
	constraint UK_billStates_description unique(description)
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists billStates_audit_creator;
delimiter //
create trigger billStates_audit_creator
before insert on billStates
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists billStates_audit_updater;
delimiter //
create trigger billStates_audit_updater
before update on billStates
for each row
begin
set new.updaterUser=getDbUserName();
set new.updatedDate=now();
end //
delimiter ;