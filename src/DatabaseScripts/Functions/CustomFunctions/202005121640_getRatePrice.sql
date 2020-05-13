/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 12/05/2020
 *  Description: A function that returns the price of the rate for the call between two cities
 */

use utnphones;

drop function if exists getRatePrice;
delimiter //
create function getRatePrice
(
pIdCityOrigin int,
pIdCityDestinity int
)
returns float
not deterministic
begin
  declare price float;

  set price=(
			  select
				minutePrice
			  from rates
			  where
				idCityOrigin=pIdCityOrigin
			  and
				idCityDestinity=pIdCityDestinity
			);

  return price;
end //
delimiter ;