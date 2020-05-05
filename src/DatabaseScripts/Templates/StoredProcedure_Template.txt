/*Template for create a StoredProcedure object for MySQL*/

/*
 * 	Author: firstname and lastname
 * 	Created Date: dd/mm/yyyy
 *  Description:
 */

use utnphones;

drop procedure if exists 'Name of the StoredProcedure';
delimiter //
create procedure if not exists 'Name of the StoredProcedure'
(
in 'parameter_example_1' int,
inout 'parameter_example_2' varchar(50),
out 'parameter_example_3' int
)
begin

/*Body of the StoredProcedure*/

end //
delimiter ;