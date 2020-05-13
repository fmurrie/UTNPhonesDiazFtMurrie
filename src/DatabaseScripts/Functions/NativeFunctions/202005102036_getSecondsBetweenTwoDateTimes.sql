/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 10/05/2020
 *  Description: A function that returns the difference in seconds between two datetimes.
 */

use utnphones;

drop function if exists getSecondsBetweenTwoDateTimes;
delimiter //
create function getSecondsBetweenTwoDateTimes
(
pInitDate datetime,
pEndDate datetime
)
returns float
not deterministic
begin
  declare seconds float;

  set seconds=(select TIMESTAMPDIFF(SECOND,pInitDate,pEndDate));

  return seconds;
end //
delimiter ;