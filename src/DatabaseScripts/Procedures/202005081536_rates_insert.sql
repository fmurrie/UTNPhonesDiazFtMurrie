/*
 * 	Author: Murrie Battisoni Felipe
 * 	Created Date: 08/05/2020
 *  Description: procedure for insert a rate
 */

use utnphones;

drop procedure if exists rates_insert;
delimiter //
create procedure rates_insert
(
in pIdOriginCity int,
in pIdDestinyCity int
)
begin

declare vMinutePrice float;

if(not exists(select 1 from rates where idOriginCity=pIdOriginCity and idDestinyCity=pIdDestinyCity))
then

set vMinutePrice=(select minutePrice from callTypes where idCallType=getIdCallTypeBetweenCities(pIdOriginCity,pIdDestinyCity));

insert into rates (idOriginCity,idDestinyCity,minutePrice) values (pIdOriginCity,pIdDestinyCity,vMinutePrice);

end if;

end //
delimiter ;