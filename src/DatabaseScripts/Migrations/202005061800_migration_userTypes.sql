/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 06/05/2020
 *  Description: migration of data into the table userTypes.
 */

 use utnphones;

insert into userTypes (description) values ("Client");
insert into userTypes (description) values ("Employee");