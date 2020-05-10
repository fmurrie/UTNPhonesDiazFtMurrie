/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 10/05/2020
 * 	Description: create of trigger for the table cities
*/

use utnphones;

drop trigger if exists cities_before_insert;
delimiter //
create trigger if not exists cities_before_insert
before insert on cities
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;