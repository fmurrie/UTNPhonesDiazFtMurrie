/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 10/05/2020
 * 	Description: create of trigger for the table userTypes
*/

use utnphones;

drop trigger if exists userTypes_before_insert;
delimiter //
create trigger if not exists userTypes_before_insert
before insert on userTypes
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;