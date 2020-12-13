#### Entry Ticket

Please take a moment to reflect on what you have previously learned and hope to learn by completing this Google Survey. Remember your responses will be read by your instructor to help guide future lessons.

* [Guided Project Entry Ticket](https://forms.gle/4cJNaTvjpxEhFacb7)

#### Daily Resources

* No Guided Project Starter - built from scratch
* [Slido](https://app.sli.do/event/XXXXXXXX)
* [Zoom like](https://lambdaschool.zoom.us/j/#########)

#### Slack Message

@channel
Let's do this! The Java Class will be starting in 3 minutes at (https://lambdaschool.zoom.us/j/#########)
Please post questions to the Slido link at (https://app.sli.do/event/XXXXXXXX)

### Introduction and Hook

Backend API systems all work very similarly. The main difference between them is the data they process. Reading that data is an important process

Reading means extracting the requested data from the database and returning that data in a standard JSON format. The frontend client is responsible for nicely displaying the data to the users.

The Backend systems we develop be stand alone meaning that different frontend clients should be able to access our backend systems and expect the same results. Thus you can read Facebook posts from your a phone app, from a web browser, from a smart speaker, among other fontend systems.

### Purpose

Develop a system to read data from a database.

### Learning Activities

* Inside of IntelliJ, run the final version of the application.
* Inside of Postman, Surf to each endpoint and show the output.
  * [Predicted Output](https://github.com/LambdaSchool/java-crudyrestaurants/tree/master/crudyrestaurants_read)
  * http://localhost:2019/menus/menus
  * http://localhost:2019/restaurants/restaurants
  * http://localhost:2019/restaurants/restaurant/3
  * http://localhost:2019/restaurants/restaurant/77
  * http://localhost:2019/restaurants/restaurant/name/Eagle%20Cafe
  * http://localhost:2019/restaurants/restaurant/state/st
  * http://localhost:2019/restaurants/restaurant/state/zz
  * http://localhost:2019/restaurants/restaurant/likename/eat
* Close the application in IntelliJ.
* Create a new application in IntelliJ.

![Click on Create a Project](https://lambdaschool.github.io/java-curriculum-assets/Sprint%2011%20-%20Java%20with%20RDBMS%20and%20API%20Intros/Module%202%20-%20JX%20Java%20-%20Read%20Data%20using%20CRUD%20Operations%20including%20Seeding%20Data/assets/JX-SP11-M2-01.png)

* Follow the wizard to create the application.
  * Create a project with the Spring Frame.

![Select Spring Framework](https://lambdaschool.github.io/java-curriculum-assets/Sprint%2011%20-%20Java%20with%20RDBMS%20and%20API%20Intros/Module%202%20-%20JX%20Java%20-%20Read%20Data%20using%20CRUD%20Operations%20including%20Seeding%20Data/assets/JX-SP11-M2-02.png)

  * Name the project, picking the correct version of the JDK

![Select Name with Version 11](https://lambdaschool.github.io/java-curriculum-assets/Sprint%2011%20-%20Java%20with%20RDBMS%20and%20API%20Intros/Module%202%20-%20JX%20Java%20-%20Read%20Data%20using%20CRUD%20Operations%20including%20Seeding%20Data/assets/JX-SP11-M2-03.png)

  * Add the appropriate dependencies: Spring Boot DevTools, Spring Web, Spring Data JPA, H2 Database

![Add dependencies](https://lambdaschool.github.io/java-curriculum-assets/Sprint%2011%20-%20Java%20with%20RDBMS%20and%20API%20Intros/Module%202%20-%20JX%20Java%20-%20Read%20Data%20using%20CRUD%20Operations%20including%20Seeding%20Data/assets/JX-SP11-M2-04.png)

  * Name the project file
  * Note: jxwork is the folder where all guided project is stored for this cohort.

![Name the project file](https://lambdaschool.github.io/java-curriculum-assets/Sprint%2011%20-%20Java%20with%20RDBMS%20and%20API%20Intros/Module%202%20-%20JX%20Java%20-%20Read%20Data%20using%20CRUD%20Operations%20including%20Seeding%20Data/assets/JX-SP11-M2-05.png)

* If a popup appears asking, select to make this a Maven Project.

* IF a popup appears asking, select to autoimport Maven dependencies.

* In the `POM.XML` file, comment out the scope for H2 -
  * this is needed to configure H2 database console and make H2 available in IntelliJ. We need H2 not only at runtime but also at compile time.
  * Create the package structure.

* Add the lines to the `application.properties`. Add the comments as well.
  
#### Working with the Objective: Perform CRUD operations on an RDBMS using JPA and Hibernate (reading)

* Under the package crudyrestaurants, create the following subpackages
  * `config` - Contains all the classes related to configurations. Nothing will be added here today
  * `controller` - Contains the access points, endpoints, that can be used by clients.
  * `models` - Contains the layouts of all data used in the application. This included persistent data that is saved to a database, and non-persistent data used only during application execution.
  * `repositories` - Contains the links between the database and the application. Typically contains one class for each persistent, database, model.
  * `services` - Contains the services that are used to retrieve and manipulate data in the application. Contains the contract stating what each client can do with the data in the application. The majority of the work of the application resides in this package.

* Start with models (do not add `JsonIgnoreProperties` (except for `hasvalueseatcapacity` field) yet)
  * Create the Restaurant model with the fields
    * restaurantid
    * name
    * address
    * city
    * state
    * telephone
    * seatcapacity
    * hasvalueforseatcapacity
      * Remember to add this as @JsonIgnoreProperties before the class header
      * Explain this will be used tomorrow
  
  * Create the menu model with the fields
    * menuid
    * dish
    * price
    * Do note that a restaurant can have duplicate menu entries. To prevent this would require implementation of custom queries which is beyond the scope of this module.
  
  * create the payment model with the fields
    * paymentid
    * type

#### Working with the objective: Explain and use Spring Data Relationships

  * Now generate the relations among the models. FetchType.LAZY is used to have data fetched from the database just when it is needed.
  * This is not possible with ManyToMany as a join table is created and must contain all of the data.
  * Hibernate Fetch strategies are not covered in depth in the unit. See Additional Resources for further explanations.
  
    * In the Restaurant model, create the ManyToMany relation from Restaurant to Payment
    * In the Payment model, create the ManyToMany relation from Payment to Restaurant
    * In the Restaurant model, create the OneToMany relation from Restaurant to Menu
    * In the Menu model, create the ManyToOne relation from Restaurant to Menu

  * [Check for Understanding CFU - Google Form](https://forms.gle/6NUKdMm67Pr9x9TS8)

#### Back to Working with the Objective: Perform CRUD operations on an RDBMS using JPA and Hibernate (reading)

  * Generate constructors
    * This is done via the context menu in IntelliJ
    * Each class gets a default constructor - used by the JPA
    * Each class gets its own constructor with parameters to be used by seeding data, and within the application outside of the JPA

  * Generate Getters and Setters
    * This is done via the context menu in IntelliJ
    * Created for all fields - we need a setter for primary keys in seeding data
    * In the Restaurant model, add the `hasvalueforseatcapacity` in the setter for `seatcapacity` fields. This will be used tomorrow.

* Move to the repositories
  * Inside of RestaurantRepository emphasize the creation of the JPA Queries `findByName`, `findByStateIgnoringCase`, `findByNameContainingIgnoringCase`

* Move to the services
  * Create the interface `RestaurantService`
    * This is the contract between our application and our clients. This is what the clients are allowed to do with our data.
    * We will implement the interface later.

* Move to the controllers
  * Create the controller for Restaurants

* Move back to the services
  * Create the class `RestaurantServiceImp`
  * Have this class implement `RestaurantService`
  * Set this class as a service
  * Generate from the IntelliJ context the override methods to implement
  * implement the methods

* [Check for Understanding CFU - Google Form](https://forms.gle/3fBvsJkPznCtBy9K7)

#### Working with the objective: Implement seed data using SQL statements

* Add the `data.sql` file. The file must be named `data.sql` and put in the `resources` folder for Spring Boot to recognize the file.

* Point out that to turn off seeding with `data.sql`,
  * In `application.properties`, set `spring.datasource.initialization-mode=never`

* Run the program and surf to the endpoint `http://localhost:2019/restaurants/restaurants`.

* [Check for Understanding CFU - Google Form](https://forms.gle/CHaZHVtqH896bUxN7)

#### Working with the objective: Use the JsonIgnoreProperties annotation to prevent infinite loops

* It will fail due to being in an infinite loop of access Restaurant, then Menu, then Restaurant, then Menu...
* Go back and add JsonIgnoreProperties
  * `Menu` in the ManyToOne relationship
  * `Payment` in the ManyToMany relationship
  * `Restaurant` in the ManyToMany relationship
  * `Restaurant` in the OneToMany relationship
* Run the program and surf to the endpoint `http://localhost:2019/restaurants/restaurants`.

* [Check for Understanding CFU - Google Forms](https://forms.gle/AfWENZbbq9h7Bufv7)

#### Objectives If Time Allows

##### Working with the objective: Use JPA constructs to create advanced queries

* Show the error message you get with adding `Restaurant findByRestaurantName(String name);` to the `RestaurantRepository`

* [Check for Understanding CFU - Google Forms](https://forms.gle/aD66cduDMAkmmVEDA)

* At least show the final guided project solution to show students who to create multiple controllers and supporting code.

* Follow the steps to work with the menu table
  * Services - Interface `MenuService`
  * Controllers - `MenuController`
  * Services - Interface Implementation `MenuServiceImpl`

#### Conclusion

##### Review what we just learned

* How to create a Java Spring Application.
* How to layout a Java Spring Application.
* How to create read endpoints for a REST API.
* How to seed data
  * Using SQL

##### How is this related to tomorrow's topic

* Starting with this as the base project for tomorrow. We do not have to recreate the models and such!
* We have done the R (read) in CRUD. Tomorrow we add the CUD (create, update, delete)!

### Exit Ticket

Please take a moment to reflect on what you have learned in today's Guided Project. Remember your response will be read by your instructor to help guide future lessons.

* [Guided Project Exit Ticket](https://forms.gle/nGErjznhbc81wY7w6)
