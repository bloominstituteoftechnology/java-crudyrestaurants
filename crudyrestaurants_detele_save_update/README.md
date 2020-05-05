# Java Reading Deleting Saving Updating CRUDy Restaurants

A student that completes this project shows that they can:

* Perform CRUD operations on an RDBMS JPA and Hibernate (Creating and Updating Records)
* Perform CRUD operations on an RDBMS JPA and Hibernate (Updating certain fields in records)
* Perform CRUD operations on an RDBMS JPA and Hibernate (Deleting records)
* Understand and implement @Transactional annotation
* Implement a data seeding class using JPA and Hibernate
* Implement massive data seeding
* Use H2 Console and H2 IntelliJ integration to explore data

## Introduction

This is a basic database scheme with restaurants, menus, payment system. This Java Spring REST API application will provide endpoints for clients to read various data sets contained in the application's data.

Using the provided seed data, a successful application will return the following data based on the given endpoint. Expand the section of the endpoint to see the data that is returned.

### Database layout

The table layouts are as follows

* Restaurant is the driving table.
* Menus have a Many-To-One relationship with Restaurant. Each Restaurant has many menus. Each menu has only one Restaurant.
* Payments have a Many-To-Many relationship with Restaurants.

![Image of Database Layout](../java-crudyrestaurant-read-db.png)

Using the provided seed data, the given endpoint will produce the stated output. Expand each endpoint to see its correct output.

<details>
<summary>http://localhost:2019/menus/menus</summary>

