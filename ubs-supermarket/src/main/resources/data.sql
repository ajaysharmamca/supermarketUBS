INSERT INTO ITEM (ID, NAME, created_date, last_updated_date, PRICE ) 
VALUES(1,  'A', sysdate(), sysdate(), 40);

INSERT INTO ITEM (ID, NAME, created_date, last_updated_date, PRICE ) 
VALUES(2,  'B', sysdate(), sysdate(), 10);

INSERT INTO ITEM (ID, NAME, created_date, last_updated_date, PRICE ) 
VALUES(3,  'C', sysdate(), sysdate(), 2);

INSERT INTO ITEM (ID, NAME, created_date, last_updated_date, PRICE ) 
VALUES(4,  'D', sysdate(), sysdate(), 40);


INSERT INTO special_price(PRICE, QUANTITY, item_id) values (60, 3, 1);
INSERT INTO special_price(PRICE, QUANTITY, item_id) values (75, 5, 1);
INSERT INTO special_price(PRICE, QUANTITY, item_id) values (100, 10, 1);
INSERT INTO special_price(PRICE, QUANTITY, item_id) values (150, 20, 1);
INSERT INTO special_price(PRICE, QUANTITY, item_id) values (15, 2, 2);
INSERT INTO special_price(PRICE, QUANTITY, item_id) values (50, 75, 3);