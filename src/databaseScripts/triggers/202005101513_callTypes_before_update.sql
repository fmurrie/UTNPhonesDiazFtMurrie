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

if((new.valueAdded is not null) or (new.cost is not null))
then
set new.minutePrice=if(new.cost is not null,new.cost,old.cost)+(if(new.cost is not null,new.cost,old.cost)*if(new.valueAdded is not null,new.valueAdded,old.valueAdded));
end if;

set new.updaterUser=getDbUserName();
set new.updatedDate=now();
end //
delimiter ;