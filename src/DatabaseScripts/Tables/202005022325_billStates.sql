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

/*Triggers for the table billStates*/

/*Trigger before insert*/

drop trigger if exists billStates_before_insert;
delimiter //
create trigger if not exists billStates_before_insert
before insert on billStates
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger before update*/

drop trigger if exists billStates_before_update;
delimiter //
create trigger if not exists billStates_before_update
before update on billStates
for each row
begin
set new.updaterUser=getDbUserName();
set new.updatedDate=now();
end //
delimiter ;