/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 12/05/2020
 *  Description: A trigger for do action after update in the table calls
*/

use utnphones;

drop trigger if exists call_after_update;
delimiter //
create trigger call_after_update
after update on calls
for each row
begin

if(new.idBill!=NULL)
then
    update bills
    set
        callsQuantity=callsQuantity+1,
        costPrice=costPrice+getCostForCall(old.idPhoneLineOrigin,old.idPhoneLineDestinity),
        totalPrice=totalPrice+old.totalPrice
    where idBill=new.idBill;
end if;

end //
delimiter ;