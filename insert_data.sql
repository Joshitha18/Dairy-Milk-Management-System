INSERT INTO users VALUES ('4555', '12345', 'Head');
INSERT INTO users VALUES ('4556', '12311', 'Head');
INSERT INTO users VALUES ('4557', '12312', 'Staff');
INSERT INTO users VALUES ('4558', '34345', 'Staff');
INSERT INTO users VALUES ('4559', '14345', 'Staff');
INSERT INTO users VALUES ('4560', '1345', 'Staff');
INSERT INTO users VALUES ('4551', '2345', 'Seller');
INSERT INTO users VALUES ('4552', '1112345', 'Seller');
INSERT INTO users VALUES ('4553', '1234345', 'Seller');
INSERT INTO users VALUES ('4554', '1234532', 'Seller');
INSERT INTO users VALUES ('4561', '123451', 'Buyer');
INSERT INTO users VALUES ('4562', '12345234', 'Buyer');
INSERT INTO users VALUES ('4563', '1234', 'Buyer');
INSERT INTO users VALUES ('4564', '123450', 'Buyer');

INSERT INTO CenterTable VALUES (8821, 'Surat', 4555);
INSERT INTO CenterTable VALUES (8822, 'Hyd', 4556);

INSERT INTO headTable VALUES (4555, 'Vikram', '100000', '2983749965', 8821);
INSERT INTO headTable VALUES (4556, 'aditya', '100000', '2983886465', 8822);

INSERT INTO staffTable VALUES (4557, 'suman', 100000, 2309494493, 4555);
INSERT INTO staffTable VALUES (4558, 'amar', 100000, 5609494493, 4556);
INSERT INTO staffTable VALUES (4559, 'roy', 100000, 7709494493, 4555);
INSERT INTO staffTable VALUES (4560, 'abay', 100000, 9009494493, 4556);

INSERT INTO milk_rate_table VALUES ('10/28/2020', 8821, 'Surat', 200, 3000, 7.4, 8.5);
INSERT INTO milk_rate_table VALUES ('10/29/2020', 8821, 'Surat', 250, 2000, 7.4, 8.5);
INSERT INTO milk_rate_table VALUES ('10/27/2020', 8821, 'Surat', 300, 1000, 7.5, 8.0);
INSERT INTO milk_rate_table VALUES ('10/26/2020', 8821, 'Surat', 200, 2000, 7.4, 8.5);
INSERT INTO milk_rate_table VALUES ('10/25/2020', 8821, 'Surat', 300, 3000, 7.4, 8.0);
INSERT INTO milk_rate_table VALUES ('10/28/2020', 8822, 'Hyd', 200, 3000, 7.4, 8.5);
INSERT INTO milk_rate_table VALUES ('10/29/2020', 8822, 'Hyd', 250, 2000, 7.4, 8.5);
INSERT INTO milk_rate_table VALUES ('10/27/2020', 8822, 'Hyd', 300, 1000, 7.5, 8.0);
INSERT INTO milk_rate_table VALUES ('10/26/2020', 8822, 'Hyd', 200, 2000, 7.4, 8.5);
INSERT INTO milk_rate_table VALUES ('10/25/2020', 8822, 'Hyd', 300, 3000, 7.4, 8.0);

INSERT INTO sellerTable VALUES (4551, '1190', 'Jessi', '8821', 'cow', '09/28/2020',4555);
INSERT INTO sellerTable VALUES (4552, '1191', 'Angela', '8822', 'buffalo', '09/28/2020',4556);
INSERT INTO sellerTable VALUES (4553, '1192', 'Tom', '8822', 'cow', '09/28/2020',4556);
INSERT INTO sellerTable VALUES (4554, '1193', 'Jerry', '8821', 'buffalo', '09/28/2020',4555);

INSERT INTO dairy_milk_sell_table VALUES (1190, '4551', 7.4, 20, 'cow', '10-28-2020', 2332);
INSERT INTO dairy_milk_sell_table VALUES (1190, '4551', 7.0, 25, 'cow', '10-29-2020', 2332);
INSERT INTO dairy_milk_sell_table VALUES (1191, '4552', 7.4, 30, 'buffalo', '10-28-2020', 2332);
INSERT INTO dairy_milk_sell_table VALUES (1191, '4552', 8.4, 30, 'buffalo', '10-29-2020', 2332);
INSERT INTO dairy_milk_sell_table VALUES (1192, '4553', 7.4, 50, 'cow', '10-28-2020', 2332);
INSERT INTO dairy_milk_sell_table VALUES (1192, '4553', 7.8, 50, 'cow', '10-29-2020', 2332);
INSERT INTO dairy_milk_sell_table VALUES (1193, '4554', 8.6, 20, 'buffalo', '10-28-2020', 2332);
INSERT INTO dairy_milk_sell_table VALUES (1193, '4554', 8.9, 20, 'buffalo', '10-29-2020', 2332);
INSERT INTO dairy_milk_sell_table VALUES (1193, '4554', 8.5, 20, 'buffalo', '10-30-2020', 2332);

INSERT INTO feedback VALUES ('the staff with seller ID 1111 is awsome :)', 'Seller', 'Jessi', 4551, '11/28/2020');
INSERT INTO feedback VALUES ('user friendly :)', 'Seller', 'Jessi', 4551, '11/27/2020');
INSERT INTO feedback VALUES ('nice :)', 'Seller', 'Jessi', 4551, '11/29/2020');
INSERT INTO feedback VALUES ('can be improved :|', 'Seller', 'Angela', 4552, '11/29/2020');
INSERT INTO feedback VALUES ('good :)', 'Seller', 'Angela', 4552, '11/01/2020');
INSERT INTO feedback VALUES ('on time :)', 'Buyer', 'Anu', 4561, '12/01/2020');
INSERT INTO feedback VALUES ('good :)', 'Seller', 'Anu', 4561, '12/02/2020');

INSERT INTO shopTable VALUES (4561, 'Hyd', 'Anu', 'abc shop', 'xyz road', '6781');
INSERT INTO shopTable VALUES (4562, 'Surat', 'Rahul', 'dholakpur shop', '5th street dholakpur main road India', '6782');
INSERT INTO shopTable VALUES (4563, 'Hyd', 'Harsha', 'efg shop', 'xyz road', '6783');
INSERT INTO shopTable VALUES (4564, 'Hyd', 'Ram', 'mno shop', 'xyz road', '6784');

INSERT INTO deliver_milk_details VALUES (4561, 7.4, 50, 'cow', '11/28/2020', 6781);
INSERT INTO deliver_milk_details VALUES (4561, 8.4, 50, 'buffalo', '11/28/2020', 6781);
INSERT INTO deliver_milk_details VALUES (4562, 7.6, 20, 'cow', '11/28/2020', 6782);
INSERT INTO deliver_milk_details VALUES (4562, 8.0, 50, 'buffalo', '11/28/2020', 6782);
INSERT INTO deliver_milk_details VALUES (4563, 7.4, 30, 'cow', '11/28/2020', 6783);
INSERT INTO deliver_milk_details VALUES (4563, 8.4, 40, 'buffalo', '11/28/2020', 6783);
INSERT INTO deliver_milk_details VALUES (4564, 7.4, 50, 'cow', '11/28/2020', 6784);
INSERT INTO deliver_milk_details VALUES (4564, 8.4, 50, 'buffalo', '11/28/2020', 6784);
