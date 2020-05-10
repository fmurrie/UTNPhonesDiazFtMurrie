/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 07/05/2020
 *  Description: migration of data into the table callTypes.
*/

use utnphones;

INSERT INTO callTypes (description,price,) VALUES ('Local call',1.5);
INSERT INTO callTypes (description,price,) VALUES ('National call',3);
INSERT INTO callTypes (description,price,) VALUES ('International call',15);

