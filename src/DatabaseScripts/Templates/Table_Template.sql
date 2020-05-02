/*Template for create a table object for MySQL*/

/*
 * 	Author: firstname and lastname
 * 	Created Date: dd/mm/yyyy
 *  Description:
 */

use utnphones;

drop table if exists 'Name of the table';

create table if not exists 'Name of the table'
(
	creatorUser  varchar(100) default(current_user()),
	createdDate datetime default(now()),
	updatingUser current_user() default(current_user()),
	updatedDate timestamp,
	'column_example_1' int,
	'column_example_2' varchar(50),
	'column_example_3' varchar(50)
);