/*
 * 	Author: Diaz Sergio
 * 	Created Date: 23/06/2020
 * 	Description: creation of users for the correct use of utnphones
*/


use utnphones;

########################################CLIENT_USER############################################
CREATE USER'clientUser'@'localhost' IDENTIFIED BY 'clientPass';

grant select, update on utnphones.users to 'clientUser'@'localhost' IDENTIFIED BY 'clientPass';
grant select on utnphones.phonelines to 'clientUser'@'localhost' IDENTIFIED BY 'clientPass';
grant select on utnphones.calls to 'clientUser'@'localhost' IDENTIFIED BY 'clientPass';
grant select on utnphones.bills to 'clientUser'@'localhost' IDENTIFIED BY 'clientPass';

FLUSH privileges;

revoke select, update on utnphones.users from 'clientUser'@'localhost' IDENTIFIED BY 'clientPass';
revoke select on utnphones.phonelines from 'clientUser'@'localhost' IDENTIFIED BY 'clientPass';
revoke select on utnphones.calls from 'clientUser'@'localhost' IDENTIFIED BY 'clientPass';
revoke select on utnphones.bills from 'clientUser'@'localhost' IDENTIFIED BY 'clientPass';

SHOW grants for 'clientUser'@'localhost';

select * from mysql.`user` u ;

drop user 'clientUser'@'localhost';


########################################BACKOFFICE_USER############################################
CREATE user if not exists 'backofficeUser'@'localhost' IDENTIFIED BY 'backofficePass';

grant insert, select, update, delete on utnphones.users to 'backofficeUser'@'localhost' IDENTIFIED BY 'backofficeUser';
grant insert, select, update, delete on utnphones.phonelines to 'backofficeUser'@'localhost' IDENTIFIED BY 'backofficeUser';
grant select on utnphones.rates to 'backofficeUser'@'localhost' IDENTIFIED BY 'backofficeUser';
grant select on utnphones.calls to 'backofficeUser'@'localhost' IDENTIFIED BY 'backofficeUser';
grant select on utnphones.bills to 'backofficeUser'@'localhost' IDENTIFIED BY 'backofficeUser';

FLUSH privileges;

revoke insert, select, update, delete on utnphones.users from 'backofficeUser'@'localhost' IDENTIFIED BY 'backofficeUser';
revoke insert, select, update, delete on utnphones.phonelines from 'backofficeUser'@'localhost' IDENTIFIED BY 'backofficeUser';
revoke select on utnphones.rates from 'backofficeUser'@'localhost' IDENTIFIED BY 'backofficeUser';
revoke select on utnphones.calls from 'backofficeUser'@'localhost' IDENTIFIED BY 'backofficeUser';
revoke select on utnphones.bills from 'backofficeUser'@'localhost' IDENTIFIED BY 'backofficeUser';

SHOW grants for 'backofficeUser'@'localhost';

select * from mysql.`user` u ;

drop user 'backofficeUser'@'localhost';


########################################INFRASTRUCTURE_USER############################################
CREATE USER'infrastructureUser'@'localhost' IDENTIFIED BY 'infrastructurePass';

grant insert on utnphones.calls to 'infrastructureUser'@'localhost' IDENTIFIED BY 'infrastructurePass';

FLUSH privileges;

revoke insert on utnphones.calls from 'infrastructureUser'@'localhost';

SHOW grants for 'infrastructureUser'@'localhost';

select * from mysql.`user` u ;

drop user 'infrastructureUser'@'localhost';



