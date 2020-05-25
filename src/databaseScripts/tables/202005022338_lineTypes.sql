/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 *  Description: create of table lineTypes
 */

use utnphones;

create table if not exists lineTypes
(
	idLineType int auto_increment,
	description varchar(100) not null,
	code varchar(100) not null,
    creatorUser varchar(100) not null,
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate datetime,
	constraint PK_lineTypes_idLineType primary key(idLineType),
	constraint UK_lineTypes_description unique(description)
);