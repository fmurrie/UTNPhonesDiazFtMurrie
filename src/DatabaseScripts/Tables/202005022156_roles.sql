/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 * 	Description: create of table userTypes
 *******************************************
 * 	Author: Murrie Battistoni Felipe
 * 	Modify Date: 04/05/2020
 * 	Description: rename of table userTypes for roles
*/

use utnphones;

drop table if exists roles;

create table if not exists roles
(
	idRole int auto_increment,
	description varchar(100) not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate timestamp,
	constraint PK_roles_idUserState primary key(idRole),
	constraint UK_roles_description unique(description)
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists roles_audit_creator;
delimiter //
create trigger roles_audit_creator
before insert on roles
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists roles_audit_updater;
delimiter //
create trigger roles_audit_updater
before update on roles
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;
