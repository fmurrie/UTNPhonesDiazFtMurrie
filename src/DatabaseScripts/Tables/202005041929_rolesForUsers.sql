/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 04/05/2020
 * 	Description: create of table rolesForUsers
*/

use utnphones;

drop table if exists rolesForUsers;

create table if not exists rolesForUsers
(
	idRole int not null,
	idUser int not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate timestamp,
	constraint PK_rolesForUsers_idUserState primary key(idRole,idUser),
	constraint FK_rolesForUsers_idRole foreign key(idRole) references roles(idRole) on update cascade on delete cascade,
	constraint FK_rolesForUsers_idUser foreign key(idUser) references users(idUser) on update cascade on delete cascade
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists rolesForUsers_audit_creator;
delimiter //
create trigger rolesForUsers_audit_creator
before insert on rolesForUsers
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists rolesForUsers_audit_updater;
delimiter //
create trigger rolesForUsers_audit_updater
before update on rolesForUsers
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;