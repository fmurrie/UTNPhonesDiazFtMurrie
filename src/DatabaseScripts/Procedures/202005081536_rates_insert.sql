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
in pIdDestinityCity int
)
begin

declare vMinutePrice float;

if(not exists(select 1 from rates where idOriginCity=pIdOriginCity and idDestinityCity=pIdDestinityCity))
then

set vMinutePrice=(select minutePrice from callTypes where idCallType=getIdCallTypeBetweenCities(pIdOriginCity,pIdDestinityCity));

insert into rates (idOriginCity,idDestinityCity,minutePrice) values (pIdOriginCity,pIdDestinityCity,vMinutePrice);

end if;

end //
delimiter ;