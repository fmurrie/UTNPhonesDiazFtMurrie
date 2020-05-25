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

INSERT INTO provinces (name,idCountry) VALUES ('Buenos aires', 11);
INSERT INTO provinces (name,idCountry) VALUES ('Catamarca', 11);
INSERT INTO provinces (name,idCountry) VALUES ('Chaco', 11);
INSERT INTO provinces (name,idCountry) VALUES ('Chubut', 11);
INSERT INTO provinces (name,idCountry) VALUES ('Cordoba', 11);
INSERT INTO provinces (name,idCountry) VALUES ('Corrientes', 11);
INSERT INTO provinces (name,idCountry) VALUES ('Entre rios', 11);
INSERT INTO provinces (name,idCountry) VALUES ('Formosa', 11);
INSERT INTO provinces (name,idCountry) VALUES ('Jujuy', 11);
INSERT INTO provinces (name,idCountry) VALUES ('La pampa', 11);
INSERT INTO provinces (name,idCountry) VALUES ('La rioja', 11);
INSERT INTO provinces (name,idCountry) VALUES ('Mendoza', 11);
INSERT INTO provinces (name,idCountry) VALUES ('Misiones', 11);
INSERT INTO provinces (name,idCountry) VALUES ('Neuquen', 11);
INSERT INTO provinces (name,idCountry) VALUES ('Rio negro', 11);
INSERT INTO provinces (name,idCountry) VALUES ('Salta', 11);
INSERT INTO provinces (name,idCountry) VALUES ('San juan', 11);
INSERT INTO provinces (name,idCountry) VALUES ('San luis', 11);
INSERT INTO provinces (name,idCountry) VALUES ('Santa cruz', 11);
INSERT INTO provinces (name,idCountry) VALUES ('Santa fe', 11);
INSERT INTO provinces (name,idCountry) VALUES ('Santiago del estero', 11);
INSERT INTO provinces (name,idCountry) VALUES ('Tierra del fuego', 11);
INSERT INTO provinces (name,idCountry) VALUES ('Tucuman', 11);

end if;

end //
delimiter ;

call migration_provinces();


