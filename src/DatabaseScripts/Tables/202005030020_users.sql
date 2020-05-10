/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 03/05/2020
 *  Description: create of table users
 */

use utnphones;

drop table if exists users;

create table if not exists users
(
	idUser int auto_increment,
	idUserType int not null,
	dni varchar(100) not null,
	firstName varchar(100) not null,
	lastName varchar(100) not null,
	idCity int not null,
	username varchar(100) not null,
	userpassword varchar(100) not null,
	suspended bit(1) default(0),
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate datetime,
	constraint PK_users_idUser primary key(idUser),
	constraint UK_users_dni unique(dni),
	constraint UK_users_username unique(username),
	constraint FK_rolesForUsers_idUserType foreign key(idUserType) references userTypes(idUserType) on update cascade on delete cascade,
	constraint FK_users_idCity foreign key(idCity) references cities(idCity) on update cascade on delete cascade
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists users_audit_creator;
delimiter //
create trigger users_audit_creator
before insert on users
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists users_audit_updater;
delimiter //
create trigger users_audit_updater
before update on users
for each row
begin
set new.updaterUser=getDbUserName();
set new.updatedDate=now();
end //
delimiter ;