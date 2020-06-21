/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 03/05/2020
 *  Description: create of table phoneLines
 */

use utnphones;

create table if not exists phoneLines
(
	idPhoneLine int auto_increment,
	idLineType int not null,
	phoneNumber varchar(100) not null,
	idUser int not null,
	suspended boolean default(false),
	deleted boolean default(false),
    creatorUser varchar(100) not null,
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate datetime,
	constraint PK_phoneLines_idPhoneLine primary key(idPhoneLine),
	constraint UK_phoneLines_phoneNumber unique(phoneNumber),
	constraint FK_phoneLines_idLineType foreign key(idLineType) references lineTypes(idLineType) on update cascade,
	constraint FK_phoneLines_idUser foreign key(idUser) references users(idUser) on update cascade on delete cascade
);