```JSON
[
    {
        "menuid": 5,
        "dish": "Mac and Cheese",
        "price": 6.95,
        "restaurant": {
            "restaurantid": 4,
            "name": "Apple",
            "address": "123 Main Street",
            "city": "City",
            "state": "ST",
            "telephone": "555-555-1234",
            "seatcapacity": 15,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                },
                {
                    "paymentid": 2,
                    "type": "Credit Card"
                },
                {
                    "paymentid": 3,
                    "type": "Mobile Pay"
                }
            ]
        }
    },
    {
        "menuid": 6,
        "dish": "Lasagna",
        "price": 8.5,
        "restaurant": {
            "restaurantid": 4,
            "name": "Apple",
            "address": "123 Main Street",
            "city": "City",
            "state": "ST",
            "telephone": "555-555-1234",
            "seatcapacity": 15,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                },
                {
                    "paymentid": 2,
                    "type": "Credit Card"
                },
                {
                    "paymentid": 3,
                    "type": "Mobile Pay"
                }
            ]
        }
    },
    {
        "menuid": 7,
        "dish": "Meatloaf",
        "price": 7.77,
        "restaurant": {
            "restaurantid": 4,
            "name": "Apple",
            "address": "123 Main Street",
            "city": "City",
            "state": "ST",
            "telephone": "555-555-1234",
            "seatcapacity": 15,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                },
                {
                    "paymentid": 2,
                    "type": "Credit Card"
                },
                {
                    "paymentid": 3,
                    "type": "Mobile Pay"
                }
            ]
        }
    },
    {
        "menuid": 8,
        "dish": "Tacos",
        "price": 8.49,
        "restaurant": {
            "restaurantid": 4,
            "name": "Apple",
            "address": "123 Main Street",
            "city": "City",
            "state": "ST",
            "telephone": "555-555-1234",
            "seatcapacity": 15,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                },
                {
                    "paymentid": 2,
                    "type": "Credit Card"
                },
                {
                    "paymentid": 3,
                    "type": "Mobile Pay"
                }
            ]
        }
    },
    {
        "menuid": 9,
        "dish": "Chef Salad",
        "price": 12.5,
        "restaurant": {
            "restaurantid": 4,
            "name": "Apple",
            "address": "123 Main Street",
            "city": "City",
            "state": "ST",
            "telephone": "555-555-1234",
            "seatcapacity": 15,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                },
                {
                    "paymentid": 2,
                    "type": "Credit Card"
                },
                {
                    "paymentid": 3,
                    "type": "Mobile Pay"
                }
            ]
        }
    },
    {
        "menuid": 11,
        "dish": "Tacos",
        "price": 10.49,
        "restaurant": {
            "restaurantid": 10,
            "name": "Eagle Cafe",
            "address": "321 Uptown Drive",
            "city": "Town",
            "state": "ST",
            "telephone": "555-555-5555",
            "seatcapacity": 25,
            "payments": [
                {
                    "paymentid": 3,
                    "type": "Mobile Pay"
                }
            ]
        }
    },
    {
        "menuid": 12,
        "dish": "Barbacoa",
        "price": 12.75,
        "restaurant": {
            "restaurantid": 10,
            "name": "Eagle Cafe",
            "address": "321 Uptown Drive",
            "city": "Town",
            "state": "ST",
            "telephone": "555-555-5555",
            "seatcapacity": 25,
            "payments": [
                {
                    "paymentid": 3,
                    "type": "Mobile Pay"
                }
            ]
        }
    },
    {
        "menuid": 14,
        "dish": "Pizza",
        "price": 15.15,
        "restaurant": {
            "restaurantid": 13,
            "name": "Number 1 Eats",
            "address": "565 Side Avenue",
            "city": "Village",
            "state": "ST",
            "telephone": "555-123-1555",
            "seatcapacity": 110,
            "payments": [
                {
                    "paymentid": 2,
                    "type": "Credit Card"
                },
                {
                    "paymentid": 3,
                    "type": "Mobile Pay"
                }
            ]
        }
    },
    {
        "menuid": 16,
        "dish": "Kebab",
        "price": 62.01,
        "restaurant": {
            "restaurantid": 15,
            "name": "Deep Space Nine Cafe",
            "address": "3736 Gorczany Cliffs",
            "city": "Caraburgh",
            "state": "MN",
            "telephone": "1-610-848-0836",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 17,
        "dish": "French Fries with Sausages",
        "price": 65.18,
        "restaurant": {
            "restaurantid": 15,
            "name": "Deep Space Nine Cafe",
            "address": "3736 Gorczany Cliffs",
            "city": "Caraburgh",
            "state": "MN",
            "telephone": "1-610-848-0836",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 18,
        "dish": "Fettuccine Alfredo",
        "price": 25.59,
        "restaurant": {
            "restaurantid": 15,
            "name": "Deep Space Nine Cafe",
            "address": "3736 Gorczany Cliffs",
            "city": "Caraburgh",
            "state": "MN",
            "telephone": "1-610-848-0836",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 19,
        "dish": "Pasta and Beans",
        "price": 73.92,
        "restaurant": {
            "restaurantid": 15,
            "name": "Deep Space Nine Cafe",
            "address": "3736 Gorczany Cliffs",
            "city": "Caraburgh",
            "state": "MN",
            "telephone": "1-610-848-0836",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 20,
        "dish": "Stinky Tofu",
        "price": 68.82,
        "restaurant": {
            "restaurantid": 15,
            "name": "Deep Space Nine Cafe",
            "address": "3736 Gorczany Cliffs",
            "city": "Caraburgh",
            "state": "MN",
            "telephone": "1-610-848-0836",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 21,
        "dish": "Bunny Chow",
        "price": 19.14,
        "restaurant": {
            "restaurantid": 15,
            "name": "Deep Space Nine Cafe",
            "address": "3736 Gorczany Cliffs",
            "city": "Caraburgh",
            "state": "MN",
            "telephone": "1-610-848-0836",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 22,
        "dish": "Pork Belly Buns",
        "price": 25.5,
        "restaurant": {
            "restaurantid": 15,
            "name": "Deep Space Nine Cafe",
            "address": "3736 Gorczany Cliffs",
            "city": "Caraburgh",
            "state": "MN",
            "telephone": "1-610-848-0836",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 23,
        "dish": "Risotto with Seafood",
        "price": 39.6,
        "restaurant": {
            "restaurantid": 15,
            "name": "Deep Space Nine Cafe",
            "address": "3736 Gorczany Cliffs",
            "city": "Caraburgh",
            "state": "MN",
            "telephone": "1-610-848-0836",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 24,
        "dish": "Mushroom Risotto",
        "price": 79.52,
        "restaurant": {
            "restaurantid": 15,
            "name": "Deep Space Nine Cafe",
            "address": "3736 Gorczany Cliffs",
            "city": "Caraburgh",
            "state": "MN",
            "telephone": "1-610-848-0836",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 26,
        "dish": "Kebab",
        "price": 29.91,
        "restaurant": {
            "restaurantid": 25,
            "name": "Thalos VII Cafe",
            "address": "858 Rae Gardens",
            "city": "Lake Belle",
            "state": "WY",
            "telephone": "1-330-878-5120",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 27,
        "dish": "Risotto with Seafood",
        "price": 54.36,
        "restaurant": {
            "restaurantid": 25,
            "name": "Thalos VII Cafe",
            "address": "858 Rae Gardens",
            "city": "Lake Belle",
            "state": "WY",
            "telephone": "1-330-878-5120",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 28,
        "dish": "Peking Duck",
        "price": 43.23,
        "restaurant": {
            "restaurantid": 25,
            "name": "Thalos VII Cafe",
            "address": "858 Rae Gardens",
            "city": "Lake Belle",
            "state": "WY",
            "telephone": "1-330-878-5120",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 29,
        "dish": "Peking Duck",
        "price": 11.69,
        "restaurant": {
            "restaurantid": 25,
            "name": "Thalos VII Cafe",
            "address": "858 Rae Gardens",
            "city": "Lake Belle",
            "state": "WY",
            "telephone": "1-330-878-5120",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 30,
        "dish": "Seafood Paella",
        "price": 12.94,
        "restaurant": {
            "restaurantid": 25,
            "name": "Thalos VII Cafe",
            "address": "858 Rae Gardens",
            "city": "Lake Belle",
            "state": "WY",
            "telephone": "1-330-878-5120",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 31,
        "dish": "Linguine with Clams",
        "price": 43.21,
        "restaurant": {
            "restaurantid": 25,
            "name": "Thalos VII Cafe",
            "address": "858 Rae Gardens",
            "city": "Lake Belle",
            "state": "WY",
            "telephone": "1-330-878-5120",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 32,
        "dish": "Mushroom Risotto",
        "price": 17.78,
        "restaurant": {
            "restaurantid": 25,
            "name": "Thalos VII Cafe",
            "address": "858 Rae Gardens",
            "city": "Lake Belle",
            "state": "WY",
            "telephone": "1-330-878-5120",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 34,
        "dish": "Chicken Fajitas",
        "price": 49.31,
        "restaurant": {
            "restaurantid": 33,
            "name": "Delta Quadrant Cafe",
            "address": "715 Luisa Dam",
            "city": "New Curtis",
            "state": "MA",
            "telephone": "719.231.9311",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 35,
        "dish": "French Fries with Sausages",
        "price": 52.64,
        "restaurant": {
            "restaurantid": 33,
            "name": "Delta Quadrant Cafe",
            "address": "715 Luisa Dam",
            "city": "New Curtis",
            "state": "MA",
            "telephone": "719.231.9311",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 37,
        "dish": "Ebiten maki",
        "price": 31.57,
        "restaurant": {
            "restaurantid": 36,
            "name": "Risa Cafe",
            "address": "7237 Haag Dam",
            "city": "Louisborough",
            "state": "LA",
            "telephone": "267-703-3019",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 38,
        "dish": "Salmon Nigiri",
        "price": 18.48,
        "restaurant": {
            "restaurantid": 36,
            "name": "Risa Cafe",
            "address": "7237 Haag Dam",
            "city": "Louisborough",
            "state": "LA",
            "telephone": "267-703-3019",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 39,
        "dish": "Pork Belly Buns",
        "price": 67.35,
        "restaurant": {
            "restaurantid": 36,
            "name": "Risa Cafe",
            "address": "7237 Haag Dam",
            "city": "Louisborough",
            "state": "LA",
            "telephone": "267-703-3019",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 40,
        "dish": "Cheeseburger",
        "price": 28.56,
        "restaurant": {
            "restaurantid": 36,
            "name": "Risa Cafe",
            "address": "7237 Haag Dam",
            "city": "Louisborough",
            "state": "LA",
            "telephone": "267-703-3019",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 41,
        "dish": "Scotch Eggs",
        "price": 80.67,
        "restaurant": {
            "restaurantid": 36,
            "name": "Risa Cafe",
            "address": "7237 Haag Dam",
            "city": "Louisborough",
            "state": "LA",
            "telephone": "267-703-3019",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 42,
        "dish": "French Fries with Sausages",
        "price": 19.62,
        "restaurant": {
            "restaurantid": 36,
            "name": "Risa Cafe",
            "address": "7237 Haag Dam",
            "city": "Louisborough",
            "state": "LA",
            "telephone": "267-703-3019",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 43,
        "dish": "Teriyaki Chicken Donburi",
        "price": 37.74,
        "restaurant": {
            "restaurantid": 36,
            "name": "Risa Cafe",
            "address": "7237 Haag Dam",
            "city": "Louisborough",
            "state": "LA",
            "telephone": "267-703-3019",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 45,
        "dish": "Mushroom Risotto",
        "price": 34.85,
        "restaurant": {
            "restaurantid": 44,
            "name": "Khitomer Cafe",
            "address": "29342 Schiller Flat",
            "city": "Shanview",
            "state": "AK",
            "telephone": "401.225.0695",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 46,
        "dish": "Souvlaki",
        "price": 89.35,
        "restaurant": {
            "restaurantid": 44,
            "name": "Khitomer Cafe",
            "address": "29342 Schiller Flat",
            "city": "Shanview",
            "state": "AK",
            "telephone": "401.225.0695",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 47,
        "dish": "Tiramisù",
        "price": 66.68,
        "restaurant": {
            "restaurantid": 44,
            "name": "Khitomer Cafe",
            "address": "29342 Schiller Flat",
            "city": "Shanview",
            "state": "AK",
            "telephone": "401.225.0695",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 48,
        "dish": "Kebab",
        "price": 54.51,
        "restaurant": {
            "restaurantid": 44,
            "name": "Khitomer Cafe",
            "address": "29342 Schiller Flat",
            "city": "Shanview",
            "state": "AK",
            "telephone": "401.225.0695",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 50,
        "dish": "Salmon Nigiri",
        "price": 60.74,
        "restaurant": {
            "restaurantid": 49,
            "name": "Cardassia Cafe",
            "address": "0990 Vincenzo Underpass",
            "city": "South Eldonshire",
            "state": "NC",
            "telephone": "402-603-2528",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 51,
        "dish": "Chicken Fajitas",
        "price": 80.85,
        "restaurant": {
            "restaurantid": 49,
            "name": "Cardassia Cafe",
            "address": "0990 Vincenzo Underpass",
            "city": "South Eldonshire",
            "state": "NC",
            "telephone": "402-603-2528",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 53,
        "dish": "Ricotta Stuffed Ravioli",
        "price": 44.71,
        "restaurant": {
            "restaurantid": 52,
            "name": "Ferenginar Cafe",
            "address": "319 Emmy Square",
            "city": "Rolandoville",
            "state": "AR",
            "telephone": "(208) 708-6159",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 54,
        "dish": "Cheeseburger",
        "price": 22.23,
        "restaurant": {
            "restaurantid": 52,
            "name": "Ferenginar Cafe",
            "address": "319 Emmy Square",
            "city": "Rolandoville",
            "state": "AR",
            "telephone": "(208) 708-6159",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 55,
        "dish": "Barbecue Ribs",
        "price": 46.71,
        "restaurant": {
            "restaurantid": 52,
            "name": "Ferenginar Cafe",
            "address": "319 Emmy Square",
            "city": "Rolandoville",
            "state": "AR",
            "telephone": "(208) 708-6159",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 56,
        "dish": "Risotto with Seafood",
        "price": 39.2,
        "restaurant": {
            "restaurantid": 52,
            "name": "Ferenginar Cafe",
            "address": "319 Emmy Square",
            "city": "Rolandoville",
            "state": "AR",
            "telephone": "(208) 708-6159",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 57,
        "dish": "Pork Sausage Roll",
        "price": 14.38,
        "restaurant": {
            "restaurantid": 52,
            "name": "Ferenginar Cafe",
            "address": "319 Emmy Square",
            "city": "Rolandoville",
            "state": "AR",
            "telephone": "(208) 708-6159",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 59,
        "dish": "Tiramisù",
        "price": 4.13,
        "restaurant": {
            "restaurantid": 58,
            "name": "Trillius Prime Cafe",
            "address": "357 Cummings Expressway",
            "city": "Lake Collin",
            "state": "RI",
            "telephone": "1-231-404-5017",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 60,
        "dish": "Pho",
        "price": 50.32,
        "restaurant": {
            "restaurantid": 58,
            "name": "Trillius Prime Cafe",
            "address": "357 Cummings Expressway",
            "city": "Lake Collin",
            "state": "RI",
            "telephone": "1-231-404-5017",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 61,
        "dish": "Pasta Carbonara",
        "price": 37.34,
        "restaurant": {
            "restaurantid": 58,
            "name": "Trillius Prime Cafe",
            "address": "357 Cummings Expressway",
            "city": "Lake Collin",
            "state": "RI",
            "telephone": "1-231-404-5017",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 62,
        "dish": "Salmon Nigiri",
        "price": 13.08,
        "restaurant": {
            "restaurantid": 58,
            "name": "Trillius Prime Cafe",
            "address": "357 Cummings Expressway",
            "city": "Lake Collin",
            "state": "RI",
            "telephone": "1-231-404-5017",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 63,
        "dish": "Tacos",
        "price": 33.92,
        "restaurant": {
            "restaurantid": 58,
            "name": "Trillius Prime Cafe",
            "address": "357 Cummings Expressway",
            "city": "Lake Collin",
            "state": "RI",
            "telephone": "1-231-404-5017",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 64,
        "dish": "Pierogi",
        "price": 47.77,
        "restaurant": {
            "restaurantid": 58,
            "name": "Trillius Prime Cafe",
            "address": "357 Cummings Expressway",
            "city": "Lake Collin",
            "state": "RI",
            "telephone": "1-231-404-5017",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 65,
        "dish": "Tuna Sashimi",
        "price": 33.59,
        "restaurant": {
            "restaurantid": 58,
            "name": "Trillius Prime Cafe",
            "address": "357 Cummings Expressway",
            "city": "Lake Collin",
            "state": "RI",
            "telephone": "1-231-404-5017",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 67,
        "dish": "Cauliflower Penne",
        "price": 10.68,
        "restaurant": {
            "restaurantid": 66,
            "name": "Romulus Cafe",
            "address": "81526 Breitenberg Keys",
            "city": "Brauntown",
            "state": "OH",
            "telephone": "502-484-0540",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 68,
        "dish": "Chilli con Carne",
        "price": 16.6,
        "restaurant": {
            "restaurantid": 66,
            "name": "Romulus Cafe",
            "address": "81526 Breitenberg Keys",
            "city": "Brauntown",
            "state": "OH",
            "telephone": "502-484-0540",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 69,
        "dish": "Philadelphia Maki",
        "price": 24.89,
        "restaurant": {
            "restaurantid": 66,
            "name": "Romulus Cafe",
            "address": "81526 Breitenberg Keys",
            "city": "Brauntown",
            "state": "OH",
            "telephone": "502-484-0540",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 70,
        "dish": "Linguine with Clams",
        "price": 53.2,
        "restaurant": {
            "restaurantid": 66,
            "name": "Romulus Cafe",
            "address": "81526 Breitenberg Keys",
            "city": "Brauntown",
            "state": "OH",
            "telephone": "502-484-0540",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 71,
        "dish": "Som Tam",
        "price": 3.62,
        "restaurant": {
            "restaurantid": 66,
            "name": "Romulus Cafe",
            "address": "81526 Breitenberg Keys",
            "city": "Brauntown",
            "state": "OH",
            "telephone": "502-484-0540",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 72,
        "dish": "Som Tam",
        "price": 22.37,
        "restaurant": {
            "restaurantid": 66,
            "name": "Romulus Cafe",
            "address": "81526 Breitenberg Keys",
            "city": "Brauntown",
            "state": "OH",
            "telephone": "502-484-0540",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 73,
        "dish": "Fettuccine Alfredo",
        "price": 62.94,
        "restaurant": {
            "restaurantid": 66,
            "name": "Romulus Cafe",
            "address": "81526 Breitenberg Keys",
            "city": "Brauntown",
            "state": "OH",
            "telephone": "502-484-0540",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 74,
        "dish": "Pappardelle alla Bolognese",
        "price": 6.87,
        "restaurant": {
            "restaurantid": 66,
            "name": "Romulus Cafe",
            "address": "81526 Breitenberg Keys",
            "city": "Brauntown",
            "state": "OH",
            "telephone": "502-484-0540",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 75,
        "dish": "Barbecue Ribs",
        "price": 34.98,
        "restaurant": {
            "restaurantid": 66,
            "name": "Romulus Cafe",
            "address": "81526 Breitenberg Keys",
            "city": "Brauntown",
            "state": "OH",
            "telephone": "502-484-0540",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 77,
        "dish": "Ebiten maki",
        "price": 41.55,
        "restaurant": {
            "restaurantid": 76,
            "name": "Qo'noS Cafe",
            "address": "578 Schmitt Cliffs",
            "city": "Ramirotown",
            "state": "ME",
            "telephone": "410.636.4330",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 78,
        "dish": "Philadelphia Maki",
        "price": 72.82,
        "restaurant": {
            "restaurantid": 76,
            "name": "Qo'noS Cafe",
            "address": "578 Schmitt Cliffs",
            "city": "Ramirotown",
            "state": "ME",
            "telephone": "410.636.4330",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 79,
        "dish": "Lasagne",
        "price": 84.52,
        "restaurant": {
            "restaurantid": 76,
            "name": "Qo'noS Cafe",
            "address": "578 Schmitt Cliffs",
            "city": "Ramirotown",
            "state": "ME",
            "telephone": "410.636.4330",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 80,
        "dish": "Pasta and Beans",
        "price": 84.8,
        "restaurant": {
            "restaurantid": 76,
            "name": "Qo'noS Cafe",
            "address": "578 Schmitt Cliffs",
            "city": "Ramirotown",
            "state": "ME",
            "telephone": "410.636.4330",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 81,
        "dish": "Pork Belly Buns",
        "price": 73.36,
        "restaurant": {
            "restaurantid": 76,
            "name": "Qo'noS Cafe",
            "address": "578 Schmitt Cliffs",
            "city": "Ramirotown",
            "state": "ME",
            "telephone": "410.636.4330",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 83,
        "dish": "French Toast",
        "price": 32.36,
        "restaurant": {
            "restaurantid": 82,
            "name": "Beta Quadrant Cafe",
            "address": "5207 Mills Brooks",
            "city": "Huelside",
            "state": "NJ",
            "telephone": "(269) 305-9226",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 84,
        "dish": "Pasta and Beans",
        "price": 74.29,
        "restaurant": {
            "restaurantid": 82,
            "name": "Beta Quadrant Cafe",
            "address": "5207 Mills Brooks",
            "city": "Huelside",
            "state": "NJ",
            "telephone": "(269) 305-9226",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 86,
        "dish": "Fish and Chips",
        "price": 34.44,
        "restaurant": {
            "restaurantid": 85,
            "name": "The Briar Patch Cafe",
            "address": "07333 Jessi Grove",
            "city": "Herbertland",
            "state": "TN",
            "telephone": "1-805-815-7534",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 87,
        "dish": "Pasta and Beans",
        "price": 17.6,
        "restaurant": {
            "restaurantid": 85,
            "name": "The Briar Patch Cafe",
            "address": "07333 Jessi Grove",
            "city": "Herbertland",
            "state": "TN",
            "telephone": "1-805-815-7534",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 88,
        "dish": "Philadelphia Maki",
        "price": 18.43,
        "restaurant": {
            "restaurantid": 85,
            "name": "The Briar Patch Cafe",
            "address": "07333 Jessi Grove",
            "city": "Herbertland",
            "state": "TN",
            "telephone": "1-805-815-7534",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 89,
        "dish": "Cheeseburger",
        "price": 45.97,
        "restaurant": {
            "restaurantid": 85,
            "name": "The Briar Patch Cafe",
            "address": "07333 Jessi Grove",
            "city": "Herbertland",
            "state": "TN",
            "telephone": "1-805-815-7534",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 90,
        "dish": "Poutine",
        "price": 29.0,
        "restaurant": {
            "restaurantid": 85,
            "name": "The Briar Patch Cafe",
            "address": "07333 Jessi Grove",
            "city": "Herbertland",
            "state": "TN",
            "telephone": "1-805-815-7534",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 91,
        "dish": "Scotch Eggs",
        "price": 82.17,
        "restaurant": {
            "restaurantid": 85,
            "name": "The Briar Patch Cafe",
            "address": "07333 Jessi Grove",
            "city": "Herbertland",
            "state": "TN",
            "telephone": "1-805-815-7534",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 92,
        "dish": "Tuna Sashimi",
        "price": 77.83,
        "restaurant": {
            "restaurantid": 85,
            "name": "The Briar Patch Cafe",
            "address": "07333 Jessi Grove",
            "city": "Herbertland",
            "state": "TN",
            "telephone": "1-805-815-7534",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 93,
        "dish": "Tiramisù",
        "price": 32.94,
        "restaurant": {
            "restaurantid": 85,
            "name": "The Briar Patch Cafe",
            "address": "07333 Jessi Grove",
            "city": "Herbertland",
            "state": "TN",
            "telephone": "1-805-815-7534",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 94,
        "dish": "Philadelphia Maki",
        "price": 53.52,
        "restaurant": {
            "restaurantid": 85,
            "name": "The Briar Patch Cafe",
            "address": "07333 Jessi Grove",
            "city": "Herbertland",
            "state": "TN",
            "telephone": "1-805-815-7534",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 96,
        "dish": "Poke",
        "price": 82.38,
        "restaurant": {
            "restaurantid": 95,
            "name": "Wolf 359 Cafe",
            "address": "48181 Pablo Crescent",
            "city": "Carrollbury",
            "state": "MO",
            "telephone": "619.312.9787",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 97,
        "dish": "Tiramisù",
        "price": 75.8,
        "restaurant": {
            "restaurantid": 95,
            "name": "Wolf 359 Cafe",
            "address": "48181 Pablo Crescent",
            "city": "Carrollbury",
            "state": "MO",
            "telephone": "619.312.9787",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 99,
        "dish": "Poutine",
        "price": 76.19,
        "restaurant": {
            "restaurantid": 98,
            "name": "Alpha Quadrant Cafe",
            "address": "5960 Zana Fords",
            "city": "Dortheaborough",
            "state": "AZ",
            "telephone": "551-937-7501",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 100,
        "dish": "Tiramisù",
        "price": 50.87,
        "restaurant": {
            "restaurantid": 98,
            "name": "Alpha Quadrant Cafe",
            "address": "5960 Zana Fords",
            "city": "Dortheaborough",
            "state": "AZ",
            "telephone": "551-937-7501",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 101,
        "dish": "Salmon Nigiri",
        "price": 46.73,
        "restaurant": {
            "restaurantid": 98,
            "name": "Alpha Quadrant Cafe",
            "address": "5960 Zana Fords",
            "city": "Dortheaborough",
            "state": "AZ",
            "telephone": "551-937-7501",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 102,
        "dish": "Poutine",
        "price": 10.65,
        "restaurant": {
            "restaurantid": 98,
            "name": "Alpha Quadrant Cafe",
            "address": "5960 Zana Fords",
            "city": "Dortheaborough",
            "state": "AZ",
            "telephone": "551-937-7501",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 103,
        "dish": "French Toast",
        "price": 56.1,
        "restaurant": {
            "restaurantid": 98,
            "name": "Alpha Quadrant Cafe",
            "address": "5960 Zana Fords",
            "city": "Dortheaborough",
            "state": "AZ",
            "telephone": "551-937-7501",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 104,
        "dish": "Vegetable Soup",
        "price": 26.36,
        "restaurant": {
            "restaurantid": 98,
            "name": "Alpha Quadrant Cafe",
            "address": "5960 Zana Fords",
            "city": "Dortheaborough",
            "state": "AZ",
            "telephone": "551-937-7501",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 105,
        "dish": "Teriyaki Chicken Donburi",
        "price": 73.25,
        "restaurant": {
            "restaurantid": 98,
            "name": "Alpha Quadrant Cafe",
            "address": "5960 Zana Fords",
            "city": "Dortheaborough",
            "state": "AZ",
            "telephone": "551-937-7501",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 106,
        "dish": "Ebiten maki",
        "price": 9.87,
        "restaurant": {
            "restaurantid": 98,
            "name": "Alpha Quadrant Cafe",
            "address": "5960 Zana Fords",
            "city": "Dortheaborough",
            "state": "AZ",
            "telephone": "551-937-7501",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 107,
        "dish": "Arepas",
        "price": 77.07,
        "restaurant": {
            "restaurantid": 98,
            "name": "Alpha Quadrant Cafe",
            "address": "5960 Zana Fords",
            "city": "Dortheaborough",
            "state": "AZ",
            "telephone": "551-937-7501",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 109,
        "dish": "French Toast",
        "price": 50.77,
        "restaurant": {
            "restaurantid": 108,
            "name": "Vulcan Cafe",
            "address": "04423 Jill Run",
            "city": "Shirleyhaven",
            "state": "KY",
            "telephone": "803-317-0633",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 110,
        "dish": "Tacos",
        "price": 54.88,
        "restaurant": {
            "restaurantid": 108,
            "name": "Vulcan Cafe",
            "address": "04423 Jill Run",
            "city": "Shirleyhaven",
            "state": "KY",
            "telephone": "803-317-0633",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 111,
        "dish": "Risotto with Seafood",
        "price": 7.03,
        "restaurant": {
            "restaurantid": 108,
            "name": "Vulcan Cafe",
            "address": "04423 Jill Run",
            "city": "Shirleyhaven",
            "state": "KY",
            "telephone": "803-317-0633",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 112,
        "dish": "Caesar Salad",
        "price": 35.08,
        "restaurant": {
            "restaurantid": 108,
            "name": "Vulcan Cafe",
            "address": "04423 Jill Run",
            "city": "Shirleyhaven",
            "state": "KY",
            "telephone": "803-317-0633",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 113,
        "dish": "Tiramisù",
        "price": 76.54,
        "restaurant": {
            "restaurantid": 108,
            "name": "Vulcan Cafe",
            "address": "04423 Jill Run",
            "city": "Shirleyhaven",
            "state": "KY",
            "telephone": "803-317-0633",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 114,
        "dish": "Sushi",
        "price": 55.71,
        "restaurant": {
            "restaurantid": 108,
            "name": "Vulcan Cafe",
            "address": "04423 Jill Run",
            "city": "Shirleyhaven",
            "state": "KY",
            "telephone": "803-317-0633",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 115,
        "dish": "Hummus",
        "price": 38.94,
        "restaurant": {
            "restaurantid": 108,
            "name": "Vulcan Cafe",
            "address": "04423 Jill Run",
            "city": "Shirleyhaven",
            "state": "KY",
            "telephone": "803-317-0633",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 116,
        "dish": "Barbecue Ribs",
        "price": 65.38,
        "restaurant": {
            "restaurantid": 108,
            "name": "Vulcan Cafe",
            "address": "04423 Jill Run",
            "city": "Shirleyhaven",
            "state": "KY",
            "telephone": "803-317-0633",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 117,
        "dish": "Pasta with Tomato and Basil",
        "price": 1.13,
        "restaurant": {
            "restaurantid": 108,
            "name": "Vulcan Cafe",
            "address": "04423 Jill Run",
            "city": "Shirleyhaven",
            "state": "KY",
            "telephone": "803-317-0633",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 119,
        "dish": "Fettuccine Alfredo",
        "price": 89.87,
        "restaurant": {
            "restaurantid": 118,
            "name": "Gamma Quadrant Cafe",
            "address": "37806 Dona Streets",
            "city": "West Wiley",
            "state": "AZ",
            "telephone": "717.435.7758",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 120,
        "dish": "Bunny Chow",
        "price": 31.69,
        "restaurant": {
            "restaurantid": 118,
            "name": "Gamma Quadrant Cafe",
            "address": "37806 Dona Streets",
            "city": "West Wiley",
            "state": "AZ",
            "telephone": "717.435.7758",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 121,
        "dish": "Pasta and Beans",
        "price": 16.56,
        "restaurant": {
            "restaurantid": 118,
            "name": "Gamma Quadrant Cafe",
            "address": "37806 Dona Streets",
            "city": "West Wiley",
            "state": "AZ",
            "telephone": "717.435.7758",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 122,
        "dish": "Fettuccine Alfredo",
        "price": 43.86,
        "restaurant": {
            "restaurantid": 118,
            "name": "Gamma Quadrant Cafe",
            "address": "37806 Dona Streets",
            "city": "West Wiley",
            "state": "AZ",
            "telephone": "717.435.7758",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 123,
        "dish": "Pizza",
        "price": 59.96,
        "restaurant": {
            "restaurantid": 118,
            "name": "Gamma Quadrant Cafe",
            "address": "37806 Dona Streets",
            "city": "West Wiley",
            "state": "AZ",
            "telephone": "717.435.7758",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 124,
        "dish": "French Toast",
        "price": 56.71,
        "restaurant": {
            "restaurantid": 118,
            "name": "Gamma Quadrant Cafe",
            "address": "37806 Dona Streets",
            "city": "West Wiley",
            "state": "AZ",
            "telephone": "717.435.7758",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 125,
        "dish": "Barbecue Ribs",
        "price": 80.2,
        "restaurant": {
            "restaurantid": 118,
            "name": "Gamma Quadrant Cafe",
            "address": "37806 Dona Streets",
            "city": "West Wiley",
            "state": "AZ",
            "telephone": "717.435.7758",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 126,
        "dish": "Hummus",
        "price": 77.72,
        "restaurant": {
            "restaurantid": 118,
            "name": "Gamma Quadrant Cafe",
            "address": "37806 Dona Streets",
            "city": "West Wiley",
            "state": "AZ",
            "telephone": "717.435.7758",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 127,
        "dish": "Bunny Chow",
        "price": 60.11,
        "restaurant": {
            "restaurantid": 118,
            "name": "Gamma Quadrant Cafe",
            "address": "37806 Dona Streets",
            "city": "West Wiley",
            "state": "AZ",
            "telephone": "717.435.7758",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 128,
        "dish": "Chilli con Carne",
        "price": 87.6,
        "restaurant": {
            "restaurantid": 118,
            "name": "Gamma Quadrant Cafe",
            "address": "37806 Dona Streets",
            "city": "West Wiley",
            "state": "AZ",
            "telephone": "717.435.7758",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 130,
        "dish": "Stinky Tofu",
        "price": 21.93,
        "restaurant": {
            "restaurantid": 129,
            "name": "Tau Ceti Prime Cafe",
            "address": "4963 Lind Shores",
            "city": "Hackettberg",
            "state": "AZ",
            "telephone": "786.404.0498",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 131,
        "dish": "Risotto with Seafood",
        "price": 63.0,
        "restaurant": {
            "restaurantid": 129,
            "name": "Tau Ceti Prime Cafe",
            "address": "4963 Lind Shores",
            "city": "Hackettberg",
            "state": "AZ",
            "telephone": "786.404.0498",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 132,
        "dish": "Chicken Milanese",
        "price": 39.02,
        "restaurant": {
            "restaurantid": 129,
            "name": "Tau Ceti Prime Cafe",
            "address": "4963 Lind Shores",
            "city": "Hackettberg",
            "state": "AZ",
            "telephone": "786.404.0498",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 134,
        "dish": "Teriyaki Chicken Donburi",
        "price": 59.51,
        "restaurant": {
            "restaurantid": 133,
            "name": "Bajor Cafe",
            "address": "65755 Howell Drive",
            "city": "Florinebury",
            "state": "MS",
            "telephone": "(870) 406-5856",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 135,
        "dish": "Risotto with Seafood",
        "price": 62.86,
        "restaurant": {
            "restaurantid": 133,
            "name": "Bajor Cafe",
            "address": "65755 Howell Drive",
            "city": "Florinebury",
            "state": "MS",
            "telephone": "(870) 406-5856",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 136,
        "dish": "Meatballs with Sauce",
        "price": 57.91,
        "restaurant": {
            "restaurantid": 133,
            "name": "Bajor Cafe",
            "address": "65755 Howell Drive",
            "city": "Florinebury",
            "state": "MS",
            "telephone": "(870) 406-5856",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 137,
        "dish": "Salmon Nigiri",
        "price": 61.97,
        "restaurant": {
            "restaurantid": 133,
            "name": "Bajor Cafe",
            "address": "65755 Howell Drive",
            "city": "Florinebury",
            "state": "MS",
            "telephone": "(870) 406-5856",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 139,
        "dish": "Vegetable Soup",
        "price": 37.64,
        "restaurant": {
            "restaurantid": 138,
            "name": "Neutral Zone Cafe",
            "address": "4510 Rogelio Forges",
            "city": "Cliftonstad",
            "state": "SD",
            "telephone": "832.352.6138",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 140,
        "dish": "Fish and Chips",
        "price": 13.95,
        "restaurant": {
            "restaurantid": 138,
            "name": "Neutral Zone Cafe",
            "address": "4510 Rogelio Forges",
            "city": "Cliftonstad",
            "state": "SD",
            "telephone": "832.352.6138",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 141,
        "dish": "Teriyaki Chicken Donburi",
        "price": 20.63,
        "restaurant": {
            "restaurantid": 138,
            "name": "Neutral Zone Cafe",
            "address": "4510 Rogelio Forges",
            "city": "Cliftonstad",
            "state": "SD",
            "telephone": "832.352.6138",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 143,
        "dish": "Vegetable Soup",
        "price": 9.25,
        "restaurant": {
            "restaurantid": 142,
            "name": "Betazed Cafe",
            "address": "76688 Vella Squares",
            "city": "Caylatown",
            "state": "TX",
            "telephone": "(315) 419-6180",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 144,
        "dish": "Seafood Paella",
        "price": 83.88,
        "restaurant": {
            "restaurantid": 142,
            "name": "Betazed Cafe",
            "address": "76688 Vella Squares",
            "city": "Caylatown",
            "state": "TX",
            "telephone": "(315) 419-6180",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 145,
        "dish": "Teriyaki Chicken Donburi",
        "price": 14.8,
        "restaurant": {
            "restaurantid": 142,
            "name": "Betazed Cafe",
            "address": "76688 Vella Squares",
            "city": "Caylatown",
            "state": "TX",
            "telephone": "(315) 419-6180",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 146,
        "dish": "Peking Duck",
        "price": 3.08,
        "restaurant": {
            "restaurantid": 142,
            "name": "Betazed Cafe",
            "address": "76688 Vella Squares",
            "city": "Caylatown",
            "state": "TX",
            "telephone": "(315) 419-6180",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 147,
        "dish": "Fish and Chips",
        "price": 5.65,
        "restaurant": {
            "restaurantid": 142,
            "name": "Betazed Cafe",
            "address": "76688 Vella Squares",
            "city": "Caylatown",
            "state": "TX",
            "telephone": "(315) 419-6180",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 148,
        "dish": "Scotch Eggs",
        "price": 80.34,
        "restaurant": {
            "restaurantid": 142,
            "name": "Betazed Cafe",
            "address": "76688 Vella Squares",
            "city": "Caylatown",
            "state": "TX",
            "telephone": "(315) 419-6180",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 150,
        "dish": "Massaman Curry",
        "price": 44.54,
        "restaurant": {
            "restaurantid": 149,
            "name": "Badlands Cafe",
            "address": "564 Juli Key",
            "city": "Bartellberg",
            "state": "TX",
            "telephone": "321.423.3356",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 151,
        "dish": "Som Tam",
        "price": 35.67,
        "restaurant": {
            "restaurantid": 149,
            "name": "Badlands Cafe",
            "address": "564 Juli Key",
            "city": "Bartellberg",
            "state": "TX",
            "telephone": "321.423.3356",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 152,
        "dish": "Chicken Wings",
        "price": 75.74,
        "restaurant": {
            "restaurantid": 149,
            "name": "Badlands Cafe",
            "address": "564 Juli Key",
            "city": "Bartellberg",
            "state": "TX",
            "telephone": "321.423.3356",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 153,
        "dish": "Arepas",
        "price": 82.8,
        "restaurant": {
            "restaurantid": 149,
            "name": "Badlands Cafe",
            "address": "564 Juli Key",
            "city": "Bartellberg",
            "state": "TX",
            "telephone": "321.423.3356",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 154,
        "dish": "Mushroom Risotto",
        "price": 4.84,
        "restaurant": {
            "restaurantid": 149,
            "name": "Badlands Cafe",
            "address": "564 Juli Key",
            "city": "Bartellberg",
            "state": "TX",
            "telephone": "321.423.3356",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 155,
        "dish": "Pho",
        "price": 76.96,
        "restaurant": {
            "restaurantid": 149,
            "name": "Badlands Cafe",
            "address": "564 Juli Key",
            "city": "Bartellberg",
            "state": "TX",
            "telephone": "321.423.3356",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 156,
        "dish": "Pho",
        "price": 89.8,
        "restaurant": {
            "restaurantid": 149,
            "name": "Badlands Cafe",
            "address": "564 Juli Key",
            "city": "Bartellberg",
            "state": "TX",
            "telephone": "321.423.3356",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 157,
        "dish": "Poutine",
        "price": 87.99,
        "restaurant": {
            "restaurantid": 149,
            "name": "Badlands Cafe",
            "address": "564 Juli Key",
            "city": "Bartellberg",
            "state": "TX",
            "telephone": "321.423.3356",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 158,
        "dish": "Salmon Nigiri",
        "price": 13.59,
        "restaurant": {
            "restaurantid": 149,
            "name": "Badlands Cafe",
            "address": "564 Juli Key",
            "city": "Bartellberg",
            "state": "TX",
            "telephone": "321.423.3356",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    },
    {
        "menuid": 159,
        "dish": "French Fries with Sausages",
        "price": 12.02,
        "restaurant": {
            "restaurantid": 149,
            "name": "Badlands Cafe",
            "address": "564 Juli Key",
            "city": "Bartellberg",
            "state": "TX",
            "telephone": "321.423.3356",
            "seatcapacity": 74,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                }
            ]
        }
    }
]
```

