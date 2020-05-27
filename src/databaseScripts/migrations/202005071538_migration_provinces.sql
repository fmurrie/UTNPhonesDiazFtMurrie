/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 07/05/2020
 *  Description: migration of data into the table provinces.
*/

use utnphones;

drop procedure if exists migration_provinces;
delimiter //
create procedure migration_provinces
(
)
begin

if(not exists(select 1 from provinces limit 1))
then

INSERT INTO provinces (name,idCountry) VALUES ('Buenos aires',10);
INSERT INTO provinces (name,idCountry) VALUES ('Catamarca',10);
INSERT INTO provinces (name,idCountry) VALUES ('Chaco',10);
INSERT INTO provinces (name,idCountry) VALUES ('Chubut',10);
INSERT INTO provinces (name,idCountry) VALUES ('Cordoba',10);
INSERT INTO provinces (name,idCountry) VALUES ('Corrientes',10);
INSERT INTO provinces (name,idCountry) VALUES ('Entre Rios',10);
INSERT INTO provinces (name,idCountry) VALUES ('Formosa',10);
INSERT INTO provinces (name,idCountry) VALUES ('Jujuy',10);
INSERT INTO provinces (name,idCountry) VALUES ('La Pampa',10);
INSERT INTO provinces (name,idCountry) VALUES ('La Rioja',10);
INSERT INTO provinces (name,idCountry) VALUES ('Mendoza',10);
INSERT INTO provinces (name,idCountry) VALUES ('Misiones',10);
INSERT INTO provinces (name,idCountry) VALUES ('Neuquen',10);
INSERT INTO provinces (name,idCountry) VALUES ('Rio Negro',10);
INSERT INTO provinces (name,idCountry) VALUES ('Salta',10);
INSERT INTO provinces (name,idCountry) VALUES ('San Juan',10);
INSERT INTO provinces (name,idCountry) VALUES ('San Luis',10);
INSERT INTO provinces (name,idCountry) VALUES ('Santa Cruz',10);
INSERT INTO provinces (name,idCountry) VALUES ('Santa Fe',10);
INSERT INTO provinces (name,idCountry) VALUES ('Santiago del Estero',10);
INSERT INTO provinces (name,idCountry) VALUES ('Tierra del Fuego',10);
INSERT INTO provinces (name,idCountry) VALUES ('Tucuman',10);

end if;

end //
delimiter ;

call migration_provinces();


