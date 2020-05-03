drop database if exists utnphones;
create database if not exists utnphones;

/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 *  Description: Function that returns the name of
 * 	the current user in the database
 */

use utnphones;

drop function if exists getDbUserName;
delimiter //
create function  getDbUserName
(
)
returns varchar(100)
not deterministic
begin
  declare dbUserName varchar(100);

  set dbUserName=(SELECT LEFT(CURRENT_USER(), INSTR(CURRENT_USER(), '@') - 1));

  return dbUserName;
end //
delimiter ;

/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 03/05/2020
 *  Description: function that retrieves a date from 15 days before of the actual date
 */

use utnphones;

drop function if exists getDateIn15Days;
delimiter //
create function getDateIn15Days
(
)
returns datetime
deterministic
begin
  declare dateIn15Days datetime;

  set dateIn15Days=(SELECT DATE_ADD(now(), INTERVAL 15 DAY));

  return dateIn15Days;
end //
delimiter ;

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
    updatedDate timestamp,
	constraint PK_userTypes_idUserState primary key(idUserType),
	constraint UK_userTypes_description unique(description)
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists userTypes_audit_creator;
delimiter //
create trigger userTypes_audit_creator
before insert on userTypes
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists userTypes_audit_updater;
delimiter //
create trigger userTypes_audit_updater
before update on userTypes
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;

/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 * 	Description: create of table companies
 */

use utnphones;

drop table if exists companies;

