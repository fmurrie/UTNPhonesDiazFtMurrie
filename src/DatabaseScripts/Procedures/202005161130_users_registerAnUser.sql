/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 16/05/2020
 *  Description: Stored procedure for register an user
 */

use utnphones;

drop procedure if exists users_registerAnUser;
delimiter //
create procedure users_registerAnUser
(
out pIdUser int,
in pUserType varchar(100),
in pDni varchar(100),
in pFirstName varchar(100),
in pLastName varchar(100),
in pCity varchar(100),
in pUsername varchar(100),
in pUserpassword varchar(100)
)
begin

declare vIdUserType int;
declare vIdCity int;

start transaction;

set vIdUserType = (select idUserType from userTypes where description=pUserType);

if(vIdUserType is not null)
then

set vIdCity =(select idCity from cities where name=pCity);

if(vIdCity is not null)
then

insert into users (idUserType,dni,firstName,lastName,idCity,username,userpassword) values (vIdUserType,pDni,pFirstName,pLastName,vIdCity,pUsername,pUserpassword);
set pIdUser=last_insert_id();

else

SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'You can not register the user because the specific city not exists';

end if;

else

SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'You can not register the user because the user type is incorrect';

end if;

commit;

end //
delimiter ;