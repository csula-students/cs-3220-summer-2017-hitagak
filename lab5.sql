-- create food items table
CREATE TABLE food_items (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    food_name VARCHAR(255) NOT NULL,
    food_description VARCHAR(255) NOT NULL,
    food_price DOUBLE NOT NULL
);

-- create order statuses table
CREATE TABLE order_statuses (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL,
    created DATETIME
);

-- create order foods table
CREATE TABLE order_foods (
	order_ID INTEGER,
	food_ID INTEGER,
	quantity_ID INTEGER

);

-- create restaurant cart table
CREATE TABLE restaurant_cart (
    id INTEGER,
    customer_name VARCHAR(255) NOT NULL,
    food_ID INTEGER NOT NULL,
    quantity INTEGER NOT NULL
);

-- insert default food items data into food_items table
INSERT INTO food_items VALUES
(1, 'Hamburger', 'A hamburger', 9.99),
(2,'Fries','Some fries',4.99),
(3,'Coke','Coke cola',2.99);

-- insert default order statuses into order_statuses table
INSERT INTO order_statuses VALUES
(1,'Eric','2017-07-20 13:35:55'),
(2,'John','2017-07-20 10:35:55'),
(3,'Jane','2017-07-20 15:35:55'),
(4,'Alice',NOW());


-- insert default order foods data into order_foods table
INSERT INTO order_foods VALUES
(1,1,1),
(1,2,2),
(2,2,2),
(2,3,1),
(3,3,1),
(4,2,1),
(4,3,2);

-- insert default shopping cart data into restaurant_cart table
INSERT INTO restaurant_cart VALUES
(1, 'Anonymous', 1, 2),
(1, 'Anonymous', 2, 1),
(1, 'Anonymous', 2, 1),
(2, 'Mike', 1, 1),
(2, 'Mike', 2, 1),
(3, 'Bob', 3, 1);


-- Update food item name from "Hamburger" to "Salad"
SET SQL_SAFE_UPDATES = 0;

UPDATE food_items
SET food_name='Salad'
WHERE food_name='Hamburger';


-- Update customer name from "Jane" to "Doe"
SET SQL_SAFE_UPDATES = 0;
UPDATE order_statuses
SET customer_name='Doe'
WHERE customer_name='Jane';

-- Find out which food item has the most orders
SELECT food_items.food_name,
SUM(order_foods.quantity_ID) as numoforders
FROM food_items 
INNER JOIN
order_foods 
WHERE food_items.id = order_foods.food_ID
GROUP BY food_ID
ORDER BY numoforders DESC LIMIT 1;


-- Find out which food item in least shopping carts
SELECT food_items.food_name,
SUM(restaurant_cart.quantity) as numofcart
FROM food_items
INNER JOIN
restaurant_cart
WHERE food_items.id = restaurant_cart.food_ID 
GROUP BY food_ID
ORDER BY numofcart ASC LIMIT 1;


-- Find out all restaurant food items using SELECT query
SELECT * FROM food_items;

-- Find out all restaurant order statuses using SELECT query
SELECT * FROM order_statuses;

-- Find out the order statuses that is created today
SELECT * FROM order_statuses
WHERE created LIKE '%2017-07-23%';

-- Delete food_items, order_statuses, restaurant_cart tables
DROP TABLE food_items;
DROP TABLE order_statuses;
DROP TABLE restaurant_cart;
