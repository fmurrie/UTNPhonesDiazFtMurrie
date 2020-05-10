/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 10/05/2020
 * 	Description: create of trigger for the table localAreaCodes
*/

use utnphones;

drop trigger if exists localAreaCodes_before_update;
delimiter //
create trigger if not exists localAreaCodes_before_update
before update on localAreaCodes
for each row
begin
set new.updaterUser=getDbUserName();
set new.updatedDate=now();
end //
delimiter ;