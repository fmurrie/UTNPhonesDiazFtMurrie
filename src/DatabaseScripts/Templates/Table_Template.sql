/*Template for create a table object for MySQL*/

use 'Name of Database';

drop table if exists 'Name of the table';

create table if not exists 'Name of the table'('column_example_1' int,
'column_example_2' varchar(50),
'column_example_3' varchar(50));