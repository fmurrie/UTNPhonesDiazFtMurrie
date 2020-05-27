/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 *  Description: create of table countries
 */

use utnphones;

create table if not exists countries
(
	idCountry int auto_increment,
	name varchar(100) not null,
	iso varchar(100) not null,
	areaCode varchar(100) not null,
    creatorUser varchar(100) not null,
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate datetime,
	constraint PK_countries_idCountry primary key(idCountry),
	constraint UK_countries_name unique(name),
	constraint UK_countries_iso unique(iso)
);