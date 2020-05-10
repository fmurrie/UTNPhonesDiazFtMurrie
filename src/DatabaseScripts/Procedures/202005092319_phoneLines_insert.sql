/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 09/05/2020
 *  Description: SP that inserts a phoneLine
 */

use utnphones;

drop procedure if exists phoneLines_insert;
delimiter //
create procedure phoneLines_insert
(
in pIdLineType int,
in pIdLocalAreaCode int,
in pPhoneNumber varchar(100),
in pIdUser int
)
begin

start transaction;

insert into phoneLines(idLineType,idLocalAreaCode,phoneNumber,idUser)
values
(pIdLineType,pIdLocalAreaCode,pPhoneNumber,pIdUser);

commit;

end //
delimiter ;