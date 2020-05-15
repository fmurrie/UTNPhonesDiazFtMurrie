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
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Functions\NativeFunctions\202005102011_getYearMonth.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Functions\NativeFunctions\202005102036_getSecondsBetweenTwoDateTimes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Functions\NativeFunctions\202005122223_convertSecondsInMinutes.sql

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

REM Section for execute the scripts from \Views:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Views\202005101927_codeAreasView.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Views\202005121625_phoneLinesCitiesView.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Views\202005131644_idsPlacesView.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Views\202005141719_localAreaCodeForUsersView.sql

REM Section for execute the scripts from \Functions\CustomFunctions:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Functions\CustomFunctions\202005101538_getCompletePhoneNumber.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Functions\CustomFunctions\202005121624_getIdCityForIdPhoneLine.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Functions\CustomFunctions\202005121640_getRatePrice.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Functions\CustomFunctions\202005131925_getIdCallTypeBetweenCities.sql

REM Section for execute the scripts from \Procedures:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Procedures\202005081536_rates_insert.sql

REM Section for execute the scripts from \Triggers:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101500_userTypes_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101501_userTypes_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101502_interAreaCodes_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101503_interAreaCodes_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101504_countryAreaCodes_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101505_countryAreaCodes_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101506_localAreaCodes_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101507_localAreaCodes_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101508_countries_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101509_countries_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101510_billStates_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101511_billStates_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101512_callTypes_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101513_callTypes_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101514_lineTypes_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101515_lineTypes_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101516_provinces_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101517_provinces_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101518_cities_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101519_cities_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101520_users_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101521_users_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101522_phoneLines_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101523_phoneLines_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101524_bills_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101525_bills_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101526_rates_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101527_rates_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101528_calls_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005101529_calls_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005121539_calls_after_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Triggers\202005121549_calls_after_update.sql

REM Section for execute the scripts from \Migrations:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Migrations\202005061800_migration_userTypes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Migrations\202005061802_migration_billStates.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Migrations\202005061803_migration_lineTypes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Migrations\202005061804_migration_callTypes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Migrations\202005061821_migration_interAreaCodes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Migrations\202005062121_migration_countryAreaCodes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Migrations\202005070005_migration_countries.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Migrations\202005071538_migration_provinces.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Migrations\202005071547_migration_localAreaCodes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Migrations\202005071548_migration_cities.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Migrations\202005151624_migration_rates.sql

REM End-status of the implementation of the database utnphones:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\General\999999999999_endstatus.sql

PAUSE
exit