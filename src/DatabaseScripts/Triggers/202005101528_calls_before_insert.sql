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

declare vIdOriginCity int;
declare vIdDestinityCity int;

set vIdOriginCity=getIdCityForIdPhoneLine(new.idPhoneLineOrigin);
set vIdDestinityCity=getIdCityForIdPhoneLine(new.idPhoneLineDestinity);

call rates_insert(vIdOriginCity,vIdDestinityCity);

set new.durationSeconds=getSecondsBetweenTwoDateTimes(new.initTime,new.endTime);
set new.totalPrice=getRatePrice(vIdOriginCity,vIdDestinityCity)*convertSecondsInMinutes(new.durationSeconds);

set new.creatorUser=getDbUserName();

end //
delimiter ;