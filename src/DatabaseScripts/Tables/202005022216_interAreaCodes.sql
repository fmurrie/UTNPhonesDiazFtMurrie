/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 * 	Description: create of table interAreaCodes
 */

use utnphones;

drop table if exists interAreaCodes;

create table if not exists interAreaCodes
(
	idInterAreaCode int auto_increment,
	code varchar(100) not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate datetime,
	constraint PK_interAreaCodes_idInterAreaCode primary key(idInterAreaCode),
	constraint UK_interAreaCodes_code unique(code)
);

/*Triggers for the table interAreaCodes*/

/*Trigger before insert*/

drop trigger if exists interAreaCodes_before_insert;
delimiter //
create trigger if not exists interAreaCodes_before_insert
before insert on interAreaCodes
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger before update*/

drop trigger if exists interAreaCodes_before_update;
delimiter //
create trigger if not exists interAreaCodes_before_update
before update on interAreaCodes
for each row
begin
set new.updaterUser=getDbUserName();
set new.updatedDate=now();
end //
delimiter ;