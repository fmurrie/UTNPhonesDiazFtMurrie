/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 10/05/2020
 *  Description: A view that returns the code areas in relation.
 */

use utnphones;

drop view if exists areaCodesView;

create view areaCodesView
as

select
co.areaCode as countryAreaCode,
ci.areaCode as cityAreaCode,
co.idCountry,
pr.idProvince,
ci.idCity
from
cities ci
inner join provinces pr
    on pr.idProvince=ci.idProvince
inner join countries co
    on co.idCountry=pr.idCountry;
