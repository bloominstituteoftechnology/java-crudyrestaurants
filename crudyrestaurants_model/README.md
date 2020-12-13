# Java Reading CRUDy Restaurants The Model

A student that completes this project shows that they can:

* Perform CRUD operations on an RDBMS using JPA and Hibernate (reading)
* Implement seed data using SQL statements
* Explain and use Spring Data Relationships
* Use the JsonIgnoreProperties annotation to prevent infinite loops
* Use JPA constructs to create advanced queries

## Introduction

This is a basic database scheme with restaurants, menus, payment system. This Java Spring REST API application will provide endpoints for clients to read various data sets contained in the application's data. In this application all the seed data and table modeling has been added.

### Database layout

The table layouts are as follows

* Restaurant is the driving table.
* Menus have a Many-To-One relationship with Restaurant. Each Restaurant has many menus. Each menu has only one Restaurant.
* Payments have a Many-To-Many relationship with Restaurants.

![Image of Database Layout](../java-crudyrestaurant-read-db.png)
