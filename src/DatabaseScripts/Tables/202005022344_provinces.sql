/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 *  Description: create of table provinces
 */

use utnphones;

drop table if exists provinces;

create table if not exists provinces
(
	idProvince int auto_increment,
	name varchar(100) not null,
	idCountry int not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate timestamp,
	constraint PK_provinces_idProvince primary key(idProvince),
	constraint UK_provinces_name_idCountry unique(name,idCountry),
	constraint FK_provinces_idCountry foreign key(idCountry) references countries(idCountry) on update cascade on delete cascade
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists provinces_audit_creator;
delimiter //
create trigger provinces_audit_creator
before insert on provinces
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists provinces_audit_updater;
delimiter //
create trigger provinces_audit_updater
before update on provinces
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;