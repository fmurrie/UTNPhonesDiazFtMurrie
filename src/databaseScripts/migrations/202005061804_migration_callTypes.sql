/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 07/05/2020
 *  Description: migration of data into the table callTypes.
*/

use utnphones;

drop procedure if exists migration_callTypes;
delimiter //
create procedure migration_callTypes
(
)
begin

if(not exists(select 1 from callTypes limit 1))
then

set autocommit=0;
start transaction;

INSERT INTO callTypes (description,cost,valueAdded) VALUES ('Local call',0.25,0.5);
INSERT INTO callTypes (description,cost,valueAdded) VALUES ('Provincial call',0.5,0.5);
INSERT INTO callTypes (description,cost,valueAdded) VALUES ('National call',1.25,0.5);
INSERT INTO callTypes (description,cost,valueAdded) VALUES ('International call',4.375,0.5);

commit;

end if;

end //
delimiter ;
