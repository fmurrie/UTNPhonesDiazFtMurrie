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
	creatorUser varchar(100),
	createdDate datetime default(now()),
	updaterUser varchar(100),
	updatedDate timestamp,
	'column_example_1' int,
	'column_example_2' varchar(50),
	'column_example_3' varchar(50)
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists 'Name of the Table'_audit_creator;
delimiter //
create trigger if not exists 'Name of the Table'_audit_creator
before insert on 'Name of the Table'
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists 'Name of the Table'_audit_updater;
delimiter //
create trigger if not exists 'Name of the Table'_audit_updater
before update on 'Name of the Table'
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;