</details>

<details>
<summary>http://localhost:2019/restaurants/restaurants</summary>

```JSON
[
    {
        "restaurantid": 4,
        "name": "Apple",
        "address": "123 Main Street",
        "city": "City",
        "state": "ST",
        "telephone": "555-555-1234",
        "seatcapacity": 15,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            },
            {
                "paymentid": 2,
                "type": "Credit Card"
            },
            {
                "paymentid": 3,
                "type": "Mobile Pay"
            }
        ],
        "menus": [
            {
                "menuid": 5,
                "dish": "Mac and Cheese",
                "price": 6.95
            },
            {
                "menuid": 6,
                "dish": "Lasagna",
                "price": 8.5
            },
            {
                "menuid": 7,
                "dish": "Meatloaf",
                "price": 7.77
            },
            {
                "menuid": 8,
                "dish": "Tacos",
                "price": 8.49
            },
            {
                "menuid": 9,
                "dish": "Chef Salad",
                "price": 12.5
            }
        ]
    },
    {
        "restaurantid": 10,
        "name": "Eagle Cafe",
        "address": "321 Uptown Drive",
        "city": "Town",
        "state": "ST",
        "telephone": "555-555-5555",
        "seatcapacity": 25,
        "payments": [
            {
                "paymentid": 3,
                "type": "Mobile Pay"
            }
        ],
        "menus": [
            {
                "menuid": 11,
                "dish": "Tacos",
                "price": 10.49
            },
            {
                "menuid": 12,
                "dish": "Barbacoa",
                "price": 12.75
            }
        ]
    },
    {
        "restaurantid": 13,
        "name": "Number 1 Eats",
        "address": "565 Side Avenue",
        "city": "Village",
        "state": "ST",
        "telephone": "555-123-1555",
        "seatcapacity": 110,
        "payments": [
            {
                "paymentid": 2,
                "type": "Credit Card"
            },
            {
                "paymentid": 3,
                "type": "Mobile Pay"
            }
        ],
        "menus": [
            {
                "menuid": 14,
                "dish": "Pizza",
                "price": 15.15
            }
        ]
    },
    {
        "restaurantid": 15,
        "name": "Deep Space Nine Cafe",
        "address": "3736 Gorczany Cliffs",
        "city": "Caraburgh",
        "state": "MN",
        "telephone": "1-610-848-0836",
        "seatcapacity": 74,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            }
        ],
        "menus": [
            {
                "menuid": 16,
                "dish": "Kebab",
                "price": 62.01
            },
            {
                "menuid": 17,
                "dish": "French Fries with Sausages",
                "price": 65.18
            },
            {
                "menuid": 18,
                "dish": "Fettuccine Alfredo",
                "price": 25.59
            },
            {
                "menuid": 19,
                "dish": "Pasta and Beans",
                "price": 73.92
            },
            {
                "menuid": 20,
                "dish": "Stinky Tofu",
                "price": 68.82
            },
            {
                "menuid": 21,
                "dish": "Bunny Chow",
                "price": 19.14
            },
            {
                "menuid": 22,
                "dish": "Pork Belly Buns",
                "price": 25.5
            },
            {
                "menuid": 23,
                "dish": "Risotto with Seafood",
                "price": 39.6
            },
            {
                "menuid": 24,
                "dish": "Mushroom Risotto",
                "price": 79.52
            }
        ]
    },
    {
        "restaurantid": 25,
        "name": "Thalos VII Cafe",
        "address": "858 Rae Gardens",
        "city": "Lake Belle",
        "state": "WY",
        "telephone": "1-330-878-5120",
        "seatcapacity": 74,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            }
        ],
        "menus": [
            {
                "menuid": 26,
                "dish": "Kebab",
                "price": 29.91
            },
            {
                "menuid": 27,
                "dish": "Risotto with Seafood",
                "price": 54.36
            },
            {
                "menuid": 28,
                "dish": "Peking Duck",
                "price": 43.23
            },
            {
                "menuid": 29,
                "dish": "Peking Duck",
                "price": 11.69
            },
            {
                "menuid": 30,
                "dish": "Seafood Paella",
                "price": 12.94
            },
            {
                "menuid": 31,
                "dish": "Linguine with Clams",
                "price": 43.21
            },
            {
                "menuid": 32,
                "dish": "Mushroom Risotto",
                "price": 17.78
            }
        ]
    },
    {
        "restaurantid": 33,
        "name": "Delta Quadrant Cafe",
        "address": "715 Luisa Dam",
        "city": "New Curtis",
        "state": "MA",
        "telephone": "719.231.9311",
        "seatcapacity": 74,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            }
        ],
        "menus": [
            {
                "menuid": 34,
                "dish": "Chicken Fajitas",
                "price": 49.31
            },
            {
                "menuid": 35,
                "dish": "French Fries with Sausages",
                "price": 52.64
            }
        ]
    },
    {
        "restaurantid": 36,
        "name": "Risa Cafe",
        "address": "7237 Haag Dam",
        "city": "Louisborough",
        "state": "LA",
        "telephone": "267-703-3019",
        "seatcapacity": 74,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            }
        ],
        "menus": [
            {
                "menuid": 37,
                "dish": "Ebiten maki",
                "price": 31.57
            },
            {
                "menuid": 38,
                "dish": "Salmon Nigiri",
                "price": 18.48
            },
            {
                "menuid": 39,
                "dish": "Pork Belly Buns",
                "price": 67.35
            },
            {
                "menuid": 40,
                "dish": "Cheeseburger",
                "price": 28.56
            },
            {
                "menuid": 41,
                "dish": "Scotch Eggs",
                "price": 80.67
            },
            {
                "menuid": 42,
                "dish": "French Fries with Sausages",
                "price": 19.62
            },
            {
                "menuid": 43,
                "dish": "Teriyaki Chicken Donburi",
                "price": 37.74
            }
        ]
    },
    {
        "restaurantid": 44,
        "name": "Khitomer Cafe",
        "address": "29342 Schiller Flat",
        "city": "Shanview",
        "state": "AK",
        "telephone": "401.225.0695",
        "seatcapacity": 74,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            }
        ],
        "menus": [
            {
                "menuid": 45,
                "dish": "Mushroom Risotto",
                "price": 34.85
            },
            {
                "menuid": 46,
                "dish": "Souvlaki",
                "price": 89.35
            },
            {
                "menuid": 47,
                "dish": "Tiramisù",
                "price": 66.68
            },
            {
                "menuid": 48,
                "dish": "Kebab",
                "price": 54.51
            }
        ]
    },
    {
        "restaurantid": 49,
        "name": "Cardassia Cafe",
        "address": "0990 Vincenzo Underpass",
        "city": "South Eldonshire",
        "state": "NC",
        "telephone": "402-603-2528",
        "seatcapacity": 74,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            }
        ],
        "menus": [
            {
                "menuid": 50,
                "dish": "Salmon Nigiri",
                "price": 60.74
            },
            {
                "menuid": 51,
                "dish": "Chicken Fajitas",
                "price": 80.85
            }
        ]
    },
    {
        "restaurantid": 52,
        "name": "Ferenginar Cafe",
        "address": "319 Emmy Square",
        "city": "Rolandoville",
        "state": "AR",
        "telephone": "(208) 708-6159",
        "seatcapacity": 74,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            }
        ],
        "menus": [
            {
                "menuid": 53,
                "dish": "Ricotta Stuffed Ravioli",
                "price": 44.71
            },
            {
                "menuid": 54,
                "dish": "Cheeseburger",
                "price": 22.23
            },
            {
                "menuid": 55,
                "dish": "Barbecue Ribs",
                "price": 46.71
            },
            {
                "menuid": 56,
                "dish": "Risotto with Seafood",
                "price": 39.2
            },
            {
                "menuid": 57,
                "dish": "Pork Sausage Roll",
                "price": 14.38
            }
        ]
    },
    {
        "restaurantid": 58,
        "name": "Trillius Prime Cafe",
        "address": "357 Cummings Expressway",
        "city": "Lake Collin",
        "state": "RI",
        "telephone": "1-231-404-5017",
        "seatcapacity": 74,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            }
        ],
        "menus": [
            {
                "menuid": 59,
                "dish": "Tiramisù",
                "price": 4.13
            },
            {
                "menuid": 60,
                "dish": "Pho",
                "price": 50.32
            },
            {
                "menuid": 61,
                "dish": "Pasta Carbonara",
                "price": 37.34
            },
            {
                "menuid": 62,
                "dish": "Salmon Nigiri",
                "price": 13.08
            },
            {
                "menuid": 63,
                "dish": "Tacos",
                "price": 33.92
            },
            {
                "menuid": 64,
                "dish": "Pierogi",
                "price": 47.77
            },
            {
                "menuid": 65,
                "dish": "Tuna Sashimi",
                "price": 33.59
            }
        ]
    },
    {
        "restaurantid": 66,
        "name": "Romulus Cafe",
        "address": "81526 Breitenberg Keys",
        "city": "Brauntown",
        "state": "OH",
        "telephone": "502-484-0540",
        "seatcapacity": 74,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            }
        ],
        "menus": [
            {
                "menuid": 67,
                "dish": "Cauliflower Penne",
                "price": 10.68
            },
            {
                "menuid": 68,
                "dish": "Chilli con Carne",
                "price": 16.6
            },
            {
                "menuid": 69,
                "dish": "Philadelphia Maki",
                "price": 24.89
            },
            {
                "menuid": 70,
                "dish": "Linguine with Clams",
                "price": 53.2
            },
            {
                "menuid": 71,
                "dish": "Som Tam",
                "price": 3.62
            },
            {
                "menuid": 72,
                "dish": "Som Tam",
                "price": 22.37
            },
            {
                "menuid": 73,
                "dish": "Fettuccine Alfredo",
                "price": 62.94
            },
            {
                "menuid": 74,
                "dish": "Pappardelle alla Bolognese",
                "price": 6.87
            },
            {
                "menuid": 75,
                "dish": "Barbecue Ribs",
                "price": 34.98
            }
        ]
    },
    {
        "restaurantid": 76,
        "name": "Qo'noS Cafe",
        "address": "578 Schmitt Cliffs",
        "city": "Ramirotown",
        "state": "ME",
        "telephone": "410.636.4330",
        "seatcapacity": 74,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            }
        ],
        "menus": [
            {
                "menuid": 77,
                "dish": "Ebiten maki",
                "price": 41.55
            },
            {
                "menuid": 78,
                "dish": "Philadelphia Maki",
                "price": 72.82
            },
            {
                "menuid": 79,
                "dish": "Lasagne",
                "price": 84.52
            },
            {
                "menuid": 80,
                "dish": "Pasta and Beans",
                "price": 84.8
            },
            {
                "menuid": 81,
                "dish": "Pork Belly Buns",
                "price": 73.36
            }
        ]
    },
    {
        "restaurantid": 82,
        "name": "Beta Quadrant Cafe",
        "address": "5207 Mills Brooks",
        "city": "Huelside",
        "state": "NJ",
        "telephone": "(269) 305-9226",
        "seatcapacity": 74,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            }
        ],
        "menus": [
            {
                "menuid": 83,
                "dish": "French Toast",
                "price": 32.36
            },
            {
                "menuid": 84,
                "dish": "Pasta and Beans",
                "price": 74.29
            }
        ]
    },
    {
        "restaurantid": 85,
        "name": "The Briar Patch Cafe",
        "address": "07333 Jessi Grove",
        "city": "Herbertland",
        "state": "TN",
        "telephone": "1-805-815-7534",
        "seatcapacity": 74,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            }
        ],
        "menus": [
            {
                "menuid": 86,
                "dish": "Fish and Chips",
                "price": 34.44
            },
            {
                "menuid": 87,
                "dish": "Pasta and Beans",
                "price": 17.6
            },
            {
                "menuid": 88,
                "dish": "Philadelphia Maki",
                "price": 18.43
            },
            {
                "menuid": 89,
                "dish": "Cheeseburger",
                "price": 45.97
            },
            {
                "menuid": 90,
                "dish": "Poutine",
                "price": 29.0
            },
            {
                "menuid": 91,
                "dish": "Scotch Eggs",
                "price": 82.17
            },
            {
                "menuid": 92,
                "dish": "Tuna Sashimi",
                "price": 77.83
            },
            {
                "menuid": 93,
                "dish": "Tiramisù",
                "price": 32.94
            },
            {
                "menuid": 94,
                "dish": "Philadelphia Maki",
                "price": 53.52
            }
        ]
    },
    {
        "restaurantid": 95,
        "name": "Wolf 359 Cafe",
        "address": "48181 Pablo Crescent",
        "city": "Carrollbury",
        "state": "MO",
        "telephone": "619.312.9787",
        "seatcapacity": 74,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            }
        ],
        "menus": [
            {
                "menuid": 96,
                "dish": "Poke",
                "price": 82.38
            },
            {
                "menuid": 97,
                "dish": "Tiramisù",
                "price": 75.8
            }
        ]
    },
    {
        "restaurantid": 98,
        "name": "Alpha Quadrant Cafe",
        "address": "5960 Zana Fords",
        "city": "Dortheaborough",
        "state": "AZ",
        "telephone": "551-937-7501",
        "seatcapacity": 74,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            }
        ],
        "menus": [
            {
                "menuid": 99,
                "dish": "Poutine",
                "price": 76.19
            },
            {
                "menuid": 100,
                "dish": "Tiramisù",
                "price": 50.87
            },
            {
                "menuid": 101,
                "dish": "Salmon Nigiri",
                "price": 46.73
            },
            {
                "menuid": 102,
                "dish": "Poutine",
                "price": 10.65
            },
            {
                "menuid": 103,
                "dish": "French Toast",
                "price": 56.1
            },
            {
                "menuid": 104,
                "dish": "Vegetable Soup",
                "price": 26.36
            },
            {
                "menuid": 105,
                "dish": "Teriyaki Chicken Donburi",
                "price": 73.25
            },
            {
                "menuid": 106,
                "dish": "Ebiten maki",
                "price": 9.87
            },
            {
                "menuid": 107,
                "dish": "Arepas",
                "price": 77.07
            }
        ]
    },
    {
        "restaurantid": 108,
        "name": "Vulcan Cafe",
        "address": "04423 Jill Run",
        "city": "Shirleyhaven",
        "state": "KY",
        "telephone": "803-317-0633",
        "seatcapacity": 74,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            }
        ],
        "menus": [
            {
                "menuid": 109,
                "dish": "French Toast",
                "price": 50.77
            },
            {
                "menuid": 110,
                "dish": "Tacos",
                "price": 54.88
            },
            {
                "menuid": 111,
                "dish": "Risotto with Seafood",
                "price": 7.03
            },
            {
                "menuid": 112,
                "dish": "Caesar Salad",
                "price": 35.08
            },
            {
                "menuid": 113,
                "dish": "Tiramisù",
                "price": 76.54
            },
            {
                "menuid": 114,
                "dish": "Sushi",
                "price": 55.71
            },
            {
                "menuid": 115,
                "dish": "Hummus",
                "price": 38.94
            },
            {
                "menuid": 116,
                "dish": "Barbecue Ribs",
                "price": 65.38
            },
            {
                "menuid": 117,
                "dish": "Pasta with Tomato and Basil",
                "price": 1.13
            }
        ]
    },
    {
        "restaurantid": 118,
        "name": "Gamma Quadrant Cafe",
        "address": "37806 Dona Streets",
        "city": "West Wiley",
        "state": "AZ",
        "telephone": "717.435.7758",
        "seatcapacity": 74,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            }
        ],
        "menus": [
            {
                "menuid": 119,
                "dish": "Fettuccine Alfredo",
                "price": 89.87
            },
            {
                "menuid": 120,
                "dish": "Bunny Chow",
                "price": 31.69
            },
            {
                "menuid": 121,
                "dish": "Pasta and Beans",
                "price": 16.56
            },
            {
                "menuid": 122,
                "dish": "Fettuccine Alfredo",
                "price": 43.86
            },
            {
                "menuid": 123,
                "dish": "Pizza",
                "price": 59.96
            },
            {
                "menuid": 124,
                "dish": "French Toast",
                "price": 56.71
            },
            {
                "menuid": 125,
                "dish": "Barbecue Ribs",
                "price": 80.2
            },
            {
                "menuid": 126,
                "dish": "Hummus",
                "price": 77.72
            },
            {
                "menuid": 127,
                "dish": "Bunny Chow",
                "price": 60.11
            },
            {
                "menuid": 128,
                "dish": "Chilli con Carne",
                "price": 87.6
            }
        ]
    },
    {
        "restaurantid": 129,
        "name": "Tau Ceti Prime Cafe",
        "address": "4963 Lind Shores",
        "city": "Hackettberg",
        "state": "AZ",
        "telephone": "786.404.0498",
        "seatcapacity": 74,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            }
        ],
        "menus": [
            {
                "menuid": 130,
                "dish": "Stinky Tofu",
                "price": 21.93
            },
            {
                "menuid": 131,
                "dish": "Risotto with Seafood",
                "price": 63.0
            },
            {
                "menuid": 132,
                "dish": "Chicken Milanese",
                "price": 39.02
            }
        ]
    },
    {
        "restaurantid": 133,
        "name": "Bajor Cafe",
        "address": "65755 Howell Drive",
        "city": "Florinebury",
        "state": "MS",
        "telephone": "(870) 406-5856",
        "seatcapacity": 74,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            }
        ],
        "menus": [
            {
                "menuid": 134,
                "dish": "Teriyaki Chicken Donburi",
                "price": 59.51
            },
            {
                "menuid": 135,
                "dish": "Risotto with Seafood",
                "price": 62.86
            },
            {
                "menuid": 136,
                "dish": "Meatballs with Sauce",
                "price": 57.91
            },
            {
                "menuid": 137,
                "dish": "Salmon Nigiri",
                "price": 61.97
            }
        ]
    },
    {
        "restaurantid": 138,
        "name": "Neutral Zone Cafe",
        "address": "4510 Rogelio Forges",
        "city": "Cliftonstad",
        "state": "SD",
        "telephone": "832.352.6138",
        "seatcapacity": 74,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            }
        ],
        "menus": [
            {
                "menuid": 139,
                "dish": "Vegetable Soup",
                "price": 37.64
            },
            {
                "menuid": 140,
                "dish": "Fish and Chips",
                "price": 13.95
            },
            {
                "menuid": 141,
                "dish": "Teriyaki Chicken Donburi",
                "price": 20.63
            }
        ]
    },
    {
        "restaurantid": 142,
        "name": "Betazed Cafe",
        "address": "76688 Vella Squares",
        "city": "Caylatown",
        "state": "TX",
        "telephone": "(315) 419-6180",
        "seatcapacity": 74,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            }
        ],
        "menus": [
            {
                "menuid": 143,
                "dish": "Vegetable Soup",
                "price": 9.25
            },
            {
                "menuid": 144,
                "dish": "Seafood Paella",
                "price": 83.88
            },
            {
                "menuid": 145,
                "dish": "Teriyaki Chicken Donburi",
                "price": 14.8
            },
            {
                "menuid": 146,
                "dish": "Peking Duck",
                "price": 3.08
            },
            {
                "menuid": 147,
                "dish": "Fish and Chips",
                "price": 5.65
            },
            {
                "menuid": 148,
                "dish": "Scotch Eggs",
                "price": 80.34
            }
        ]
    },
    {
        "restaurantid": 149,
        "name": "Badlands Cafe",
        "address": "564 Juli Key",
        "city": "Bartellberg",
        "state": "TX",
        "telephone": "321.423.3356",
        "seatcapacity": 74,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            }
        ],
        "menus": [
            {
                "menuid": 150,
                "dish": "Massaman Curry",
                "price": 44.54
            },
            {
                "menuid": 151,
                "dish": "Som Tam",
                "price": 35.67
            },
            {
                "menuid": 152,
                "dish": "Chicken Wings",
                "price": 75.74
            },
            {
                "menuid": 153,
                "dish": "Arepas",
                "price": 82.8
            },
            {
                "menuid": 154,
                "dish": "Mushroom Risotto",
                "price": 4.84
            },
            {
                "menuid": 155,
                "dish": "Pho",
                "price": 76.96
            },
            {
                "menuid": 156,
                "dish": "Pho",
                "price": 89.8
            },
            {
                "menuid": 157,
                "dish": "Poutine",
                "price": 87.99
            },
            {
                "menuid": 158,
                "dish": "Salmon Nigiri",
                "price": 13.59
            },
            {
                "menuid": 159,
                "dish": "French Fries with Sausages",
                "price": 12.02
            }
        ]
    }
]
```

