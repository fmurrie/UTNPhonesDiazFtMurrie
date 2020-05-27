/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 07/05/2020
 *  Description: migration of data into the table countries.
 */

use utnphones;

drop procedure if exists migration_countries;
delimiter //
create procedure migration_countries
(
)
begin

if(not exists(select 1 from countries limit 1))
then

INSERT INTO countries (name, iso, areaCode) VALUES ('Afghanistan', 'AFG', '93');
INSERT INTO countries (name, iso, areaCode) VALUES ('Albania', 'ALB', '355');
INSERT INTO countries (name, iso, areaCode) VALUES ('Algeria', 'DZA', '213');
INSERT INTO countries (name, iso, areaCode) VALUES ('American Samoa', 'ASM', '1-684');
INSERT INTO countries (name, iso, areaCode) VALUES ('Andorra', 'AND', '376');
INSERT INTO countries (name, iso, areaCode) VALUES ('Angola', 'AGO', '244');
INSERT INTO countries (name, iso, areaCode) VALUES ('Anguilla', 'AIA', '1-264');
INSERT INTO countries (name, iso, areaCode) VALUES ('Antarctica', 'ATA', '672');
INSERT INTO countries (name, iso, areaCode) VALUES ('Antigua and Barbuda', 'ATG', '1-268');
INSERT INTO countries (name, iso, areaCode) VALUES ('Argentina', 'ARG', '54');
INSERT INTO countries (name, iso, areaCode) VALUES ('Armenia', 'ARM', '374');
INSERT INTO countries (name, iso, areaCode) VALUES ('Aruba', 'ABW', '297');
INSERT INTO countries (name, iso, areaCode) VALUES ('Australia', 'AUS', '61');
INSERT INTO countries (name, iso, areaCode) VALUES ('Austria', 'AUT', '43');
INSERT INTO countries (name, iso, areaCode) VALUES ('Azerbaijan', 'AZE', '994');
INSERT INTO countries (name, iso, areaCode) VALUES ('Bahamas', 'BHS', '1-242');
INSERT INTO countries (name, iso, areaCode) VALUES ('Bahrain', 'BHR', '973');
INSERT INTO countries (name, iso, areaCode) VALUES ('Bangladesh', 'BGD', '880');
INSERT INTO countries (name, iso, areaCode) VALUES ('Barbados', 'BRB', '1-246');
INSERT INTO countries (name, iso, areaCode) VALUES ('Belarus', 'BLR', '375');
INSERT INTO countries (name, iso, areaCode) VALUES ('Belgium', 'BEL', '32');
INSERT INTO countries (name, iso, areaCode) VALUES ('Belize', 'BLZ', '501');
INSERT INTO countries (name, iso, areaCode) VALUES ('Benin', 'BEN', '229');
INSERT INTO countries (name, iso, areaCode) VALUES ('Bermuda', 'BMU', '1-441');
INSERT INTO countries (name, iso, areaCode) VALUES ('Bhutan', 'BTN', '975');
INSERT INTO countries (name, iso, areaCode) VALUES ('Bolivia', 'BOL', '591');
INSERT INTO countries (name, iso, areaCode) VALUES ('Bosnia and Herzegovina', 'BIH', '387');
INSERT INTO countries (name, iso, areaCode) VALUES ('Botswana', 'BWA', '267');
INSERT INTO countries (name, iso, areaCode) VALUES ('Brazil', 'BRA', '55');
INSERT INTO countries (name, iso, areaCode) VALUES ('British Indian Ocean Territory', 'IOT', '246');
INSERT INTO countries (name, iso, areaCode) VALUES ('British Virgin Islands', 'VGB', '1-284');
INSERT INTO countries (name, iso, areaCode) VALUES ('Brunei', 'BRN', '673');
INSERT INTO countries (name, iso, areaCode) VALUES ('Bulgaria', 'BGR', '359');
INSERT INTO countries (name, iso, areaCode) VALUES ('Burkina Faso', 'BFA', '226');
INSERT INTO countries (name, iso, areaCode) VALUES ('Burundi', 'BDI', '257');
INSERT INTO countries (name, iso, areaCode) VALUES ('Cambodia', 'KHM', '855');
INSERT INTO countries (name, iso, areaCode) VALUES ('Cameroon', 'CMR', '237');
INSERT INTO countries (name, iso, areaCode) VALUES ('Canada', 'CAN', '1');
INSERT INTO countries (name, iso, areaCode) VALUES ('Cape Verde', 'CPV', '238');
INSERT INTO countries (name, iso, areaCode) VALUES ('Cayman Islands', 'CYM', '1-345');
INSERT INTO countries (name, iso, areaCode) VALUES ('Central African Republic', 'CAF', '236');
INSERT INTO countries (name, iso, areaCode) VALUES ('Chad', 'TCD', '235');
INSERT INTO countries (name, iso, areaCode) VALUES ('Chile', 'CHL', '56');
INSERT INTO countries (name, iso, areaCode) VALUES ('China', 'CHN', '86');
INSERT INTO countries (name, iso, areaCode) VALUES ('Christmas Island', 'CXR', '61');
INSERT INTO countries (name, iso, areaCode) VALUES ('Cocos Islands', 'CCK', '61');
INSERT INTO countries (name, iso, areaCode) VALUES ('Colombia', 'COL', '57');
INSERT INTO countries (name, iso, areaCode) VALUES ('Comoros', 'COM', '269');
INSERT INTO countries (name, iso, areaCode) VALUES ('Cook Islands', 'COK', '682');
INSERT INTO countries (name, iso, areaCode) VALUES ('Costa Rica', 'CRI', '506');
INSERT INTO countries (name, iso, areaCode) VALUES ('Croatia', 'HRV', '385');
INSERT INTO countries (name, iso, areaCode) VALUES ('Cuba', 'CUB', '53');
INSERT INTO countries (name, iso, areaCode) VALUES ('Curacao', 'CUW', '599');
INSERT INTO countries (name, iso, areaCode) VALUES ('Cyprus', 'CYP', '357');
INSERT INTO countries (name, iso, areaCode) VALUES ('Czech Republic', 'CZE', '420');
INSERT INTO countries (name, iso, areaCode) VALUES ('Democratic Republic of the Congo', 'COD', '243');
INSERT INTO countries (name, iso, areaCode) VALUES ('Denmark', 'DNK', '45');
INSERT INTO countries (name, iso, areaCode) VALUES ('Djibouti', 'DJI', '253');
INSERT INTO countries (name, iso, areaCode) VALUES ('Dominica', 'DMA', '1-767');
INSERT INTO countries (name, iso, areaCode) VALUES ('Dominican Republic', 'DOM', '1-809, 1-829, 1-849');
INSERT INTO countries (name, iso, areaCode) VALUES ('East Timor', 'TLS', '670');
INSERT INTO countries (name, iso, areaCode) VALUES ('Ecuador', 'ECU', '593');
INSERT INTO countries (name, iso, areaCode) VALUES ('Egypt', 'EGY', '20');
INSERT INTO countries (name, iso, areaCode) VALUES ('El Salvador', 'SLV', '503');
INSERT INTO countries (name, iso, areaCode) VALUES ('Equatorial Guinea', 'GNQ', '240');
INSERT INTO countries (name, iso, areaCode) VALUES ('Eritrea', 'ERI', '291');
INSERT INTO countries (name, iso, areaCode) VALUES ('Estonia', 'EST', '372');
INSERT INTO countries (name, iso, areaCode) VALUES ('Ethiopia', 'ETH', '251');
INSERT INTO countries (name, iso, areaCode) VALUES ('Falkland Islands', 'FLK', '500');
INSERT INTO countries (name, iso, areaCode) VALUES ('Faroe Islands', 'FRO', '298');
INSERT INTO countries (name, iso, areaCode) VALUES ('Fiji', 'FJI', '679');
INSERT INTO countries (name, iso, areaCode) VALUES ('Finland', 'FIN', '358');
INSERT INTO countries (name, iso, areaCode) VALUES ('France', 'FRA', '33');
INSERT INTO countries (name, iso, areaCode) VALUES ('French Polynesia', 'PYF', '689');
INSERT INTO countries (name, iso, areaCode) VALUES ('Gabon', 'GAB', '241');
INSERT INTO countries (name, iso, areaCode) VALUES ('Gambia', 'GMB', '220');
INSERT INTO countries (name, iso, areaCode) VALUES ('Georgia', 'GEO', '995');
INSERT INTO countries (name, iso, areaCode) VALUES ('Germany', 'DEU', '49');
INSERT INTO countries (name, iso, areaCode) VALUES ('Ghana', 'GHA', '233');
INSERT INTO countries (name, iso, areaCode) VALUES ('Gibraltar', 'GIB', '350');
INSERT INTO countries (name, iso, areaCode) VALUES ('Greece', 'GRC', '30');
INSERT INTO countries (name, iso, areaCode) VALUES ('Greenland', 'GRL', '299');
INSERT INTO countries (name, iso, areaCode) VALUES ('Grenada', 'GRD', '1-473');
INSERT INTO countries (name, iso, areaCode) VALUES ('Guam', 'GUM', '1-671');
INSERT INTO countries (name, iso, areaCode) VALUES ('Guatemala', 'GTM', '502');
INSERT INTO countries (name, iso, areaCode) VALUES ('Guernsey', 'GGY', '44-1481');
INSERT INTO countries (name, iso, areaCode) VALUES ('Guinea', 'GIN', '224');
INSERT INTO countries (name, iso, areaCode) VALUES ('Guinea-Bissau', 'GNB', '245');
INSERT INTO countries (name, iso, areaCode) VALUES ('Guyana', 'GUY', '592');
INSERT INTO countries (name, iso, areaCode) VALUES ('Haiti', 'HTI', '509');
INSERT INTO countries (name, iso, areaCode) VALUES ('Honduras', 'HND', '504');
INSERT INTO countries (name, iso, areaCode) VALUES ('Hong Kong', 'HKG', '852');
INSERT INTO countries (name, iso, areaCode) VALUES ('Hungary', 'HUN', '36');
INSERT INTO countries (name, iso, areaCode) VALUES ('Iceland', 'ISL', '354');
INSERT INTO countries (name, iso, areaCode) VALUES ('India', 'IND', '91');
INSERT INTO countries (name, iso, areaCode) VALUES ('Indonesia', 'IDN', '62');
INSERT INTO countries (name, iso, areaCode) VALUES ('Iran', 'IRN', '98');
INSERT INTO countries (name, iso, areaCode) VALUES ('Iraq', 'IRQ', '964');
INSERT INTO countries (name, iso, areaCode) VALUES ('Ireland', 'IRL', '353');
INSERT INTO countries (name, iso, areaCode) VALUES ('Isle of Man', 'IMN', '44-1624');
INSERT INTO countries (name, iso, areaCode) VALUES ('Israel', 'ISR', '972');
INSERT INTO countries (name, iso, areaCode) VALUES ('Italy', 'ITA', '39');
INSERT INTO countries (name, iso, areaCode) VALUES ('Ivory Coast', 'CIV', '225');
INSERT INTO countries (name, iso, areaCode) VALUES ('Jamaica', 'JAM', '1-876');
INSERT INTO countries (name, iso, areaCode) VALUES ('Japan', 'JPN', '81');
INSERT INTO countries (name, iso, areaCode) VALUES ('Jersey', 'JEY', '44-1534');
INSERT INTO countries (name, iso, areaCode) VALUES ('Jordan', 'JOR', '962');
INSERT INTO countries (name, iso, areaCode) VALUES ('Kazakhstan', 'KAZ', '7');
INSERT INTO countries (name, iso, areaCode) VALUES ('Kenya', 'KEN', '254');
INSERT INTO countries (name, iso, areaCode) VALUES ('Kiribati', 'KIR', '686');
INSERT INTO countries (name, iso, areaCode) VALUES ('Kosovo', 'XKX', '383');
INSERT INTO countries (name, iso, areaCode) VALUES ('Kuwait', 'KWT', '965');
INSERT INTO countries (name, iso, areaCode) VALUES ('Kyrgyzstan', 'KGZ', '996');
INSERT INTO countries (name, iso, areaCode) VALUES ('Laos', 'LAO', '856');
INSERT INTO countries (name, iso, areaCode) VALUES ('Latvia', 'LVA', '371');
INSERT INTO countries (name, iso, areaCode) VALUES ('Lebanon', 'LBN', '961');
INSERT INTO countries (name, iso, areaCode) VALUES ('Lesotho', 'LSO', '266');
INSERT INTO countries (name, iso, areaCode) VALUES ('Liberia', 'LBR', '231');
INSERT INTO countries (name, iso, areaCode) VALUES ('Libya', 'LBY', '218');
INSERT INTO countries (name, iso, areaCode) VALUES ('Liechtenstein', 'LIE', '423');
INSERT INTO countries (name, iso, areaCode) VALUES ('Lithuania', 'LTU', '370');
INSERT INTO countries (name, iso, areaCode) VALUES ('Luxembourg', 'LUX', '352');
INSERT INTO countries (name, iso, areaCode) VALUES ('Macau', 'MAC', '853');
INSERT INTO countries (name, iso, areaCode) VALUES ('Macedonia', 'MKD', '389');
INSERT INTO countries (name, iso, areaCode) VALUES ('Madagascar', 'MDG', '261');
INSERT INTO countries (name, iso, areaCode) VALUES ('Malawi', 'MWI', '265');
INSERT INTO countries (name, iso, areaCode) VALUES ('Malaysia', 'MYS', '60');
INSERT INTO countries (name, iso, areaCode) VALUES ('Maldives', 'MDV', '960');
INSERT INTO countries (name, iso, areaCode) VALUES ('Mali', 'MLI', '223');
INSERT INTO countries (name, iso, areaCode) VALUES ('Malta', 'MLT', '356');
INSERT INTO countries (name, iso, areaCode) VALUES ('Marshall Islands', 'MHL', '692');
INSERT INTO countries (name, iso, areaCode) VALUES ('Mauritania', 'MRT', '222');
INSERT INTO countries (name, iso, areaCode) VALUES ('Mauritius', 'MUS', '230');
INSERT INTO countries (name, iso, areaCode) VALUES ('Mayotte', 'MYT', '262');
INSERT INTO countries (name, iso, areaCode) VALUES ('Mexico', 'MEX', '52');
INSERT INTO countries (name, iso, areaCode) VALUES ('Micronesia', 'FSM', '691');
INSERT INTO countries (name, iso, areaCode) VALUES ('Moldova', 'MDA', '373');
INSERT INTO countries (name, iso, areaCode) VALUES ('Monaco', 'MCO', '377');
INSERT INTO countries (name, iso, areaCode) VALUES ('Mongolia', 'MNG', '976');
INSERT INTO countries (name, iso, areaCode) VALUES ('Montenegro', 'MNE', '382');
INSERT INTO countries (name, iso, areaCode) VALUES ('Montserrat', 'MSR', '1-664');
INSERT INTO countries (name, iso, areaCode) VALUES ('Morocco', 'MAR', '212');
INSERT INTO countries (name, iso, areaCode) VALUES ('Mozambique', 'MOZ', '258');
INSERT INTO countries (name, iso, areaCode) VALUES ('Myanmar', 'MMR', '95');
INSERT INTO countries (name, iso, areaCode) VALUES ('Namibia', 'NAM', '264');
INSERT INTO countries (name, iso, areaCode) VALUES ('Nauru', 'NRU', '674');
INSERT INTO countries (name, iso, areaCode) VALUES ('Nepal', 'NPL', '977');
INSERT INTO countries (name, iso, areaCode) VALUES ('Netherlands', 'NLD', '31');
INSERT INTO countries (name, iso, areaCode) VALUES ('Netherlands Antilles', 'ANT', '599');
INSERT INTO countries (name, iso, areaCode) VALUES ('New Caledonia', 'NCL', '687');
INSERT INTO countries (name, iso, areaCode) VALUES ('New Zealand', 'NZL', '64');
INSERT INTO countries (name, iso, areaCode) VALUES ('Nicaragua', 'NIC', '505');
INSERT INTO countries (name, iso, areaCode) VALUES ('Niger', 'NER', '227');
INSERT INTO countries (name, iso, areaCode) VALUES ('Nigeria', 'NGA', '234');
INSERT INTO countries (name, iso, areaCode) VALUES ('Niue', 'NIU', '683');
INSERT INTO countries (name, iso, areaCode) VALUES ('North Korea', 'PRK', '850');
INSERT INTO countries (name, iso, areaCode) VALUES ('Northern Mariana Islands', 'MNP', '1-670');
INSERT INTO countries (name, iso, areaCode) VALUES ('Norway', 'NOR', '47');
INSERT INTO countries (name, iso, areaCode) VALUES ('Oman', 'OMN', '968');
INSERT INTO countries (name, iso, areaCode) VALUES ('Pakistan', 'PAK', '92');
INSERT INTO countries (name, iso, areaCode) VALUES ('Palau', 'PLW', '680');
INSERT INTO countries (name, iso, areaCode) VALUES ('Palestine', 'PSE', '970');
INSERT INTO countries (name, iso, areaCode) VALUES ('Panama', 'PAN', '507');
INSERT INTO countries (name, iso, areaCode) VALUES ('Papua New Guinea', 'PNG', '675');
INSERT INTO countries (name, iso, areaCode) VALUES ('Paraguay', 'PRY', '595');
INSERT INTO countries (name, iso, areaCode) VALUES ('Peru', 'PER', '51');
INSERT INTO countries (name, iso, areaCode) VALUES ('Philippines', 'PHL', '63');
INSERT INTO countries (name, iso, areaCode) VALUES ('Pitcairn', 'PCN', '64');
INSERT INTO countries (name, iso, areaCode) VALUES ('Poland', 'POL', '48');
INSERT INTO countries (name, iso, areaCode) VALUES ('Portugal', 'PRT', '351');
INSERT INTO countries (name, iso, areaCode) VALUES ('Puerto Rico', 'PRI', '1-787, 1-939');
INSERT INTO countries (name, iso, areaCode) VALUES ('Qatar', 'QAT', '974');
INSERT INTO countries (name, iso, areaCode) VALUES ('Republic of the Congo', 'COG', '242');
INSERT INTO countries (name, iso, areaCode) VALUES ('Reunion', 'REU', '262');
INSERT INTO countries (name, iso, areaCode) VALUES ('Romania', 'ROU', '40');
INSERT INTO countries (name, iso, areaCode) VALUES ('Russia', 'RUS', '7');
INSERT INTO countries (name, iso, areaCode) VALUES ('Rwanda', 'RWA', '250');
INSERT INTO countries (name, iso, areaCode) VALUES ('Saint Barthelemy', 'BLM', '590');
INSERT INTO countries (name, iso, areaCode) VALUES ('Saint Helena', 'SHN', '290');
INSERT INTO countries (name, iso, areaCode) VALUES ('Saint Kitts and Nevis', 'KNA', '1-869');
INSERT INTO countries (name, iso, areaCode) VALUES ('Saint Lucia', 'LCA', '1-758');
INSERT INTO countries (name, iso, areaCode) VALUES ('Saint Martin', 'MAF', '590');
INSERT INTO countries (name, iso, areaCode) VALUES ('Saint Pierre and Miquelon', 'SPM', '508');
INSERT INTO countries (name, iso, areaCode) VALUES ('Saint Vincent and the Grenadines', 'VCT', '1-784');
INSERT INTO countries (name, iso, areaCode) VALUES ('Samoa', 'WSM', '685');
INSERT INTO countries (name, iso, areaCode) VALUES ('San Marino', 'SMR', '378');
INSERT INTO countries (name, iso, areaCode) VALUES ('Sao Tome and Principe', 'STP', '239');
INSERT INTO countries (name, iso, areaCode) VALUES ('Saudi Arabia', 'SAU', '966');
INSERT INTO countries (name, iso, areaCode) VALUES ('Senegal', 'SEN', '221');
INSERT INTO countries (name, iso, areaCode) VALUES ('Serbia', 'SRB', '381');
INSERT INTO countries (name, iso, areaCode) VALUES ('Seychelles', 'SYC', '248');
INSERT INTO countries (name, iso, areaCode) VALUES ('Sierra Leone', 'SLE', '232');
INSERT INTO countries (name, iso, areaCode) VALUES ('Singapore', 'SGP', '65');
INSERT INTO countries (name, iso, areaCode) VALUES ('Sint Maarten', 'SXM', '1-721');
INSERT INTO countries (name, iso, areaCode) VALUES ('Slovakia', 'SVK', '421');
INSERT INTO countries (name, iso, areaCode) VALUES ('Slovenia', 'SVN', '386');
INSERT INTO countries (name, iso, areaCode) VALUES ('Solomon Islands', 'SLB', '677');
INSERT INTO countries (name, iso, areaCode) VALUES ('Somalia', 'SOM', '252');
INSERT INTO countries (name, iso, areaCode) VALUES ('South Africa', 'ZAF', '27');
INSERT INTO countries (name, iso, areaCode) VALUES ('South Korea', 'KOR', '82');
INSERT INTO countries (name, iso, areaCode) VALUES ('South Sudan', 'SSD', '211');
INSERT INTO countries (name, iso, areaCode) VALUES ('Spain', 'ESP', '34');
INSERT INTO countries (name, iso, areaCode) VALUES ('Sri Lanka', 'LKA', '94');
INSERT INTO countries (name, iso, areaCode) VALUES ('Sudan', 'SDN', '249');
INSERT INTO countries (name, iso, areaCode) VALUES ('Suriname', 'SUR', '597');
INSERT INTO countries (name, iso, areaCode) VALUES ('Svalbard and Jan Mayen', 'SJM', '47');
INSERT INTO countries (name, iso, areaCode) VALUES ('Swaziland', 'SWZ', '268');
INSERT INTO countries (name, iso, areaCode) VALUES ('Sweden', 'SWE', '46');
INSERT INTO countries (name, iso, areaCode) VALUES ('Switzerland', 'CHE', '41');
INSERT INTO countries (name, iso, areaCode) VALUES ('Syria', 'SYR', '963');
INSERT INTO countries (name, iso, areaCode) VALUES ('Taiwan', 'TWN', '886');
INSERT INTO countries (name, iso, areaCode) VALUES ('Tajikistan', 'TJK', '992');
INSERT INTO countries (name, iso, areaCode) VALUES ('Tanzania', 'TZA', '255');
INSERT INTO countries (name, iso, areaCode) VALUES ('Thailand', 'THA', '66');
INSERT INTO countries (name, iso, areaCode) VALUES ('Togo', 'TGO', '228');
INSERT INTO countries (name, iso, areaCode) VALUES ('Tokelau', 'TKL', '690');
INSERT INTO countries (name, iso, areaCode) VALUES ('Tonga', 'TON', '676');
INSERT INTO countries (name, iso, areaCode) VALUES ('Trinidad and Tobago', 'TTO', '1-868');
INSERT INTO countries (name, iso, areaCode) VALUES ('Tunisia', 'TUN', '216');
INSERT INTO countries (name, iso, areaCode) VALUES ('Turkey', 'TUR', '90');
INSERT INTO countries (name, iso, areaCode) VALUES ('Turkmenistan', 'TKM', '993');
INSERT INTO countries (name, iso, areaCode) VALUES ('Turks and Caicos Islands', 'TCA', '1-649');
INSERT INTO countries (name, iso, areaCode) VALUES ('Tuvalu', 'TUV', '688');
INSERT INTO countries (name, iso, areaCode) VALUES ('U.S. Virgin Islands', 'VIR', '1-340');
INSERT INTO countries (name, iso, areaCode) VALUES ('Uganda', 'UGA', '256');
INSERT INTO countries (name, iso, areaCode) VALUES ('Ukraine', 'UKR', '380');
INSERT INTO countries (name, iso, areaCode) VALUES ('United Arab Emirates', 'ARE', '971');
INSERT INTO countries (name, iso, areaCode) VALUES ('United Kingdom', 'GBR', '44');
INSERT INTO countries (name, iso, areaCode) VALUES ('United States', 'USA', '1');
INSERT INTO countries (name, iso, areaCode) VALUES ('Uruguay', 'URY', '598');
INSERT INTO countries (name, iso, areaCode) VALUES ('Uzbekistan', 'UZB', '998');
INSERT INTO countries (name, iso, areaCode) VALUES ('Vanuatu', 'VUT', '678');
INSERT INTO countries (name, iso, areaCode) VALUES ('Vatican', 'VAT', '379');
INSERT INTO countries (name, iso, areaCode) VALUES ('Venezuela', 'VEN', '58');
INSERT INTO countries (name, iso, areaCode) VALUES ('Vietnam', 'VNM', '84');
INSERT INTO countries (name, iso, areaCode) VALUES ('Wallis and Futuna', 'WLF', '681');
INSERT INTO countries (name, iso, areaCode) VALUES ('Western Sahara', 'ESH', '212');
INSERT INTO countries (name, iso, areaCode) VALUES ('Yemen', 'YEM', '967');
INSERT INTO countries (name, iso, areaCode) VALUES ('Zambia', 'ZMB', '260');
INSERT INTO countries (name, iso, areaCode) VALUES ('Zimbabwe', 'ZWE', '263');

end if;

end //
delimiter ;

call migration_countries();