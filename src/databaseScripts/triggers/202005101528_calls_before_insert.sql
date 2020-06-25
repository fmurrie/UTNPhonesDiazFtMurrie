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
declare vIdOriginCity int;
declare vIdDestinyCity int;


if exists(
            select
            1
            from phoneLines
            where
            (idPhoneLine=new.idPhoneLineOrigin or  idPhoneLine=new.idPhoneLineDestiny)
            and
            (suspended=true or deleted=true)
            )
then
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invalid data of the call';
end if;


set vIdOriginCity=getIdCityForIdPhoneLine(new.idPhoneLineOrigin);
set vIdDestinyCity=getIdCityForIdPhoneLine(new.idPhoneLineDestiny);

select
minutePrice,cost
into
vMinutePrice,vCost
from rates
where
idOriginCity=vIdOriginCity and
idDestinyCity=vIdDestinyCity;

set new.idCallType=(
                    select
                    case
                        when ipv1.idCity=ipv2.idCity
                        then 1
                        when ipv1.idProvince=ipv2.idProvince
                        then 2
                        when ipv1.idCountry=ipv2.idCountry
                        then 3
                        else 4
                        end as idCallType
                    from
                        (select * from idsPlacesView where idCity=vIdOriginCity) as ipv1
                    inner join
                        (select * from idsPlacesView where idCity=vIdDestinyCity) as ipv2);

set new.durationSeconds=getSecondsBetweenTwoDateTimes(new.initTime,new.endTime);
set new.totalPrice=vMinutePrice*convertSecondsInMinutes(new.durationSeconds);
set new.creatorUser=getDbUserName();

end //
delimiter ;