</details>

<details>
<summary>http://localhost:2019/restaurants/restaurant/4</summary>

```JSON
{
    "restaurantid": 4,
    "name": "Apple",
    "address": "123 Main Street",
    "city": "City",
    "state": "ST",
    "telephone": "555-555-1234",
    "seatcapacity": 15,
    "payments": [
        {
            "paymentid": 1,
            "type": "Cash"
        },
        {
            "paymentid": 2,
            "type": "Credit Card"
        },
        {
            "paymentid": 3,
            "type": "Mobile Pay"
        }
    ],
    "menus": [
        {
            "menuid": 5,
            "dish": "Mac and Cheese",
            "price": 6.95
        },
        {
            "menuid": 6,
            "dish": "Lasagna",
            "price": 8.5
        },
        {
            "menuid": 7,
            "dish": "Meatloaf",
            "price": 7.77
        },
        {
            "menuid": 8,
            "dish": "Tacos",
            "price": 8.49
        },
        {
            "menuid": 9,
            "dish": "Chef Salad",
            "price": 12.5
        }
    ]
}
```

</details>
<details>
<summary>http://localhost:2019/restaurants/restaurant/77</summary>

```JSON
{
    "timestamp": "2020-03-16T22:09:18.197+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Restaurant 77 Not Found",
    "trace": "javax.persistence.EntityNotFoundException: Restaurant 77 Not Found\n\tat com.lambdaschool.crudyrestaurants.services.RestaurantServiceImpl.lambda$findRestaurantById$0(RestaurantServiceImpl.java:59)\n\tat java.base/java.util.Optional.orElseThrow(Optional.java:408)\n\tat com.lambdaschool.crudyrestaurants.services.RestaurantServiceImpl.findRestaurantById(RestaurantServiceImpl.java:59)\n\tat com.lambdaschool.crudyrestaurants.services.RestaurantServiceImpl$$FastClassBySpringCGLIB$$d47a1bf5.invoke(<generated>)\n\tat org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)\n\tat org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:769)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\n\tat org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\n\tat org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:353)\n\tat org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:99)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\n\tat org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\n\tat org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:689)\n\tat com.lambdaschool.crudyrestaurants.services.RestaurantServiceImpl$$EnhancerBySpringCGLIB$$72197e70.findRestaurantById(<generated>)\n\tat com.lambdaschool.crudyrestaurants.controllers.RestaurantController.getRestaurantById(RestaurantController.java:60)\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:566)\n\tat org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)\n\tat org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)\n\tat org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:888)\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)\n\tat org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\n\tat org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)\n\tat org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)\n\tat org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)\n\tat org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)\n\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:634)\n\tat org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)\n\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:741)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)\n\tat org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96)\n\tat org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:526)\n\tat org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:139)\n\tat org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)\n\tat org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\n\tat org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)\n\tat org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:408)\n\tat org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:66)\n\tat org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:861)\n\tat org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1579)\n\tat org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\n\tat java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)\n\tat java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)\n\tat org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\n\tat java.base/java.lang.Thread.run(Thread.java:834)\n",
    "path": "/restaurants/restaurant/77"
}
```

