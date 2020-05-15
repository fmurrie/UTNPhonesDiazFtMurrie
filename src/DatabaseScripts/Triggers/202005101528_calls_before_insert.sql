/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 10/05/2020
 * 	Description: create of trigger for the table calls
*/

use utnphones;

drop trigger if exists calls_before_insert;
delimiter //
create trigger calls_before_insert
before insert on calls
for each row
begin

set new.durationSeconds=getSecondsBetweenTwoDateTimes(new.initTime,new.endTime);
set new.totalPrice=getRatePrice(getIdCityForIdPhoneLine(new.idPhoneLineOrigin),getIdCityForIdPhoneLine(new.idPhoneLineDestinity))*convertSecondsInMinutes(new.durationSeconds);
set new.creatorUser=getDbUserName();

end //
delimiter ;