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
pIdOriginCity int,
pIdDestinyCity int
)
returns float
not deterministic
begin
  declare vPrice float;

  set vPrice=(
			  select
				minutePrice
			  from rates
			  where
				idOriginCity=pIdOriginCity
			  and
				idDestinyCity=pIdDestinyCity
			);

  return vPrice;
end //
delimiter ;