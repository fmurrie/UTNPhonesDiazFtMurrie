/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 06/05/2020
 *  Description: migration of data into the table interAreaCodes.
 */

 use utnphones;

drop procedure if exists migration_interAreaCodes;
delimiter //
create procedure migration_interAreaCodes
(
)
begin

if(not exists(select 1 from interAreaCodes limit 1))
then

insert into interAreaCodes (code) values ("00");

end if;

end //
delimiter ;

call migration_interAreaCodes();
