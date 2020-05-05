echo off
cls
echo Hi Dear! You will start the implementation of the scripts for the database utnphones.
pause
SET PROJECT_PATH=%cd%
cd..
cd..
cd..
cd..
cd..
cd..
cd..
cd..
cd..
cd..
cd..
cd..
cd..
cd..
cd..
cd..
cd..
cd..
cd..
cd..
cd..
cd..
cd..
cd..
cd..
cd..
cd..
cd..
cd..
cd..
REM Section for execute the scripts from General:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\General\000000000000_utnphones.sql

REM Section for execute the scripts from Functions\NativeFunctions:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Functions\NativeFunctions\202005021954_getDbUserName.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Functions\NativeFunctions\202005030129_getDateIn15Days.sql

REM Section for execute the scripts from Tables:
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005022156_roles.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005022213_companies.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005022216_interAreaCodes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005022227_countryAreaCodes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005022237_localAreaCodes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005022256_countries.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005022325_billStates.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005022338_lineTypes.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005022344_provinces.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005022354_cities.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005030020_users.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005030047_phoneLines.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005030139_bills.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005031124_rates.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005031155_calls.sql
xampp\mysql\bin\mysql -u root<%PROJECT_PATH%\Tables\202005041929_rolesForUsers.sql

PAUSE
exit