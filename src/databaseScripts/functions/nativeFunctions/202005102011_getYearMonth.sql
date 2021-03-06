/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 10/05/2020
 *  Description: function that returns the unique identifier of a month in a year.
 */

use utnphones;

drop function if exists getYearMonth;
delimiter //
create function getYearMonth
(
)
returns varchar(100)
not deterministic
begin
  declare vYearMonth varchar(100);

  set vYearMonth=(select extract(year_month from now()));

  return vYearMonth;
end //
delimiter ;