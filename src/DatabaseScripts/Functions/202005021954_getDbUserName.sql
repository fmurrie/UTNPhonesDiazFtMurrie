/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 *  Description: Function that returns the name of
 * 	the current user in the database
 */

use utnphones;

drop function if exists getDbUserName;

create function getDbUserName
(
)
returns varchar(100)
not deterministic
begin
  declare dbUserName varchar(100);

  set dbUserName=(SELECT LEFT(CURRENT_USER(), INSTR(CURRENT_USER(), '@') - 1));

  return dbUserName;
end;