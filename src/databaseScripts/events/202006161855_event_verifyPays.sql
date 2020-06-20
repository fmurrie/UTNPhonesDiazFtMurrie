/*
* 	Authors: Murrie Battistoni Felipe
* 	Created Date: 16/06/2020
*  Description: Event for verify if the bills have been paid or expired
*/

use utnphones;

drop event if exists event_verifyPays;
delimiter //
create event if not exists event_verifyPays
on schedule every 1 month starts date_format(date_add(subdate(now(), dayofmonth(now()) - 15), interval 1 month),'%Y-%m-%d 00:00:00')
on completion preserve
do
begin
call bills_checkExpiration();
end //
delimiter ;