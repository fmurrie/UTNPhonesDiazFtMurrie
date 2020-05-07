/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 * 	Description: create of table localAreaCodes
 */

use utnphones;

drop table if exists localAreaCodes ;

create table if not exists localAreaCodes
(
	idLocalAreaCode int auto_increment,
	code varchar(100) not null,
	idCountryAreaCode int not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate timestamp,
	constraint PK_localAreaCodes_idLocalAreaCode primary key(idLocalAreaCode),
	constraint UK_localAreaCodes_code unique(code),
	constraint FK_localAreaCodes_idCountryAreaCode foreign key(idCountryAreaCode) references countryAreaCodes(idCountryAreaCode) on update cascade on delete cascade
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists localAreaCodes_audit_creator;
delimiter //
create trigger localAreaCodes_audit_creator
before insert on localAreaCodes
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists localAreaCodes_audit_updater;
delimiter //
create trigger localAreaCodes_audit_updater
before update on localAreaCodes
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;