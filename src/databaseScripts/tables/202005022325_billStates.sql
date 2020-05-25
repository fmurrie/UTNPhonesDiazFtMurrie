/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 *  Description: create of table billStates
 */

use utnphones;

create table if not exists billStates
(
	idBillState int auto_increment,
	description varchar(100) not null,
    creatorUser varchar(100) not null,
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate datetime,
	constraint PK_billStates_idBillState primary key(idBillState),
	constraint UK_billStates_description unique(description)
);