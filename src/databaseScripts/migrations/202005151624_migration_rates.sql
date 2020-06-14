/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 07/05/2020
 *  Description: migration of data into the table rates.
*/

use utnphones;

drop procedure if exists migration_rates;
delimiter //
create procedure migration_rates
(
)
begin

declare vCitiesCount int;
declare vCounter int default 1;

declare vLocalCallMinutePrice float;
declare vLocalCallCost float;
declare vProvincialCallMinutePrice float;
declare vProvincialCallCost float;
declare vNationalCallMinutePrice float;
declare vNationalCallCost float;
declare vInternationalCallMinutePrice float;
declare vInternationalCallCost float;

if(not exists(select 1 from rates limit 1))
then

set vCitiesCount=(select count(*) from cities);

select minutePrice,cost into vLocalCallMinutePrice,vLocalCallCost from callTypes where idCallType=1;
select minutePrice,cost into vProvincialCallMinutePrice,vProvincialCallCost from callTypes where idCallType=2;
select minutePrice,cost into vNationalCallMinutePrice,vNationalCallCost from callTypes where idCallType=3;
select minutePrice,cost into vInternationalCallCost,vInternationalCallCost from callTypes where idCallType=4;

WHILE vCounter <= vCitiesCount DO

set autocommit=0;
start transaction;

insert
into rates
(
idOriginCity,
idDestinyCity,
minutePrice,
cost
)

select
	ipv1.idCity as idOriginCity,
	ipv2.idCity as idDestinyCity,
	case
		when ipv1.idCity=ipv2.idCity
		then vLocalCallMinutePrice
		when ipv1.idProvince=ipv2.idProvince
		then vProvincialCallMinutePrice
		when ipv1.idCountry=ipv2.idCountry
		then vNationalCallMinutePrice
		else vInternationalCallMinutePrice
	end as minutePrice,
    case
		when ipv1.idCity=ipv2.idCity
		then vLocalCallCost
		when ipv1.idProvince=ipv2.idProvince
		then vProvincialCallCost
		when ipv1.idCountry=ipv2.idCountry
		then vNationalCallCost
		else vInternationalCallCost
	end as cost
from
	idsPlacesView ipv1
    ,
	idsPlacesView ipv2
    where ipv1.idCity=vCounter;

commit;

set vCounter=vCounter+1;

END WHILE;

end if;

end //
delimiter ;