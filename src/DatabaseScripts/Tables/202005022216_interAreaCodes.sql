/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 * 	Description: create of table interAreaCodes
 */

use utnphones;

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