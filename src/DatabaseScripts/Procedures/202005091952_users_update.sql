/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 09/05/2020
 *  Description: SP that updates an user
 */

use utnphones;

drop procedure if exists users_update;
delimiter //
create procedure users_update
(
in pIdUser int,
in pIdUserType int,
in pDni varchar(100),
in pFirstName varchar(100),
in pLastName varchar(100),
in pIdCity int,
in pUsername varchar(100),
in pUserpassword varchar(100)
)
begin

start transaction;

update users
set
idUserType=pIdUserType,
dni=pDni,
firstName=pFirstName,
lastName=pLastName,
idCity=pIdCity,
username=pUsername,
userpassword=pUserpassword
where
idUser=pIdUser;

commit;

end //
delimiter ;