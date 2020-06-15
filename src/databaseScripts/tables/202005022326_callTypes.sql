/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 *  Description: create of table callTypes
 */

 use utnphones;

 create table if not exists callTypes
 (
    idCallType int auto_increment,
	description varchar(100) not null,
	minutePrice float not null,
	cost float not null,
	valueAdded float not null,
 	creatorUser varchar(100) not null,
 	createdDate datetime default(now()),
 	updaterUser varchar(100),
 	updatedDate datetime,
    constraint PK_callTypes_idCallType primary key(idCallType),
    constraint UK_callTypes_description unique(description)
 );