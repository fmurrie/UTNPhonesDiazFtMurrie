/*Template for create a StoredProcedure object for MySQL*/

use 'Name of Database';

drop procedure if exists 'Name of the StoredProcedure';

create procedure if not exists 'Name of the StoredProcedure'(in 'parameter_example_1' int,
inout 'parameter_example_2' varchar(50),
out 'parameter_example_3' int)
begin

/*Body of the StoredProcedure*/

end;