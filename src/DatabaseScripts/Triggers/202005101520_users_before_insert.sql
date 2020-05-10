/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 10/05/2020
 * 	Description: create of trigger for the table users
*/

use utnphones;

drop trigger if exists users_before_insert;
delimiter //
create trigger if not exists users_before_insert
before insert on users
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;
