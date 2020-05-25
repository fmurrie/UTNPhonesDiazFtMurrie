/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 10/05/2020
 * 	Description: create of trigger for the table callTypes'
*/

use utnphones;

drop trigger if exists callTypes_before_update;
delimiter //
create trigger if not exists callTypes_before_update
before update on callTypes
for each row
begin
set new.updaterUser=getDbUserName();
set new.updatedDate=now();
end //
delimiter ;