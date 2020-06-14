/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 10/05/2020
 * 	Description: create of trigger for the table callTypes
*/

use utnphones;

drop trigger if exists callTypes_before_insert;
delimiter //
create trigger if not exists callTypes_before_insert
before insert on callTypes
for each row
begin
set new.minutePrice=new.cost+(new.cost*new.valueAdded);
set new.creatorUser=getDbUserName();
end //
delimiter ;