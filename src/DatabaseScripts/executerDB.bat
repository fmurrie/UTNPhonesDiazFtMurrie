echo off
cls
echo Hi Dear! You will start the implementation of the scripts for the database utnphones.
pause
SET PROJECT_PATH=%cd%
cd\
echo on

REM Section for execute the scripts from \General:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\General\000000000000_utnphones.sql

REM Section for execute the scripts from \Functions\NativeFunctions:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Functions\NativeFunctions\202005021954_getDbUserName.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Functions\NativeFunctions\202005030129_getDateIn15Days.sql

REM Section for execute the scripts from \Tables:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005022156_userTypes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005022216_interAreaCodes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005022227_countryAreaCodes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005022237_localAreaCodes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005022256_countries.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005022325_billStates.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005022326_callTypes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005022338_lineTypes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005022344_provinces.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005022354_cities.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005030020_users.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005030047_phoneLines.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005030139_bills.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005031124_rates.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005031155_calls.sql

REM Section for execute the scripts from \Procedures:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Procedures\202005091943_users_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Procedures\202005091945_users_delete.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Procedures\202005091952_users_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Procedures\202005092319_phoneLines_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Procedures\202005092335_phoneLines_delete.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Procedures\202005092340_phoneLines_update.sql

REM Section for execute the scripts from \Migration:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Migration\202005061800_migration_userTypes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Migration\202005061802_migration_billStates.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Migration\202005061803_migration_lineTypes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Migration\202005061821_migration_interAreaCodes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Migration\202005062121_migration_countryAreaCodes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Migration\202005070005_migration_countries.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Migration\202005071538_migration_provinces.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Migration\202005071547_migration_localAreaCodes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Migration\202005071548_migration_cities.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Migration\202005100006_migration_callTypes.sql

REM End-status of the implementation of the database utnphones:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\General\999999999999_endstatus.sql

PAUSE
exit