echo off
cls
echo Hi Dear! You will start the implementation of the scripts for the database utnphones.
pause
SET PROJECT_PATH=%cd%
cd\
echo on

@REM Section for execute the scripts from \general:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\general\000000000000_utnphones.sql

@REM Section for execute the scripts from \functions\nativeFunctions:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\functions\nativeFunctions\202005021954_getDbUserName.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\functions\nativeFunctions\202005030129_getDateIn15Days.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\functions\nativeFunctions\202005102011_getYearMonth.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\functions\nativeFunctions\202005102036_getSecondsBetweenTwoDateTimes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\functions\nativeFunctions\202005122223_convertSecondsInMinutes.sql

@REM Section for execute the scripts from \tables:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\tables\202005022156_userTypes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\tables\202005022256_countries.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\tables\202005022325_billStates.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\tables\202005022326_callTypes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\tables\202005022338_lineTypes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\tables\202005022344_provinces.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\tables\202005022354_cities.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\tables\202005030020_users.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\tables\202005030047_phoneLines.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\tables\202005030139_bills.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\tables\202005031124_rates.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\tables\202005031155_calls.sql

@REM Section for execute the scripts from \views:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\views\202005101927_areaCodesView.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\views\202005121625_phoneLinesCitiesView.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\views\202005131644_idsPlacesView.sql

@REM Section for execute the scripts from \functions\customFunctions:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\functions\customFunctions\202005101538_getCompletePhoneNumber.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\functions\customFunctions\202005121624_getIdCityForIdPhoneLine.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\functions\customFunctions\202005131925_getIdCallTypeBetweenCities.sql

@REM Section for execute the scripts from \procedures:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\procedures\202005161130_users_registerAnUser.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\procedures\202005161204_phoneLines_registerAphoneLine.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\procedures\202005161228_calls_addAcall.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\procedures\202005161922_bills_monthFacturation.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\procedures\202005171953_users_get.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\procedures\202006161937_bills_checkExpiration.sql

@REM Section for execute the scripts from \triggers:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005101500_userTypes_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005101501_userTypes_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005101508_countries_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005101509_countries_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005101510_billStates_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005101511_billStates_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005101512_callTypes_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005101513_callTypes_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005101514_lineTypes_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005101515_lineTypes_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005101516_provinces_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005101517_provinces_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005101518_cities_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005101519_cities_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005101520_users_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005101521_users_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005101522_phoneLines_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005101523_phoneLines_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005101524_bills_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005101525_bills_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005101526_rates_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005101527_rates_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005101528_calls_before_insert.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005101529_calls_before_update.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\triggers\202005161943_bills_after_insert.sql

@REM Section for execute the scripts from \migrations:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\migrations\202005061800_migration_userTypes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\migrations\202005061802_migration_billStates.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\migrations\202005061803_migration_lineTypes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\migrations\202005061804_migration_callTypes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\migrations\202005070005_migration_countries.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\migrations\202005071538_migration_provinces.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\migrations\202005071548_migration_cities.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\migrations\202005151624_migration_rates.sql

@REM Section for execute the scripts from \events:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\events\202005162018_event_migration.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\events\202005171041_event_facturation.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\events\202006161855_event_verifyPays.sql

@REM End-status of the implementation of the database utnphones:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\general\999999999999_endstatus.sql

PAUSE
exit