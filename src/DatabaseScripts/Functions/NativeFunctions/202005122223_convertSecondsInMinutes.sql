/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 12/05/2020
 *  Description: Function for convert seconds in minutes
 */

use utnphones;

drop function if exists convertSecondsInMinutes;
delimiter //
create function convertSecondsInMinutes
(
pSeconds float
)
returns float
not deterministic
begin
  declare vMinutes float;

    set vMinutes=pSeconds/60;

  return vMinutes;
end //
delimiter ;