/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 10/05/2020
 * 	Description: create of trigger for the table lineTypes
*/

use utnphones;

drop trigger if exists lineTypes_before_update;
delimiter //
create trigger if not exists lineTypes_before_update
before update on lineTypes
for each row
begin
set new.updaterUser=getDbUserName();
set new.updatedDate=now();
end //
delimiter ;