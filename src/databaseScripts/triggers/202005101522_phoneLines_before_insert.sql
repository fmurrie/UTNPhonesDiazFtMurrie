/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 10/05/2020
 * 	Description: create of trigger for the table phoneLines
*/

use utnphones;

drop trigger if exists phoneLines_before_insert;
delimiter //
create trigger if not exists phoneLines_before_insert
before insert on phoneLines
for each row
begin
set new.phoneNumber=getCompletePhoneNumber(new.idLineType,(select idCity from users where idUser=new.idUser),new.phoneNumber);
set new.creatorUser=getDbUserName();
end //
delimiter ;