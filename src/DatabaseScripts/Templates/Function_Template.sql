/*Template for create a Function object for MySQL*/

/*
 * 	Author: firstname and lastname
 * 	Created Date: dd/mm/yyyy
 *  Description:
 */

use utnphones;

drop function if exists 'Name of the Function';
delimiter //
create function 'Name of the Function'
(
'paramExample1' int,
'paramExample2' varchar(100)
)
returns 'dataTypeReturn'
not deterministic or deterministic
begin
  declare variable 'dataTypeReturn' DEFAULT "";

  /*Body of the Function*/

  return variable;
end //
delimiter ;