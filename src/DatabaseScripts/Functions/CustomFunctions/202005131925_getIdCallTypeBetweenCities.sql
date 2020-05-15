/*
 * 	Author: Murrie Battisoni Felipe
 * 	Created Date: 13/05/2020
 *  Description: A function that determinates the callType between two cities
 */

use utnphones;

drop function if exists getIdCallTypeBetweenCities;
delimiter //
create function getIdCallTypeBetweenCities
(
pIdOriginCity int,
pIdDestinityCity int
)
returns int
not deterministic
begin
  declare vIdCallType int;

  set vIdCallType=
  (
  select
  case
  when ipv1.idCity=ipv2.idCity
  then 1
  when ipv1.idProvince=ipv2.idProvince
  then 2
  when ipv1.idCountry=ipv2.idCountry
  then 3
  else 4
  end as idCallType
  from
  (select idCity,idProvince,idCountry from idsPlacesView where idCity=pIdOriginCity) ipv1
  inner join
  (select idCity,idProvince,idCountry from idsPlacesView where idCity=pIdDestinityCity) ipv2
  );

  return vIdCallType;
end //
delimiter ;