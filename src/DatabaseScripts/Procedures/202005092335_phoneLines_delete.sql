/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 09/05/2020
 *  Description: SP that deletes a phoneLine
 */

use utnphones;

drop procedure if exists phoneLines_delete;
delimiter //
create procedure phoneLines_delete
(
in pIdPhoneLine int
)
begin

start transaction;

delete from phoneLines where idPhoneLine=pIdPhoneLine;

commit;

end //
delimiter ;