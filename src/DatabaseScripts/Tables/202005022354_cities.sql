/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 *  Description: create of table cities
 */

use utnphones;

drop table if exists cities;

create table if not exists cities
(
	idCity int auto_increment,
	idLocalAreaCode int,
	name varchar(100) not null,
	idProvince int not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate timestamp,
	constraint PK_cities_idCity primary key(idCity),
	constraint UK_cities_name_idProvince unique(name,idProvince),
	constraint FK_cities_idProvince foreign key(idProvince) references provinces(idProvince) on update cascade on delete cascade,
	constraint FK_countries_idLocalAreaCode foreign key(idLocalAreaCode) references localAreaCodes(idLocalAreaCode) on update cascade
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists cities_audit_creator;
delimiter //
create trigger cities_audit_creator
before insert on cities
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists cities_audit_updater;
delimiter //
create trigger cities_audit_updater
before update on cities
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;