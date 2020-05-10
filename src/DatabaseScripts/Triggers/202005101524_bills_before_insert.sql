/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 10/05/2020
 * 	Description: create of trigger for the table bills
*/

use utnphones;

drop trigger if exists bills_before_insert;
delimiter //
create trigger if not exists bills_before_insert
before insert on bills
for each row
begin
set new.expiryDate=getDateIn15Days();
set new.creatorUser=getDbUserName();
end //
delimiter ;
