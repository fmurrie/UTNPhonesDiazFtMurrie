/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 12/05/2020
 *  Description: A view of phoneLines and their cities
 */

use utnphones;

drop view if exists phoneLinesCitiesView;

create view phoneLinesCitiesView
as

select
ph.idPhoneLine,
u.idCity
from
users u
inner join phoneLines ph on ph.idUser=u.idUser;