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
pSeconds int
)
returns float
not deterministic
begin
  declare minutes float;

    set minutes=pSeconds/60;

  return minutes;
end //
delimiter ;