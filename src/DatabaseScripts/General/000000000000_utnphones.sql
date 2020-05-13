/*
 * 	Authors: Murrie Battistoni Felipe and Diaz Sergio Ricardo
 * 	Created Date: 02/05/2020
 *  Description: remove if exists and create again the database utnphones and her users privileges
 */

drop database if exists utnphones;
create database if not exists utnphones;

use utnphones;

SET NAMES 'utf8';

drop user if exists 'fmurrie@localhost';
create user if not exists 'fmurrie'@'localhost' identified by 'fmurrie';
grant all privileges on utnphones.* to 'fmurrie'@'localhost';
flush privileges;

drop user if exists 'sdiaz@localhost';
create user if not exists 'sdiaz'@'localhost' identified by 'sdiaz';
grant all privileges on utnphones.* to 'sdiaz'@'localhost';
flush privileges;