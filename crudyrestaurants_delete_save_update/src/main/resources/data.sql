DELETE
FROM menu;

DELETE
FROM restaurant;

INSERT INTO restaurant (restaurantid, name, address, city, state, telephone)
    VALUES (1, 'Apple', '123 Main Street', 'City', 'ST', '555-555-1234'),
           (2, 'Eagle Cafe', '321 Uptown Drive', 'Town', 'ST', '555-555-5555'),
           (3, 'Number 1 Eats', '565 Side Avenue', 'Village', 'ST', '555-123-1555');

INSERT INTO menu (menuid, dish, price, restaurantid)
    VALUES (4, 'Mac and Cheese', 6.95, 1),
           (5, 'Lasagna', 8.50, 1),
           (6, 'Meatloaf', 7.77, 1),
           (7, 'Tacos', 8.49, 1),
           (8, 'Chef Salad', 12.50, 1),
           (9, 'Tacos', 10.49, 2),
           (10, 'Barbacoa', 12.75, 2),
           (11, 'Pizza', 15.15, 3);

alter sequence hibernate_sequence restart with 15;