</details>

<details>
<summary>http://localhost:2019/restaurants/restaurant/name/Eagle%20Cafe</summary>

```JSON
{
    "restaurantid": 10,
    "name": "Eagle Cafe",
    "address": "321 Uptown Drive",
    "city": "Town",
    "state": "ST",
    "telephone": "555-555-5555",
    "seatcapacity": 25,
    "payments": [
        {
            "paymentid": 3,
            "type": "Mobile Pay"
        }
    ],
    "menus": [
        {
            "menuid": 11,
            "dish": "Tacos",
            "price": 10.49
        },
        {
            "menuid": 12,
            "dish": "Barbacoa",
            "price": 12.75
        }
    ]
}
```

</details>

<details>
<summary>http://localhost:2019/restaurants/restaurant/state/st</summary>

```JSON
[
    {
        "restaurantid": 4,
        "name": "Apple",
        "address": "123 Main Street",
        "city": "City",
        "state": "ST",
        "telephone": "555-555-1234",
        "seatcapacity": 15,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            },
            {
                "paymentid": 2,
                "type": "Credit Card"
            },
            {
                "paymentid": 3,
                "type": "Mobile Pay"
            }
        ],
        "menus": [
            {
                "menuid": 5,
                "dish": "Mac and Cheese",
                "price": 6.95
            },
            {
                "menuid": 6,
                "dish": "Lasagna",
                "price": 8.5
            },
            {
                "menuid": 7,
                "dish": "Meatloaf",
                "price": 7.77
            },
            {
                "menuid": 8,
                "dish": "Tacos",
                "price": 8.49
            },
            {
                "menuid": 9,
                "dish": "Chef Salad",
                "price": 12.5
            }
        ]
    },
    {
        "restaurantid": 10,
        "name": "Eagle Cafe",
        "address": "321 Uptown Drive",
        "city": "Town",
        "state": "ST",
        "telephone": "555-555-5555",
        "seatcapacity": 25,
        "payments": [
            {
                "paymentid": 3,
                "type": "Mobile Pay"
            }
        ],
        "menus": [
            {
                "menuid": 11,
                "dish": "Tacos",
                "price": 10.49
            },
            {
                "menuid": 12,
                "dish": "Barbacoa",
                "price": 12.75
            }
        ]
    },
    {
        "restaurantid": 13,
        "name": "Number 1 Eats",
        "address": "565 Side Avenue",
        "city": "Village",
        "state": "ST",
        "telephone": "555-123-1555",
        "seatcapacity": 110,
        "payments": [
            {
                "paymentid": 2,
                "type": "Credit Card"
            },
            {
                "paymentid": 3,
                "type": "Mobile Pay"
            }
        ],
        "menus": [
            {
                "menuid": 14,
                "dish": "Pizza",
                "price": 15.15
            }
        ]
    }
]
```

