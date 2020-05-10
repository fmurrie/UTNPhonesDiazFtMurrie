/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 10/05/2020
 * 	Description: create of trigger for the table countries
*/

use utnphones;

drop trigger if exists countries_before_insert;
delimiter //
create trigger if not exists countries_before_insert
before insert on countries
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;