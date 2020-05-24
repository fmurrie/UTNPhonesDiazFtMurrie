/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 17/05/2020
 *  Description: Procedure for get the data of the table users
 */

use utnphones;

drop procedure if exists users_get;
delimiter //
create procedure users_get
(
in pIdUser int,
in pIdUserType int,
in pDni varchar(100),
in pFirstName varchar(100),
in pLastName varchar(100),
in pIdCity int,
in pUsername varchar(100),
in pUserpassword varchar(100),
in pSuspended bit(1)
)
begin

set @sqlQuery='select
					idUser,
                    idUserType,
                    dni,
                    firstName,
                    lastName,
                    idCity,
                    username,
                    userpassword,
                    suspended ';



set @sqlQuery=concat(@sqlQuery,' from users');

/**********************************************************************************************************************************************************************************************************/
if(
(pIdUser is not null) or
(pIdUserType is not null) or
(pDni is not null) or
(pFirstName is not null) or
(pLastName is not null) or
(pIdCity is not null) or
(pUsername is not null) or
(pUserpassword is not null) or
(pSuspended is not null)
)
then
set @sqlQuery=concat(@sqlQuery,' where ');

/*---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
if(pIdUser is not null)
then
set @sqlQuery=concat(@sqlQuery,' idUser=',pIdUser);

if(
(pIdUserType is not null) or
(pDni is not null) or
(pFirstName is not null) or
(pLastName is not null) or
(pIdCity is not null) or
(pUsername is not null) or
(pUserpassword is not null) or
(pSuspended is not null)
)
then
set @sqlQuery=concat(@sqlQuery,' and');
end if;

end if;

/*---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
if(pIdUserType is not null)
then
set @sqlQuery=concat(@sqlQuery,' idUserType=',pIdUserType);

if(
(pDni is not null) or
(pFirstName is not null) or
(pLastName is not null) or
(pIdCity is not null) or
(pUsername is not null) or
(pUserpassword is not null) or
(pSuspended is not null)
)
then
set @sqlQuery=concat(@sqlQuery,' and');
end if;

end if;

/*---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
if(pDni is not null)
then
set @sqlQuery=concat(@sqlQuery,' dni="',pDni,'"');

if(
(pFirstName is not null) or
(pLastName is not null) or
(pIdCity is not null) or
(pUsername is not null) or
(pUserpassword is not null) or
(pSuspended is not null)
)
then
set @sqlQuery=concat(@sqlQuery,' and');
end if;

end if;

/*---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
if(pFirstName is not null)
then
set @sqlQuery=concat(@sqlQuery,' firstName like "%',pFirstName,'%"');

if(
(pLastName is not null) or
(pIdCity is not null) or
(pUsername is not null) or
(pUserpassword is not null) or
(pSuspended is not null)
)
then
set @sqlQuery=concat(@sqlQuery,' and');
end if;

end if;

/*---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
if(pLastName is not null)
then
set @sqlQuery=concat(@sqlQuery,' lastName like "%',pLastName,'%"');

if(
(pIdCity is not null) or
(pUsername is not null) or
(pUserpassword is not null) or
(pSuspended is not null)
)
then
set @sqlQuery=concat(@sqlQuery,' and');
end if;

end if;

/*---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
if(pIdCity is not null)
then
set @sqlQuery=concat(@sqlQuery,' idCity=',pIdCity);

if(
(pUsername is not null) or
(pUserpassword is not null) or
(pSuspended is not null)
)
then
set @sqlQuery=concat(@sqlQuery,' and');
end if;

end if;

/*---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
if(pUsername is not null)
then
set @sqlQuery=concat(@sqlQuery,' username="',pUsername,'"');

if(
(pUserpassword is not null) or
(pSuspended is not null)
)
then
set @sqlQuery=concat(@sqlQuery,' and');
end if;

end if;

/*---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
if(pUserpassword is not null)
then
set @sqlQuery=concat(@sqlQuery,' userpassword="',pUserpassword,'"');

if(
(pSuspended is not null)
)
then
set @sqlQuery=concat(@sqlQuery,' and');
end if;

end if;

/*---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
if(pSuspended is not null)
then
set @sqlQuery=concat(@sqlQuery,' suspended="',pSuspended,'"');
end if;

/**********************************************************************************************************************************************************************************************************/
end if;

set @sqlQuery=concat(@sqlQuery,';');

PREPARE queryStatment FROM @sqlQuery;
EXECUTE queryStatment;

end //
delimiter ;
