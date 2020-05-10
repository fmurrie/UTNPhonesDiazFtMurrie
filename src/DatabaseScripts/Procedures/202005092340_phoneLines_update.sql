/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 09/05/2020
 *  Description: SP that updates a phoneLine
 */

use utnphones;

drop procedure if exists phoneLines_update;
delimiter //
create procedure phoneLines_update
(
in pIdPhoneLine int,
in pIdLineType int,
in pIdLocalAreaCode int,
in pPhoneNumber varchar(100),
in pIdUser int
)
begin

start transaction;

update phoneLines
set
idLineType=pIdUserType,
idLocalAreaCode=pIdLocalAreaCode,
phoneNumber=pPhoneNumber,
idUser=pIdUser
where
idPhoneLine=pIdPhoneLine;

commit;

end //
delimiter ;