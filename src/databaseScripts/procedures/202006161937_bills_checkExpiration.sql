/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 16/06/2020
 *  Description: Procedure that verify if the bill have been paid or not at the 15 day of the month
 */

use utnphones;

drop procedure if exists bills_checkExpiration;
delimiter //
create procedure bills_checkExpiration
(
)
begin

set autocommit=0;
start transaction;

update bills
set
expired=true
where
billMonth=getYearMonth() and
idBillState in(1,2);

commit;

end //
delimiter ;