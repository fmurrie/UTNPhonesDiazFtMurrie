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
declare vProvincialCallMinutePrice float;
declare vNationalCallMinutePrice float;
declare vInternationalCallMinutePrice float;

if(not exists(select 1 from rates limit 1))
then

set vCitiesCount=(select count(*) from cities);
set vLocalCallMinutePrice= (select minutePrice from callTypes where idCallType=1);
set vProvincialCallMinutePrice= (select minutePrice from callTypes where idCallType=2);
set vNationalCallMinutePrice= (select minutePrice from callTypes where idCallType=3);
set vInternationalCallMinutePrice= (select minutePrice from callTypes where idCallType=4);


WHILE vCounter <= vCitiesCount DO

set autocommit=0;
start transaction;

insert
into rates
(
idOriginCity,
idDestinyCity,
minutePrice
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
	end as minutePrice

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