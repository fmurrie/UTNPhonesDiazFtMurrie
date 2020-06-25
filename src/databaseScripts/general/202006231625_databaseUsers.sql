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

########################################BACKOFFICE_USER############################################
CREATE user if not exists 'backofficeUser'@'localhost' IDENTIFIED BY 'backofficePass';

grant insert, select, update, delete on utnphones.users to 'backofficeUser'@'localhost' IDENTIFIED BY 'backofficeUser';
grant insert, select, update, delete on utnphones.phonelines to 'backofficeUser'@'localhost' IDENTIFIED BY 'backofficeUser';
grant select on utnphones.rates to 'backofficeUser'@'localhost' IDENTIFIED BY 'backofficeUser';
grant select on utnphones.calls to 'backofficeUser'@'localhost' IDENTIFIED BY 'backofficeUser';
grant select on utnphones.bills to 'backofficeUser'@'localhost' IDENTIFIED BY 'backofficeUser';

FLUSH privileges;

########################################INFRASTRUCTURE_USER############################################
CREATE USER'infrastructureUser'@'localhost' IDENTIFIED BY 'infrastructurePass';

grant insert on utnphones.calls to 'infrastructureUser'@'localhost' IDENTIFIED BY 'infrastructurePass';

FLUSH privileges;



