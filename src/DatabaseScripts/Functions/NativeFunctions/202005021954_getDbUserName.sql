/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 *  Description: Function that returns the name of
 * 	the current user in the database
 */

use utnphones;

drop function if exists getDbUserName;
delimiter //
create function getDbUserName
(
)
returns varchar(100)
not deterministic
begin
  declare vDbUserName varchar(100);

  set vDbUserName=(SELECT LEFT(CURRENT_USER(), INSTR(CURRENT_USER(), '@') - 1));

  return vDbUserName;
end //
delimiter ;