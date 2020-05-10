/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 10/05/2020
 * 	Description: create of trigger for the table billStates
*/

use utnphones;

drop trigger if exists billStates_before_insert;
delimiter //
create trigger if not exists billStates_before_insert
before insert on billStates
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;