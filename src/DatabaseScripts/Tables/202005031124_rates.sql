/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 03/05/2020
 * 	Description: create of table rates
 */

use utnphones;

create table if not exists rates
(
	idOriginCity int not null,
	idDestinyCity int not null,
	minutePrice float not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate datetime,
	constraint PK_rates_idOriginCity_idDestinyCity primary key(idOriginCity,idDestinyCity),
	constraint FK_rates_idOriginCity foreign key(idOriginCity) references cities(idCity) on update cascade on delete cascade,
	constraint FK_rates_idDestinyCity foreign key(idDestinyCity) references cities(idCity) on update cascade on delete cascade
);