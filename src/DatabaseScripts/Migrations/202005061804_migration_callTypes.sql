/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 07/05/2020
 *  Description: migration of data into the table callTypes.
*/

use utnphones;

INSERT INTO callTypes (description,minutePrice) VALUES ('Local call',0.5);
INSERT INTO callTypes (description,minutePrice) VALUES ('Provincial call',1);
INSERT INTO callTypes (description,minutePrice) VALUES ('National call',2.5);
INSERT INTO callTypes (description,minutePrice) VALUES ('International call',8.75);

