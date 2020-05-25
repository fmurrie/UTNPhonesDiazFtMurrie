/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 10/05/2020
 * 	Description: create of trigger for the table lineTypes
*/

use utnphones;

drop trigger if exists lineTypes_before_insert;
delimiter //
create trigger if not exists lineTypes_before_insert
before insert on lineTypes
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;