/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 10/05/2020
 * 	Description: create of trigger for the table interAreaCodes
*/

use utnphones;

drop trigger if exists interAreaCodes_before_insert;
delimiter //
create trigger if not exists interAreaCodes_before_insert
before insert on interAreaCodes
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;