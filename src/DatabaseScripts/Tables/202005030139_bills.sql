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