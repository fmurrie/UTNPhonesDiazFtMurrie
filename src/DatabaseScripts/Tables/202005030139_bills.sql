/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 03/05/2020
 *  Description: create of table bills
 */

use utnphones;

create table if not exists bills
(
	idBill int auto_increment,
	idBillState int default(1),
	idPhoneLine int not null,
	callsQuantity int default(0),
	costPrice float,
	totalPrice float,
	billMonth varchar(100) not null,
	issueDate datetime default(now()),
	expiryDate datetime not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate datetime,
	constraint PK_bills_idBill primary key(idBill),
	constraint UK_bills_idPhoneLine_billMonth unique(idPhoneLine,billMonth),
	constraint FK_bills_idPhoneLine foreign key(idPhoneLine) references phoneLines(idPhoneLine) on update cascade on delete cascade
);