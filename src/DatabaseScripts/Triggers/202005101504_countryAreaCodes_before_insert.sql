/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 10/05/2020
 * 	Description: create of trigger for the table countryAreaCodes
*/

use utnphones;

drop trigger if exists countryAreaCodes_before_insert;
delimiter //
create trigger if not exists countryAreaCodes_before_insert
before insert on countryAreaCodes
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;