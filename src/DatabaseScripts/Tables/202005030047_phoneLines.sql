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
	idLocalAreaCode int not null,
	phoneNumber varchar(100) not null,
	idUser int not null,
	suspended bit(1) default(0),
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate datetime,
	constraint PK_phoneLines_idPhoneLine primary key(idPhoneLine),
	constraint UK_phoneLines_idLocalAreaCode_phoneNumber unique(idLocalAreaCode,phoneNumber),
	constraint FK_phoneLines_idLineType foreign key(idLineType) references lineTypes(idLineType) on update cascade,
	constraint FK_phoneLines_idLocalAreaCode foreign key(idLocalAreaCode) references localAreaCodes(idLocalAreaCode) on update cascade on delete cascade,
	constraint FK_phoneLines_idUser foreign key(idUser) references users(idUser) on update cascade on delete cascade
);