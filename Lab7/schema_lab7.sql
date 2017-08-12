CREATE TABLE food_items_lab7 (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    food_name VARCHAR(255) NOT NULL,
    food_description VARCHAR(255) NOT NULL,
    food_url VARCHAR(255) NOT NULL,
    food_price DOUBLE NOT NULL
);

INSERT INTO food_items_lab7 VALUES
(1, 'GrilledChicken', 'Grilled Chiken, with spicy source', 'http://23209-presscdn.pagely.netdna-cdn.com/wp-content/uploads/2015/06/IMG_0319edit.jpg',17.00),
(2,'Cram Chawder','Hot Cram Chawder with bacon and cheese','http://assets.simplyrecipes.com/wp-content/uploads/2012/11/clam-chowder-b.jpg',8.00),
(3,'Apple Pie','American Taste, with Ice cream','http://www.seriouseats.com/recipes/assets_c/2014/11/20141114-cheddar-ice-cream-vicky-wasik-1-thumb-1500xauto-415185.jpg',5.99);

/*I created default orders*/
CREATE TABLE orders_lab7 (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    food_name VARCHAR(255) NOT NULL,
    food_url VARCHAR(255) NOT NULL,
    food_price DOUBLE NOT NULL,
    customer VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL
);

INSERT INTO orders_lab7 VALUES
(1, 'GrilledChicken', 'http://23209-presscdn.pagely.netdna-cdn.com/wp-content/uploads/2015/06/IMG_0319edit.jpg',17.00,'Hiroko','IN_QUEUE'),
(2,'Cram Chawder','http://assets.simplyrecipes.com/wp-content/uploads/2012/11/clam-chowder-b.jpg',8.00,'Aiko','IN_PROGRESS');

