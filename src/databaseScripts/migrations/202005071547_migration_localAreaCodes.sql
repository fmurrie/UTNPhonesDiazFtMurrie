/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 07/05/2020
 *  Description: migration of data into the table localAreaCodes.
*/

use utnphones;

drop procedure if exists migration_localAreaCodes;
delimiter //
create procedure migration_localAreaCodes
(
)
begin

if(not exists(select 1 from localAreaCodes limit 1))
then

INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('11', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('220', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2202', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('221', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2221', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2223', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2224', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2225', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2226', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2227', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2229', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('223', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2241', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2242', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2243', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2244', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2245', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2246', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2252', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2254', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2255', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2257', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2261', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2262', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2264', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2265', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2266', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2267', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2268', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2271', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2272', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2273', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2274', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2281', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2283', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2284', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2285', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2286', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2291', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2292', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2296', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2297', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('230', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2302', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2314', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2316', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2317', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2320', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2323', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2324', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2325', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2326', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2331', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2333', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2334', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2335', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2336', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2337', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2338', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2342', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2343', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2344', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2345', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2346', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2352', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2353', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2354', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2355', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2356', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2357', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2358', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('236', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('237', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2392', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2393', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2394', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2395', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2396', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2473', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2474', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2475', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2477', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2478', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('249', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('260', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('261', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2622', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2624', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2625', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2626', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('263', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('264', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2646', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2647', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2648', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2651', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2655', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2656', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2657', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2658', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('266', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('280', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2901', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2902', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2903', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('291', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2920', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2921', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2922', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2923', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2924', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2925', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2926', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2927', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2928', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2929', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2931', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2932', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2933', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2934', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2935', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2936', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('294', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2940', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2942', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2945', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2946', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2948', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2952', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2953', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2954', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2962', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2963', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2964', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2966', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('297', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2972', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('298', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2982', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('2983', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('299', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3327', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3329', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('336', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3382', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3385', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3387', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3388', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3400', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3401', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3402', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3404', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3405', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3406', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3407', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3408', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3409', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('341', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('342', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('343', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3435', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3436', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3437', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3438', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3442', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3444', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3445', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3446', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3447', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('345', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3454', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3455', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3456', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3458', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3460', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3462', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3463', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3464', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3465', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3466', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3467', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3468', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3469', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3471', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3472', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3476', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('348', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3482', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3483', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3487', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3489', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3491', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3492', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3493', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3496', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3497', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3498', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('351', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3521', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3522', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3524', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3525', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('353', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3532', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3533', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3537', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3541', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3542', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3543', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3544', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3546', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3547', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3548', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3549', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3562', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3563', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3564', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3571', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3572', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3573', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3574', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3575', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3576', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('358', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3582', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3583', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3584', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3585', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('362', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('364', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('370', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3711', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3715', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3716', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3718', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3721', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3725', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3731', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3734', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3735', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3741', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3743', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3751', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3754', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3755', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3756', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3757', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3758', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('376', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3772', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3773', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3774', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3775', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3777', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3781', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3782', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3786', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('379', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('380', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('381', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3821', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3825', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3826', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3827', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('383', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3832', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3835', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3837', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3838', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3841', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3843', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3844', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3845', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3846', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('385', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3854', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3855', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3856', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3857', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3858', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3861', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3862', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3863', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3865', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3867', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3868', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3869', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('387', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3873', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3876', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3877', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3878', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('388', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3885', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3886', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3887', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3888', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3891', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3892', 143);
INSERT INTO localareacodes (code, idCountryAreaCode) VALUES ('3894', 143);

end if;

end //
delimiter ;

call migration_localAreaCodes();