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
pIdLocalAreaCode int,
pPhoneNumber varchar(100)
)
returns varchar(100)
not deterministic
begin
  declare completePhoneNumber varchar(100);
  set completePhoneNumber= (
							select
								concat(
										iac.code,
                                        ' ',
                                        '+',
                                        cac.code,
                                        ' (',
                                        (select
											code
										from lineTypes
                                        where idLineType=pIdLineType),
                                        ') ',
                                        lac.code,
                                        '-',
                                        pPhoneNumber) as  phoneNumber
							from interareacodes iac
							inner join countryareacodes cac
								on cac.idInterAreaCode=iac.idInterAreaCode
							inner join localAreaCodes lac
								on lac.idCountryAreaCode=cac.idCountryAreaCode
							where
								pIdLocalAreaCode=lac.idLocalAreaCode
							);

  return completePhoneNumber;
end //
delimiter ;