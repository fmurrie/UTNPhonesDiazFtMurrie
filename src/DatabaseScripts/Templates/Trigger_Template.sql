/*Template for create a Trigger object for MySQL*/

/*
 * 	Author: firstname and lastname
 * 	Created Date: dd/mm/yyyy
 *  Description:
 */

use utnphones;

drop trigger if exists 'Name of the Trigger';
delimiter //
create trigger if not exists 'Name of the Trigger' 'time(after or before)' 'action(insert, update or delete)' on 'Name of the Table'
begin

/*Body of the trigger*/

end //
delimiter ;