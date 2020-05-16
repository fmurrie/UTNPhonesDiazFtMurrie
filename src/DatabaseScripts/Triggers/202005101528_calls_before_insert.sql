/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 10/05/2020
 * 	Description: create of trigger for the table calls
*/

use utnphones;

drop trigger if exists calls_before_insert;
delimiter //
create trigger if not exists calls_before_insert
before insert on calls
for each row
begin

declare vMinutePrice float;

call rates_insertAndGetPrice(getIdCityForIdPhoneLine(new.idPhoneLineOrigin),getIdCityForIdPhoneLine(new.idPhoneLineDestiny),vMinutePrice);

set new.durationSeconds=getSecondsBetweenTwoDateTimes(new.initTime,new.endTime);
set new.totalPrice=vMinutePrice*convertSecondsInMinutes(new.durationSeconds);
set new.creatorUser=getDbUserName();

end //
delimiter ;