</details>

<details>
<summary>http://localhost:2019/restaurants/restaurant/state/zz</summary>

```JSON
[]
```

</details>

<details>
<summary>http://localhost:2019/restaurants/restaurant/likename/eat</summary>

```JSON
[
    {
        "restaurantid": 13,
        "name": "Number 1 Eats",
        "address": "565 Side Avenue",
        "city": "Village",
        "state": "ST",
        "telephone": "555-123-1555",
        "seatcapacity": 110,
        "payments": [
            {
                "paymentid": 2,
                "type": "Credit Card"
            },
            {
                "paymentid": 3,
                "type": "Mobile Pay"
            }
        ],
        "menus": [
            {
                "menuid": 14,
                "dish": "Pizza",
                "price": 15.15
            }
        ]
    }
]
```

</details>

___

<details>
<summary>POST http://localhost:2019/restaurants/restaurant</summary>

DATA

```JSON
{
    "name": "Good Eats",
    "address": "123 Main Avenue",
    "city": "Uptown",
    "state": "ST",
    "telephone": "555-777-7777",
    "menus": [
        {
            "dish": "Soda",
            "price": 3.50
        },
        {
            "dish": "Latte",
            "price": 5.00
        }
    ],
    "payments": [
        {
            "paymentid":2
        },
        {
            "paymentid":3
        }
    ]
}
```

