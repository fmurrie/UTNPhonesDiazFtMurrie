/*
 * 	Author: Murrie Battisoni Felipe
 * 	Created Date: 08/05/2020
 *  Description: procedure for try insert a rate and get the price
 */

use utnphones;

drop procedure if exists rates_insertAndGetPrice;
delimiter //
create procedure rates_insertAndGetPrice
(
in pIdOriginCity int,
in pIdDestinyCity int,
inout pMinutePrice float
)
begin

set pMinutePrice=(select minutePrice from rates where idOriginCity=1 and idDestinyCity=2);

if(pMinutePrice is null)
then

set pMinutePrice=(select minutePrice from callTypes where idCallType=getIdCallTypeBetweenCities(pIdOriginCity,pIdDestinyCity));
insert into rates (idOriginCity,idDestinyCity,minutePrice) values (pIdOriginCity,pIdDestinyCity,pMinutePrice);

end if;

end //
delimiter ;