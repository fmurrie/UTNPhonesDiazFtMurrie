/*Template for create a View object for MySQL*/

/*
 * 	Author: firstname and lastname
 * 	Created Date: dd/mm/yyyy
 *  Description:
 */

use utnphones;

drop user if exists 'username'@'host';
delimiter //
create user if not exists 'username'@'host' identified by 'password';
grant 'permissions' on utnphones.'Name of the table' to 'username'@'host';
flush privileges;
delimiter ;

/*Types of permissions*/
all privileges
create
drop
delete
insert
select
update
grant option