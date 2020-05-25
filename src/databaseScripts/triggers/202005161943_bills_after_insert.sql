/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 16/05/2020
 *  Description: create of trigger for the table bills
 */

use utnphones;

drop trigger if exists bills_after_insert;
delimiter //
create trigger if not exists bills_after_insert
after insert on bills
for each row
begin

update calls set IdBill=new.idBill where IdBill is null and idPhoneLineOrigin=new.idPhoneLine;

end //
delimiter ;