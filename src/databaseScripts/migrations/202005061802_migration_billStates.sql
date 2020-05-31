/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 06/05/2020
 *  Description: migration of data into the table billStates.
 */

use utnphones;

drop procedure if exists migration_billStates;
delimiter //
create procedure migration_billStates
(
)
begin

if(not exists(select 1 from billStates limit 1))
then

set autocommit=0;
start transaction;

insert into billStates (description) values ("Unpaid");
insert into billStates (description) values ("Partially-paid");
insert into billStates (description) values ("Paid");

commit;

end if;

end //
delimiter ;
