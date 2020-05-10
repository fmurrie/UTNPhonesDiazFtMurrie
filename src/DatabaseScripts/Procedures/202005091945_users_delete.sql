/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 09/05/2020
 *  Description: SP that deletes an user
 */

use utnphones;

drop procedure if exists users_delete;
delimiter //
create procedure users_delete
(
in pIdUser int
)
begin

delete from users where idUser=pIdUser;

end //
delimiter ;