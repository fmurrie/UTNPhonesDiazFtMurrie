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

if(not exists(select 1 from rates limit 1))
then

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
		then (select minutePrice from callTypes where idCallType=1)
		when ipv1.idProvince=ipv2.idProvince
		then (select minutePrice from callTypes where idCallType=2)
		when ipv1.idCountry=ipv2.idCountry
		then (select minutePrice from callTypes where idCallType=3)
		else (select minutePrice from callTypes where idCallType=4)
	end as minutePrice

from
	(select
		c.idCity as idCity,
        c.idProvince as idProvince,
        (select p.idCountry from provinces p where p.idProvince=c.idProvince) as idCountry
	from cities c) as ipv1
inner join
	(select
		c.idCity as idCity,
		c.idProvince as idProvince,
        (select p.idCountry from provinces p where p.idProvince=c.idProvince) as idCountry
	from cities c) as ipv2;

end if;

end //
delimiter ;

/*call migration_rates();*/