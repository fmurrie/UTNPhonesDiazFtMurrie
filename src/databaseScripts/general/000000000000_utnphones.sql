/*
 * 	Authors: Murrie Battistoni Felipe and Diaz Sergio Ricardo
 * 	Created Date: 02/05/2020
 *  Description: create the database utnphones if not exists and her users privileges
 */

create database if not exists utnphones;

use utnphones;

SET NAMES utf8;
SET GLOBAL time_zone = '-3:00';
SET GLOBAL event_scheduler=ON;

create user if not exists 'fmurrie'@'localhost' identified by 'fmurrie';
grant all privileges on utnphones.* to 'fmurrie'@'localhost';
flush privileges;

create user if not exists 'sdiaz'@'localhost' identified by 'sdiaz';
grant all privileges on utnphones.* to 'sdiaz'@'localhost';
flush privileges;