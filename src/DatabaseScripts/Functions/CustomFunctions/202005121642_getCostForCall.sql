/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 12/05/2020
 *  Description: A function that returns the cost of rate for a call
 */

use utnphones;

drop function if exists getCostForCall;
delimiter //
create function getCostForCall
(
idPhoneLineOrigin int,
idPhoneLineDestinity int
)
returns float
not deterministic
begin
  declare cost float;
  declare idOriginCity int;
  declare idDestinityCity int;

  set idOriginCity=getIdCityForIdPhoneLine(idPhoneLineOrigin);
  set idDestinityCity=getIdCityForIdPhoneLine(idPhoneLineDestinity);

  set cost= getRatePrice(idOriginCity,idDestinityCity);

return cost;
end //
delimiter ;