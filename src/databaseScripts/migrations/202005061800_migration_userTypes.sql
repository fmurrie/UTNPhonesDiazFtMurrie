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

set autocommit=0;
start transaction;

insert into userTypes (description) values ("Client");
insert into userTypes (description) values ("Employee");

commit;

end if;

end //
delimiter ;