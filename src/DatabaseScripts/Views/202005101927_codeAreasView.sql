/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 10/05/2020
 *  Description: A view that returns the code areas in relation.
 */

use utnphones;

drop view if exists codeAreasView;

create view codeAreasView
as

select
iac.idInterAreaCode as idInterAreaCode,
iac.code as interAreaCode,
cac.idCountryAreaCode as idCountryAreaCode,
cac.code as countryAreaCode,
lac.idLocalAreaCode as idLocalAreaCode,
lac.code as localAreaCode
from interareacodes iac
inner join countryareacodes cac
on cac.idInterAreaCode=iac.idInterAreaCode
inner join localAreaCodes lac
on lac.idCountryAreaCode=cac.idCountryAreaCode;
