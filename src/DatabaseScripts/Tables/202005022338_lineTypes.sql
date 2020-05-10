/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 *  Description: create of table lineTypes
 */

use utnphones;

drop table if exists lineTypes;

create table if not exists lineTypes
(
	idLineType int auto_increment,
	description varchar(100) not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate datetime,
	constraint PK_lineTypes_idLineType primary key(idLineType),
	constraint UK_lineTypes_description unique(description)
);

/*Triggers for the table lineTypes*/

/*Trigger before insert*/

drop trigger if exists lineTypes_before_insert;
delimiter //
create trigger if not exists lineTypes_before_insert
before insert on lineTypes
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger before update*/

drop trigger if exists lineTypes_before_update;
delimiter //
create trigger if not exists lineTypes_before_update
before update on lineTypes
for each row
begin
set new.updaterUser=getDbUserName();
set new.updatedDate=now();
end //
delimiter ;