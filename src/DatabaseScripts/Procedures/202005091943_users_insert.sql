/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 09/05/2020
 *  Description: SP that inserts an user
 */

use utnphones;

drop procedure if exists users_insert;
delimiter //
create procedure users_insert
(
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

insert into users(idUserType,dni,firstName,lastName,idCity,username,userpassword)
values
(pIdUserType,pDni,pFirstName,pLastName,pIdCity,pUsername,pUserpassword);

commit;

end //
delimiter ;