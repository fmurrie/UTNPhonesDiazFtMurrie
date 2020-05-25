/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 03/05/2020
 *  Description: function that retrieves a date from 15 days before of the actual date
 */

use utnphones;

drop function if exists getDateIn15Days;
delimiter //
create function getDateIn15Days
(
)
returns datetime
not deterministic
begin
  declare vDateIn15Days datetime;

  set vDateIn15Days=(SELECT DATE_ADD(now(), INTERVAL 15 DAY));

  return vDateIn15Days;
end //
delimiter ;