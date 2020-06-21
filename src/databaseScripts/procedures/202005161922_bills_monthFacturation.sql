/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 16/05/2020
 *  Description: Procedure for create the bill of the last month for all the phonelines
 */

use utnphones;

drop procedure if exists bills_monthFacturation;
delimiter //
create procedure bills_monthFacturation
(
)
begin

declare vIdCurrentPhoneLine int;
declare vIdBillInserted int;
declare done boolean default false;
declare phoneLines_cursor cursor for select idPhoneLine from phoneLines where suspended=false and deleted=false;
declare continue handler for sqlstate '02000' set done = true;
declare exit handler for sqlexception
begin
    rollback;
end;

open phoneLines_cursor;
facturation_phoneLines: loop

FETCH phoneLines_cursor into  vIdCurrentPhoneLine;

IF `done` then leave facturation_phoneLines; end if;

set autocommit=0;
start transaction;

insert into bills (idPhoneLine) values(vIdCurrentPhoneLine);
set vIdBillInserted=last_insert_id();

update
bills b
inner join
(select 
c.idBill,
count(*) as quantity,
ifnull(sum(ct.cost*convertSecondsInMinutes(c.durationSeconds)),0) as costPrice,
ifnull(sum(c.totalPrice),0) as totalPrice 
from calls c 
inner join callTypes ct on ct.idCallType=c.idCallType 
where c.idBill=vIdBillInserted) as callsQuery
set
b.callsQuantity=callsQuery.quantity,
b.costPrice=callsQuery.costPrice,
b.totalPrice=callsQuery.totalPrice
where
b.idBill=vIdBillInserted and b.billMonth=getYearMonth();

commit;

end loop facturation_phoneLines;
close phoneLines_cursor;

end //
delimiter ;