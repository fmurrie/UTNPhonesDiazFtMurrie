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

declare vCost float;
declare vMinutePrice float;

select
minutePrice,cost
into
vMinutePrice,vCost
from rates
where
idOriginCity=getIdCityForIdPhoneLine(new.idPhoneLineOrigin) and
idDestinyCity=getIdCityForIdPhoneLine(new.idPhoneLineDestiny);

set new.idCallType=;

select
	case
		when ipv1.idCity=ipv2.idCity
		then 1 into new.idCallType
		when ipv1.idProvince=ipv2.idProvince
		then 2 into new.idCallType
		when ipv1.idCountry=ipv2.idCountry
		then 3 into new.idCallType
		else 4 into new.idCallType
	end
from
	idsPlacesView ipv1
    ,
	idsPlacesView ipv2;

set new.durationSeconds=getSecondsBetweenTwoDateTimes(new.initTime,new.endTime);
set new.totalPrice=vMinutePrice*convertSecondsInMinutes(new.durationSeconds) + vCost;
set new.creatorUser=getDbUserName();

end //
delimiter ;