/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 12/05/2020
 *  Description: A function that returns the idCity passing the idPhoneLine
 */

use utnphones;

drop function if exists getIdCityForIdPhoneLine;
delimiter //
create function getIdCityForIdPhoneLine
(
pIdPhoneLine int
)
returns int
not deterministic
begin
  declare idCity int;

  set idCity=(select idCity from phoneLinesCitiesView where idPhoneLine=pIdPhoneLine);

  return idCity;
end //
delimiter ;