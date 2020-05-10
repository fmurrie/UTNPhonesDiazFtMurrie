/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 * 	Description: create of table userTypes
*/

use utnphones;

drop table if exists userTypes;

create table if not exists userTypes
(
	idUserType int auto_increment,
	description varchar(100) not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate datetime,
	constraint PK_userTypes_idUserType primary key(idUserType),
	constraint UK_userTypes_description unique(description)
);