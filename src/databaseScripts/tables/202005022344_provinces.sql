/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 *  Description: create of table provinces
 */

use utnphones;

create table if not exists provinces
(
	idProvince int auto_increment,
	name varchar(100) not null,
	idCountry int not null,
    creatorUser varchar(100) not null,
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate datetime,
	constraint PK_provinces_idProvince primary key(idProvince),
	constraint UK_provinces_name_idCountry unique(name,idCountry),
	constraint FK_provinces_idCountry foreign key(idCountry) references countries(idCountry) on update cascade on delete cascade
);