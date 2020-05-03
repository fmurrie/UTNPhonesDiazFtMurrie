/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 *  Description: create of table countries
 */

use utnphones;

drop table if exists countries;

create table if not exists countries
(
	idCountry int auto_increment,
	idCountryAreaCode int,
	name varchar(100) not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate timestamp,
	constraint PK_countries_idCountry primary key(idCountry),
	constraint UK_countries_name unique(name),
	constraint UK_countries_idCountryAreaCode unique(idCountryAreaCode),
	constraint FK_countries_idCountryAreaCode foreign key(idCountryAreaCode) references countryAreaCodes(idCountryAreaCode) on update cascade
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists countries_audit_creator;
delimiter //
create trigger countries_audit_creator
before insert on countries
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists countries_audit_updater;
delimiter //
create trigger countries_audit_updater
before update on countries
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;