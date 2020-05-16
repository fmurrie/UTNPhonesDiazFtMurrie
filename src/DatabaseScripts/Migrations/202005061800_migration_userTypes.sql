/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 06/05/2020
 *  Description: migration of data into the table userTypes.
 */

 use utnphones;

drop procedure if exists migration_userTypes;
delimiter //
create procedure migration_userTypes
(
)
begin

if(not exists(select 1 from userTypes limit 1))
then
insert into userTypes (description) values ("Client");
insert into userTypes (description) values ("Employee");
end if;

end //
delimiter ;

call migration_userTypes();