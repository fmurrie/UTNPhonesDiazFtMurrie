/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 16/05/2020
 *  Description: Stored procedure for register a phoneLine
 */


use utnphones;

drop procedure if exists phoneLines_registerAphoneLine;
delimiter //
create procedure phoneLines_registerAphoneLine
(
out pIdPhoneLine int,
in pLineType varchar(100),
in pPhoneNumber varchar(100),
in pUsername varchar(100)
)
begin

declare vIdLineType int;
declare vIdUser int;

start transaction;

set vIdLineType=(select idLineType from lineTypes where description=pLineType);

if(vIdLineType is not null)
then

set vIdUser=(select idUser from users where username=pUsername);

if(vIdUser is not null)
then

insert into phoneLines (idLineType,phoneNumber,idUser) values (vIdLineType,pPhoneNumber,vIdUser);
set pIdPhoneLine=last_insert_id();

else

SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'You can not register the phone line because the username not corresponds at any user';

end if;

else

SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'You can not register the phone line because the line type not exists';

end if;

commit;

end //
delimiter ;