/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 06/05/2020
 *  Description: migration of data into the table lineTypes.
 */

use utnphones;

insert into lineTypes (description,code) values ("Mobile","9");
insert into lineTypes (description,code) values ("Residential","11");
