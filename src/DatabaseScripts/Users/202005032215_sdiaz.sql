/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 *  Description: create for the database user sdiaz
 */

use utnphones;

drop user if exists 'sdiaz@localhost';
delimiter //
create user if not exists 'sdiaz'@'localhost' identified by 'sdiaz';
grant all privileges on utnphones.* to 'sdiaz'@'localhost';
flush privileges;
delimiter ;