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
	idCountryAreaCode int not null,
	name varchar(100) not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate datetime,
	constraint PK_countries_idCountry primary key(idCountry),
	constraint UK_countries_name unique(name),
	constraint FK_countries_idCountryAreaCode foreign key(idCountryAreaCode) references countryAreaCodes(idCountryAreaCode) on update cascade
);

/*Triggers for the table countries*/

/*Trigger before insert*/

drop trigger if exists countries_before_insert;
delimiter //
create trigger if not exists countries_before_insert
before insert on countries
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger before update*/

drop trigger if exists countries_before_update;
delimiter //
create trigger if not exists countries_before_update
before update on countries
for each row
begin
set new.updaterUser=getDbUserName();
set new.updatedDate=now();
end //
delimiter ;