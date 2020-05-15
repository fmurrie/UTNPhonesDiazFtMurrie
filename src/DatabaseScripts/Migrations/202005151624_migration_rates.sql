/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 07/05/2020
 *  Description: migration of data into the table rates.
*/

use utnphones;

insert
into rates
(
idOriginCity,
idDestinityCity,
minutePrice
)

select

	ipv1.idCity as idOriginCity,
	ipv2.idCity as idDestinityCity,
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