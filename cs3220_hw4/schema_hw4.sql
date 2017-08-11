USE cs3220xstu10;

CREATE TABLE food_items (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    food_name VARCHAR(255) NOT NULL,
    food_description VARCHAR(255) NOT NULL,
    food_url VARCHAR(255) NOT NULL,
    food_price DOUBLE NOT NULL,
    created DATETIME
);

INSERT INTO food_items VALUES
(1, 'GrilledChicken', 'Grilled Chiken, with spicy source', 'http://23209-presscdn.pagely.netdna-cdn.com/wp-content/uploads/2015/06/IMG_0319edit.jpg',17.00,now()),
(2,'Cram Chawder','Hot Cram Chawder with bacon and cheese','http://assets.simplyrecipes.com/wp-content/uploads/2012/11/clam-chowder-b.jpg',8.00,now()),
(3,'Apple Pie','American Taste, with Ice cream','http://www.seriouseats.com/recipes/assets_c/2014/11/20141114-cheddar-ice-cream-vicky-wasik-1-thumb-1500xauto-415185.jpg',5.99,now());

CREATE TABLE carts (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    food_name VARCHAR(255) NOT NULL,
    food_description VARCHAR(255) NOT NULL,
    food_url VARCHAR(255) NOT NULL,
    food_price DOUBLE NOT NULL,
    created DATETIME
);

CREATE TABLE orders (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    food_name VARCHAR(255) NOT NULL,
    food_url VARCHAR(255) NOT NULL,
    food_price DOUBLE NOT NULL,
    customer VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    created DATETIME
);




