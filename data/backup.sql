-- H2 2.3.232; 
;              
CREATE USER IF NOT EXISTS "SA" SALT '5d9fe5173fdf07c2' HASH 'd980ef9f62cb4c5c5182e668cbb6d29d489a4c725feaec68954cb8521c687d6b' ADMIN;          
CREATE CACHED TABLE "PUBLIC"."CATEGORY"(
    "CATEGORY_ID" BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 5) NOT NULL,
    "CATEGORY_DESCRIPTION" CHARACTER VARYING(255),
    "CATEGORY_NAME" CHARACTER VARYING(255) NOT NULL,
    "IS_ACTIVE" BOOLEAN
);   
ALTER TABLE "PUBLIC"."CATEGORY" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_3" PRIMARY KEY("CATEGORY_ID");             
-- 3 +/- SELECT COUNT(*) FROM PUBLIC.CATEGORY; 
INSERT INTO "PUBLIC"."CATEGORY" VALUES
(1, 'shirt for men', 'shirt', FALSE),
(3, 'pant for men', 'pant', FALSE),
(4, 'saree for women', 'saree', FALSE);       
CREATE CACHED TABLE "PUBLIC"."PRODUCT"(
    "PRODUCT_ID" BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "BRAND_NAME" CHARACTER VARYING(255),
    "CREATED_AT" TIMESTAMP(6),
    "CURRENT_STOCK" FLOAT(53) NOT NULL,
    "DESCRIPTION" CHARACTER VARYING(255),
    "FEATURED_PRODUCT" BOOLEAN NOT NULL,
    "IMAGE_URL" CHARACTER VARYING(255),
    "IS_PUBLISHED" BOOLEAN NOT NULL,
    "NAME" CHARACTER VARYING(255),
    "RATING" FLOAT(53) NOT NULL,
    "REGULAR_PRICE" FLOAT(53) NOT NULL,
    "SALES_PRICE" FLOAT(53) NOT NULL,
    "STOCK_LAST_REFILLED" TIMESTAMP(6),
    "CATEGORY_ID" BIGINT NOT NULL
);        
ALTER TABLE "PUBLIC"."PRODUCT" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1" PRIMARY KEY("PRODUCT_ID");               
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.PRODUCT;  
ALTER TABLE "PUBLIC"."CATEGORY" ADD CONSTRAINT "PUBLIC"."UKLROEO5FVFDEG4HPICN4LW7X9B" UNIQUE NULLS DISTINCT ("CATEGORY_NAME"); 
ALTER TABLE "PUBLIC"."PRODUCT" ADD CONSTRAINT "PUBLIC"."FK1MTSBUR82FRN64DE7BALYMQ9S" FOREIGN KEY("CATEGORY_ID") REFERENCES "PUBLIC"."CATEGORY"("CATEGORY_ID") NOCHECK;         
