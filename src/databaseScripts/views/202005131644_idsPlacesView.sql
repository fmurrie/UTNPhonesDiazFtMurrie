/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 13/05/2020
 *  Description:
 */

use utnphones;

drop view if exists idsPlacesView;

create view idsPlacesView
as

select
c.idCity as idCity,
p.idProvince as idProvince,
co.idCountry as idCountry
from cities c
inner join provinces p on p.idProvince=c.idProvince
inner join countries co on co.idCountry=p.idCountry;