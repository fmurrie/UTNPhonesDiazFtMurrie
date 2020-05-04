/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 *  Description: create for the database user fmurrie
 */

use utnphones;

drop user if exists 'fmurrie@localhost';
delimiter //
create user if not exists 'fmurrie'@'localhost' identified by 'fmurrie';
grant all privileges on utnphones.* to 'fmurrie'@'localhost';
flush privileges;
delimiter ;