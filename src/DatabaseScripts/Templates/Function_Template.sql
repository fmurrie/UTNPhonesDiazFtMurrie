/*Template for create a Function object for MySQL*/

/*
 * 	Author: firstname and lastname
 * 	Created Date: dd/mm/yyyy
 *  Description:
 */

use utnphones;

drop function if exists 'Name of the Function';

create 'Name of the Function'
(
'paramExample1' int,
'paramExample2' varchar(100)
)
not deterministic or deterministic
returns 'dataTypeReturn'
begin
  declare variable 'dataTypeReturn' DEFAULT "";

  /*Actions and variables that you need*/

  return variable;
end;