/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 06/05/2020
 *  Description: migration of data into the table billStates.
 */

use utnphones;

insert into billStates (description) values ("Unpaid");
insert into billStates (description) values ("Partially-paid");
insert into billStates (description) values ("Paid");
