/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 10/05/2020
 * 	Description: create of trigger for the table calls
*/

use utnphones;

drop trigger if exists calls_before_update;
delimiter //
create trigger if not exists calls_before_update
before update on calls
for each row
begin

if((old.durationSeconds=null)and(new.endTime!=null))
then
set new.durationSeconds=getSecondsBetweenTwoDateTimes(old.initTime,new.endTime);
set new.totalPrice=getCostForCall(new.idPhoneLineOrigin,new.idPhoneLineDestinity)*convertSecondsInMinutes(new.durationSeconds);
end if;

set new.updaterUser=getDbUserName();
set new.updatedDate=now();

end //
delimiter ;