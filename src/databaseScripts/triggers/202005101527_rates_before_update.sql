/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 10/05/2020
 * 	Description: create of trigger for the table rates
*/

use utnphones;

drop trigger if exists rates_before_update;
delimiter //
create trigger if not exists rates_before_update
before update on rates
for each row
begin
set new.updaterUser=getDbUserName();
set new.updatedDate=now();
end //
delimiter ;