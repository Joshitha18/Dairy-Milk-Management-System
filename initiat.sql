DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS feedback;
DROP TABLE IF EXISTS milk_rate_table;
DROP TABLE IF EXISTS dairy_milk_sell_table;
DROP TABLE IF EXISTS sellerTable;
DROP TABLE IF EXISTS staffTable;
DROP TABLE IF EXISTS headTable;
DROP TABLE IF EXISTS CenterTable;
DROP TABLE IF EXISTS deliver_milk_details;
DROP TABLE IF EXISTS shopTable;


CREATE TABLE users (user_id varchar(15) NOT NULL PRIMARY KEY,
                    password varchar(10) NOT NULL,
                    role varchar(20) NOT NULL);
INSERT INTO users VALUES ('Janhavi', '12345', 'Admin');

CREATE TABLE CenterTable (center_no varchar(15) NOT NULL PRIMARY KEY,
                            city varchar(10) NOT NULL,
                            head_id varchar(10) NOT NULL);
INSERT INTO CenterTable VALUES (2332, 'Surat', 180010067);

CREATE TABLE headTable (ID varchar(10) PRIMARY KEY,
                        name varchar(50) NOT NULL,
                        salary BIGINT NOT NULL,
                        "phone no." varchar(10) NOT NULL,
                        center_no varchar(10) REFERENCES CenterTable(center_no));
INSERT INTO headTable VALUES (2222, 'Vikramaditya singh', '100000', '2983746465', 2332);

CREATE TABLE staffTable (st_ID varchar(10) PRIMARY KEY,
                        st_name varchar(50) NOT NULL,
                        salary bigint NOT NULL,
                        "phone no." varchar(10) NOT NULL,
                        head_ID varchar(10) REFERENCES headTable(ID));
                        -- s_code varchar(10) REFERENCES sellerTable(s_code));
INSERT INTO staffTable VALUES (1118, 'shilpa suman', 100000, 3209494493, 2222);

CREATE TABLE milk_rate_table (Date date,
                            center_no varchar(15) ,
                            city varchar(10) NOT NULL,
                            quantity_cow_milk float NOT NULL,
                            quantity_buffalo_milk float NOT NULL,
                            fat_cow_milk float NOT NULL,
                            fat_buffalo_milk float NOT NULL,
                            PRIMARY KEY (Date, center_no));
INSERT INTO milk_rate_table VALUES ('11/28/2020', 2332, 'Surat', 200, 300, 3.4, 5.5);

CREATE TABLE sellerTable (s_code varchar(10) PRIMARY KEY,
                            user_id varchar(10) NOT NULL,
                            s_name varchar(50) NOT NULL,
                            center_no varchar(15) NOT NULL,
                            cattle_type varchar(50) NOT NULL,
                            r_date date NOT NULL,
                            head_ID varchar(10) REFERENCES headTable(ID));
INSERT INTO sellerTable VALUES (9889, 'rioname', 'Janhavikumari', '2332', 'cow', '11/28/2020',2222);

CREATE TABLE dairy_milk_sell_table (user_ID varchar(10),
                                    s_code varchar(10) REFERENCES sellerTable(s_code),
                                    fat float NOT NULL,
                                    quantity int NOT NULL,
                                    cattle_type varchar(50) NOT NULL,
                                    submit_date date,
                                    center_no varchar(15),
                                    PRIMARY KEY (user_ID, cattle_type, submit_date));
INSERT INTO dairy_milk_sell_table VALUES (2221, '9889', 4.4, 20, 'buffalo', '11-28-2020', 2332);

CREATE TABLE shopTable (shopNo varchar(15) NOT NULL,
                        city varchar(10) NOT NULL,
                        incharge varchar(50) NOT NULL,
                        shop_name varchar(50) NOT NULL,
                        address varchar(50) NOT NULL,
                        buyer_id varchar(10) PRIMARY KEY);
INSERT INTO shopTable VALUES (2033, 'surat', 'Janhavi', 'dholakpur shop', '5th street dholakpur main road India', 1112);

CREATE TABLE deliver_milk_details (shop_no varchar(15) NOT NULL,
                                    fat float NOT NULL,
                                    quantity int NOT NULL,
                                    type varchar(50) NOT NULL,
                                    Date date,
                                    buyer_ID varchar(10) REFERENCES shopTable(buyer_id),
                                    PRIMARY KEY (shop_no, Date, type));
INSERT INTO deliver_milk_details VALUES (2033, 4.4, 50, 'cow', '11/28/2020', 1112);
INSERT INTO deliver_milk_details VALUES (2033, 6.4, 50, 'buffalo', '11/28/2020', 1112);

CREATE TABLE feedback (feedback varchar(50) NOT NULL,
                        role varchar(10) NOT NULL,
                        name varchar(50) NOT NULL,
                        ID varchar(10) NOT NULL,
                        Date date,
                        PRIMARY KEY (ID, Date));
INSERT INTO feedback VALUES ('the staff with seller ID 1111 is awsome :)', 'staff', 'Janhavi', 1220, '11/28/2020');