create table if not exists companies
(
	idCompany int auto_increment,
    logicDelete bit(1) default(0),
	name varchar(100) not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate timestamp,
	constraint PK_companies_idCompany primary key(idCompany),
	constraint UK_companies_name unique(name)
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists companies_audit_creator;
delimiter //
create trigger companies_audit_creator
before insert on companies
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists companies_audit_updater;
delimiter //
create trigger companies_audit_updater
before update on companies
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;

/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 * 	Description: create of table interAreaCodes
 */

use utnphones;

drop table if exists interAreaCodes;

create table if not exists interAreaCodes
(
	idInterAreaCode int auto_increment,
	code varchar(100) not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate timestamp,
	constraint PK_interAreaCodes_idInterAreaCode primary key(idInterAreaCode),
	constraint UK_interAreaCodes_code unique(code)
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists interAreaCodes_audit_creator;
delimiter //
create trigger interAreaCodes_audit_creator
before insert on interAreaCodes
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists interAreaCodes_audit_updater;
delimiter //
create trigger interAreaCodes_audit_updater
before update on interAreaCodes
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;

/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 * 	Description: create of table countryAreaCodes
 */

use utnphones;

drop table if exists countryAreaCodes;

create table if not exists countryAreaCodes
(
	idCountryAreaCode int auto_increment,
	code varchar(100) not null,
	idInterAreaCode int not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate timestamp,
	constraint PK_countryAreaCodes_idCountryAreaCode primary key(idCountryAreaCode),
	constraint UK_countryAreaCodes_code unique(code),
	constraint FK_countryAreaCodes_idInterAreaCode foreign key(idInterAreaCode) references interAreaCodes(idInterAreaCode) on update cascade
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists countryAreaCodes_audit_creator;
delimiter //
create trigger countryAreaCodes_audit_creator
before insert on countryAreaCodes
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists countryAreaCodes_audit_updater;
delimiter //
create trigger countryAreaCodes_audit_updater
before update on countryAreaCodes
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;

/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 * 	Description: create of table localAreaCodes
 */

use utnphones;

drop table if exists localAreaCodes ;

create table if not exists localAreaCodes
(
	idLocalAreaCode int auto_increment,
	code varchar(100) not null,
	idCountryAreaCode int not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate timestamp,
	constraint PK_localAreaCodes_idLocalAreaCode primary key(idLocalAreaCode),
	constraint UK_localAreaCodes_code unique(code),
	constraint FK_localAreaCodes_idCountryAreaCode foreign key(idCountryAreaCode) references countryAreaCodes(idCountryAreaCode) on update cascade
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists localAreaCodes_audit_creator;
delimiter //
create trigger localAreaCodes_audit_creator
before insert on localAreaCodes
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists localAreaCodes_audit_updater;
delimiter //
create trigger localAreaCodes_audit_updater
before update on localAreaCodes
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;

/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 *  Description: create of table countries
 */

use utnphones;

drop table if exists countries;

create table if not exists countries
(
	idCountry int auto_increment,
	idCountryAreaCode int,
	name varchar(100) not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate timestamp,
	constraint PK_countries_idCountry primary key(idCountry),
	constraint UK_countries_name unique(name),
	constraint UK_countries_idCountryAreaCode unique(idCountryAreaCode),
	constraint FK_countries_idCountryAreaCode foreign key(idCountryAreaCode) references countryAreaCodes(idCountryAreaCode) on update cascade
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists countries_audit_creator;
delimiter //
create trigger countries_audit_creator
before insert on countries
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists countries_audit_updater;
delimiter //
create trigger countries_audit_updater
before update on countries
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;

/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 *  Description: create of table billStates
 */

use utnphones;

drop table if exists billStates;

create table if not exists billStates
(
	idBillState int auto_increment,
	description varchar(100) not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate timestamp,
	constraint PK_billStates_idBillState primary key(idBillState),
	constraint UK_billStates_description unique(description)
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists billStates_audit_creator;
delimiter //
create trigger billStates_audit_creator
before insert on billStates
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists billStates_audit_updater;
delimiter //
create trigger billStates_audit_updater
before update on billStates
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;

/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 *  Description: create of table lineTypes
 */

use utnphones;

drop table if exists lineTypes;

create table if not exists lineTypes
(
	idLineType int auto_increment,
	description varchar(100) not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate timestamp,
	constraint PK_lineTypes_idLineType primary key(idLineType),
	constraint UK_lineTypes_description unique(description)
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists lineTypes_audit_creator;
delimiter //
create trigger lineTypes_audit_creator
before insert on lineTypes
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists lineTypes_audit_updater;
delimiter //
create trigger lineTypes_audit_updater
before update on lineTypes
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;

/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 *  Description: create of table provinces
 */

use utnphones;

drop table if exists provinces;

create table if not exists provinces
(
	idProvince int auto_increment,
	name varchar(100) not null,
	idCountry int not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate timestamp,
	constraint PK_provinces_idProvince primary key(idProvince),
	constraint UK_provinces_name_idCountry unique(name,idCountry),
	constraint FK_provinces_idCountry foreign key(idCountry) references countries(idCountry) on update cascade on delete cascade
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists provinces_audit_creator;
delimiter //
create trigger provinces_audit_creator
before insert on provinces
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists provinces_audit_updater;
delimiter //
create trigger provinces_audit_updater
before update on provinces
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;

/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 *  Description: create of table cities
 */

use utnphones;

drop table if exists cities;

create table if not exists cities
(
	idCity int auto_increment,
	idLocalAreaCode int,
	name varchar(100) not null,
	idProvince int not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate timestamp,
	constraint PK_cities_idCity primary key(idCity),
	constraint UK_cities_name_idProvince unique(name,idProvince),
	constraint FK_cities_idProvince foreign key(idProvince) references provinces(idProvince) on update cascade on delete cascade,
	constraint FK_countries_idLocalAreaCode foreign key(idLocalAreaCode) references localAreaCodes(idLocalAreaCode) on update cascade
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists cities_audit_creator;
delimiter //
create trigger cities_audit_creator
before insert on cities
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists cities_audit_updater;
delimiter //
create trigger cities_audit_updater
before update on cities
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;

/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 03/05/2020
 *  Description: create of table users
 */

use utnphones;

drop table if exists users;

create table if not exists users
(
	idUser int auto_increment,
	idUserType int not null,
	dni varchar(100) not null,
	firstName varchar(100) not null,
	lastName varchar(100) not null,
	idCity int not null,
	username varchar(100) not null,
	userpassword varchar(100) not null,
    logicDelete bit(1) default(0),
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate timestamp,
	constraint PK_users_idUser primary key(idUser),
	constraint UK_users_dni unique(dni),
	constraint UK_users_username unique(username),
	constraint FK_users_idUserType foreign key(idUserType) references userTypes(idUserType) on update cascade,
	constraint FK_users_idCity foreign key(idCity) references cities(idCity) on update cascade on delete cascade
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists users_audit_creator;
delimiter //
create trigger users_audit_creator
before insert on users
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists users_audit_updater;
delimiter //
create trigger users_audit_updater
before update on users
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;

/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 03/05/2020
 *  Description: create of table phoneLines
 */

use utnphones;

drop table if exists phoneLines;

create table if not exists phoneLines
(
	idPhoneLine int auto_increment,
	idLineType int not null,
	idLocalAreaCode int not null,
	phoneNumber varchar(100) not null,
	idUser int not null,
	logicDelete bit(1) default(0),
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate timestamp,
	constraint PK_phoneLines_idPhoneLine primary key(idPhoneLine),
	constraint UK_phoneLines_idLocalAreaCode_phoneNumber unique(idLocalAreaCode,phoneNumber),
	constraint FK_phoneLines_idLineType foreign key(idLineType) references lineTypes(idLineType) on update cascade,
	constraint FK_phoneLines_idLocalAreaCode foreign key(idLocalAreaCode) references localAreaCodes(idLocalAreaCode) on update cascade on delete cascade,
	constraint FK_phoneLines_idUser foreign key(idUser) references users(idUser) on update cascade on delete cascade
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists phoneLines_audit_creator;
delimiter //
create trigger phoneLines_audit_creator
before insert on phoneLines
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists phoneLines_audit_updater;
delimiter //
create trigger phoneLines_audit_updater
before update on phoneLines
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;

/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 03/05/2020
 *  Description: create of table bills
 */

use utnphones;

drop table if exists bills;

create table if not exists bills
(
	idBill int auto_increment,
	idBillState int not null,
	idPhoneLine int not null,
	callsQuantity int default(0),
	costPrice float,
	totalPrice float,
	billMonth varchar(100) default(extract(year_month from now())),
	issueDate datetime default(now()),
	expiryDate datetime null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate timestamp,
	constraint PK_bills_idBill primary key(idBill),
	constraint UK_bills_idPhoneLine_billMonth unique(idPhoneLine,billMonth),
	constraint FK_bills_idPhoneLine foreign key(idPhoneLine) references phoneLines(idPhoneLine) on update cascade on delete cascade
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists bills_audit_creator;
delimiter //
create trigger bills_audit_creator
before insert on bills
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists bills_audit_updater;
delimiter //
create trigger bills_audit_updater
before update on bills
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;

/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 03/05/2020
 * 	Description: create of table rates
 */

use utnphones;

drop table if exists rates;

create table if not exists rates
(
	idOriginCity int not null,
	idDestinityCity int not null,
	minutePrice varchar(50) not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate timestamp,
	constraint PK_rates_idOriginCity_idDestinityCity primary key(idOriginCity,idDestinityCity),
	constraint FK_rates_idOriginCity foreign key(idOriginCity) references cities(idCity) on update cascade on delete cascade,
	constraint FK_rates_idDestinityCity foreign key(idDestinityCity) references cities(idCity) on update cascade on delete cascade
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists rates_audit_creator;
delimiter //
create trigger rates_audit_creator
before insert on rates
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists rates_audit_updater;
delimiter //
create trigger rates_audit_updater
before update on rates
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;

/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 03/05/2020
 * 	Description: create of table calls
 */

use utnphones;

drop table if exists calls;

create table if not exists calls
(
	idCall int auto_increment,
	idBill int,
	idPhoneLineOrigin int,
	idPhoneLineDestinity int,
	initTime datetime not null,
	endTime datetime,
	duration float,
	totalPrice float,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate timestamp,
	constraint PK_calls_idCall primary key(idCall),
	constraint CHK_calls_idPhoneLineOrigin_not_null check(idPhoneLineOrigin!=null),
	constraint CHK_calls_idPhoneLineDestinity_not_null check(idPhoneLineDestinity!=null),
	constraint CHK_calls_idPhoneLines_not_equal check(idPhoneLineOrigin!=idPhoneLineDestinity),
	constraint CHK_calls_initTime_bigger_than_endTime check((initTime>=endTime) or ((initTime!=null) and (endTime=null))),
	constraint FK_calls_idBill foreign key(idBill) references bills(idBill) on update cascade on delete cascade,
	constraint FK_calls_idPhoneLineOrigin foreign key(idPhoneLineOrigin) references phoneLines(idPhoneLine) on update cascade,
	constraint FK_calls_idPhoneLineDestinity foreign key(idPhoneLineDestinity) references phoneLines(idPhoneLine) on update cascade
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists calls_audit_creator;
delimiter //
create trigger calls_audit_creator
before insert on calls
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists calls_audit_updater;
delimiter //
create trigger calls_audit_updater
before update on calls
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;