/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 12/05/2020
 *  Description: A trigger for do action after insert in the table calls
*/

use utnphones;

drop trigger if exists call_after_insert;
delimiter //
create trigger if not exists call_after_insert
after insert on calls
for each row
begin

if(new.idBill!=NULL)
then
    update bills
    set
        callsQuantity=callsQuantity+1,
        costPrice=costPrice+getRatePrice(getIdCityForIdPhoneLine(new.idPhoneLineOrigin),getIdCityForIdPhoneLine(new.idPhoneLineDestiny)),
        totalPrice=totalPrice+new.totalPrice
    where idBill=new.idBill;
end if;

end //
delimiter ;