OUTPUT

```TEXT
No Body Text

Location Header: http://localhost:2019/restaurants/restaurant/160
Status 201 Created
```

</details>

<details>
<summary>PUT http://localhost:2019/restaurants/restaurant/13</summary>

DATA

```JSON
{
    "name": "Java's New Restaurant",
    "address": "565 Side Avenue",
    "city": "Village",
    "state": "ZZ",
    "telephone": "555-123-4321",
    "seatcapacity": 25,
    "menus": [
        {
            "dish": "Sandwich",
            "price": 15.15
        },
        {
            "dish": "Hot Dish",
            "price": 17.17
        }
    ],
    "payments": [
        {
            "paymentid":1
        }
    ]
}
```

OUTPUT

```TEXT
No Body Data

Status OK
```

</details>

</details>

<details>
<summary>PATCH http://localhost:2019/restaurants/restaurant/10</summary>

DATA

```JSON
{
    "telephone" : "555-555-1234",
    "seatcapacity" : 152,
    "payments": [
        {
            "paymentid":1
        }
    ]
}
```

OUTPUT

```JSON
No Body Data

Status OK
```

</details>

<details>
<summary>DELETE http://localhost:2019/restaurants/restaurant/4</summary>

```TEXT
No Body Data

Status OK
```

</details>
