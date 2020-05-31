/*
 * 	Authors: Murrie Battistoni Felipe
 * 	Created Date: 30/05/2020
 *  Description: Event for the migration data into the tables
 */

use utnphones;

drop event if exists event_migration;
delimiter //
create event if not exists event_migration
on schedule at now() + interval 1 minute
do
begin
call migration_userTypes();
call migration_billStates();
call migration_lineTypes();
call migration_callTypes();
call migration_countries();
call migration_provinces();
call migration_cities();
call migration_rates();
end //
delimiter ;