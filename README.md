# Java Reading CRUDy Restaurants

A student that completes this project shows that they can:

* Perform CRUD operations on an RDBMS using JPA and Hibernate (reading)
* Implement a data seeding class using JPA and Hibernate
* Explain and use Spring Data Relationships
* Use the JsonIgnoreProperties annotation to prevent infinite loops
* Use H2 Console and H2 IntelliJ integration to explore data

## Introduction

This is a basic database scheme with restaurants, menus, payment system. This Java Spring REST API application will provide endpoints for clients to read various data sets contained in the applications data.

Using the provided seed data, a successful application will return the follow data based on the given endpoint. Expand the section of the endpoint to see the data that is returned.

### Database layout

The table layouts are as follows

* Restaurant is the driving table.
* Menus have a Many-To-One relationship with Restaurant. Each Restaurant has many menus. Each menu has only one Restaurant.
* Payments have a Many-To-Many relationship with Restaurants.

![Image of Database Layout](java-crudyrestaurant-read-db.png)

Two different applications exist

- crudyrestaurants_read - Includes only reading data
- crudyrestaurants_delete_save_update - Finishes the CRUD application by adding Creating, Updating, and Deleting
