/*
 * 	Authors: Murrie Battistoni Felipe
 * 	Created Date: 17/05/2020
 *  Description: Event for the facturation of all calls the first day of the month
 */

use utnphones;

drop event if exists event_facturation;
delimiter //
create event if not exists event_facturation
on schedule every 1 month starts date_format(date_add(subdate(now(), dayofmonth(now()) - 1), interval 1 month),'%Y-%m-%d 00:00:00')
on completion preserve
do
begin
call bills_monthFacturation();
end //
delimiter ;
