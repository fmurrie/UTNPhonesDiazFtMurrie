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

set autocommit=0;
start transaction;

insert into bills (idPhoneLine) select idPhoneLine from phoneLines;

update
bills b
inner join
(select
c.idBill as idBill,
count(*) as quantity,
sum(c.totalPrice) as totalPrice
from calls c group by c.idBill) as slcCalls
set
b.callsQuantity=slcCalls.quantity,
b.costPrice=slcCalls.totalPrice,
b.totalPrice=slcCalls.totalPrice
where
b.idBill=slcCalls.idBill and b.billMonth=getYearMonth();

commit;

end //
delimiter ;