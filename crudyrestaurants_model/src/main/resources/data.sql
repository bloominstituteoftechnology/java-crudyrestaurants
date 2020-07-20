DELETE
from restaurantpayments;

DELETE
FROM payments;

DELETE
FROM menus;

DELETE
FROM restaurants;

INSERT INTO payments (paymentid, type)
    VALUES (1, 'Cash'),
           (2, 'Credit Card'),
           (3, 'Mobile Pay');

INSERT INTO restaurants (restaurantid, name, address, city, state, telephone, seatcapacity)
    VALUES (1, 'Apple', '123 Main Street', 'City', 'ST', '555-555-1234', 15),
           (2, 'Eagle Cafe', '321 Uptown Drive', 'Town', 'ST', '555-555-5555', 24),
           (3, 'Number 1 Eats', '565 Side Avenue', 'Village', 'ST', '555-123-1555', 37);

INSERT INTO restaurantpayments
    VALUES (1, 1),
           (1, 2),
           (1, 3),
           (2, 3),
           (3, 2),
           (3, 3);

INSERT INTO menus (menuid, dish, price, restaurantid)
    VALUES (4, 'Mac and Cheese', 6.95, 1),
           (5, 'Lasagna', 8.50, 1),
           (6, 'Meatloaf', 7.77, 1),
           (7, 'Tacos', 8.49, 1),
           (8, 'Chef Salad', 12.50, 1),
           (9, 'Tacos', 10.49, 2),
           (10, 'Barbacoa', 12.75, 2),
           (11, 'Pizza', 15.15, 3);

/*
We must tell hibernate the ids that have already been used.
The number must be larger than the last used id.
15 > 11 so we are good!
 */

alter sequence hibernate_sequence restart with 15;