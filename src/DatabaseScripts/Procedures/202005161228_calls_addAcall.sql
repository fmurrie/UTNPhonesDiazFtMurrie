/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 16/05/2020
 *  Description: Stored procedure for add a call
 */

use utnphones;

drop procedure if exists calls_addAcall;
delimiter //
create procedure calls_addAcall
(
out pIdCall int,
in pPhoneNumberIssuer varchar(100),
in pPhoneNumberReceiver varchar(100),
in pInitTime datetime,
in pEndTime datetime
)
begin

declare vIdPhoneLineIssuer int;
declare vIdPhoneLineReceiver int;

start transaction;

set vIdPhoneLineIssuer=(select idPhoneLine from phoneLines where phoneNumber=pPhoneNumberIssuer);
set vIdPhoneLineReceiver=(select idPhoneLine from phoneLines where phoneNumber=pPhoneNumberReceiver);

if((vIdPhoneLineIssuer is not null) and (vIdPhoneLineReceiver is not null))
then

insert into calls (idPhoneLineOrigin,idPhoneLineDestiny,initTime,endTime) values (vIdPhoneLineIssuer,vIdPhoneLineReceiver,pInitTime,pEndTime);
set pIdCall=last_insert_id();

elseif((vIdPhoneLineIssuer is null) and (vIdPhoneLineReceiver is null))
then
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'You can not add the call because the phone number issuer and the phone number receiver not exist';

elseif(vIdPhoneLineIssuer is null)
then

SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'You can not add the call because the phone number issuer not exists';

elseif(vIdPhoneLineReceiver is null)
then

SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'You can not add the call because the phone number receiver not exists';

end if;

commit;

end //
delimiter ;