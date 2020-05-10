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
    updatedDate datetime,
	constraint PK_provinces_idProvince primary key(idProvince),
	constraint UK_provinces_name_idCountry unique(name,idCountry),
	constraint FK_provinces_idCountry foreign key(idCountry) references countries(idCountry) on update cascade on delete cascade
);

/*Triggers for the table provinces*/

/*Trigger before insert*/

drop trigger if exists provinces_before_insert;
delimiter //
create trigger if not exists provinces_before_insert
before insert on provinces
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger before update*/

drop trigger if exists provinces_before_update;
delimiter //
create trigger if not exists provinces_before_update
before update on provinces
for each row
begin
set new.updaterUser=getDbUserName();
set new.updatedDate=now();
end //
delimiter ;