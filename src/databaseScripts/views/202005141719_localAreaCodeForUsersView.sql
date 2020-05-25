/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 14/05/2020
 *  Description: A view for see the local code areas by user
 */

use utnphones;

drop view if exists localAreaCodeForUsersView;

create view localAreaCodeForUsersView
as

select
u.idUser,
c.idCity,
c.idLocalAreaCode
from users u
inner join cities c on c.idCity=u.idCity;