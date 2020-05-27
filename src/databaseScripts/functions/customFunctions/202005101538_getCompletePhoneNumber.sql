/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 10/05/2020
 *  Description: Function that returns a complete phonenumber with the area codes included.
 */

use utnphones;

drop function if exists getCompletePhoneNumber;
delimiter //
create function getCompletePhoneNumber
(
pIdLineType int,
pIdCity int,
pPhoneNumber varchar(100)
)
returns varchar(100)
not deterministic
begin
  declare vCompletePhoneNumber varchar(100);
  set vCompletePhoneNumber= (
							select
								concat(
                                        '+',
                                        countryAreaCode,
                                        ' (',
                                        (select
											code
										from lineTypes
                                        where idLineType=pIdLineType),
                                        ') ',
                                        cityAreaCode,
                                        '-',
                                        pPhoneNumber) as  phoneNumber
							from areaCodesView
							where
								idCity=pIdCity
							);

  return vCompletePhoneNumber;
end //
delimiter ;