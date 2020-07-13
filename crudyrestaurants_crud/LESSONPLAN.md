### Entry Ticket

Please take a moment to reflect on what you have previously learned and hope to learn by completing this Google Survey. Remember your responses will be read by your instructor to help guide future lessons.

* [Guided Project Entry Ticket](https://forms.gle/mww9yMHPGiXdMsXV6)

#### Daily Resources

* [Guided Project Starter](https://github.com/LambdaSchool/java-crudyrestaurants/tree/master/crudyrestaurants_read)
* [Slido](https://app.sli.do/event/XXXXXXXX)
* [Zoom like](https://lambdaschool.zoom.us/j/#########)

#### Slack Message

@channel
For the Java class today, you can either begin with your guided project from yesterday or get my copy. My copy is the crudyrestaurants_read application found in the repo (https://github.com/LambdaSchool/java-crudyrestaurants.git).
The Java Class will be starting in 3 minutes at (https://lambdaschool.zoom.us/j/#########)
Please post questions to the Slido link at (https://app.sli.do/event/XXXXXXXX)

### Introduction and Hook

Continuing our project from yesterday, we can read data, but how do we add, maintain that data? Let's keep learning.

### Purpose

Develop a full CRUD application. Develop a full application where we can create (add) data, read that data, change (update) the data, and delete (remove) unwanted data.

### Learning Activities

* Inside of IntelliJ, run the final version of the application.
* Inside Postman, run each endpoint with the provided data and so the output.
  * [Click here for predicted output and sample data to use for demonstration](https://github.com/LambdaSchool/java-crudyrestaurants/tree/master/crudyrestaurants_detele_save_update)
  * POST http://localhost:2019/restaurants/restaurant
  * PUT http://localhost:2019/restaurants/restaurant/13
  * PUT http://localhost:2019/restaurants/restaurant/777
  * PATCH http://localhost:2019/restaurants/restaurant/798
  * PATCH http://localhost:2019/restaurants/restaurant/10
  * DELETE http://localhost:2019/restaurants/restaurant/4
  * DELETE http://localhost:2019/restaurants/restaurant/4444
* Close the application in IntelliJ
* Open the java-crudyrestaurant/crudyrestaurant_read application and begin from there.

#### Working with the objective: CRUD Creating and Replacing Data

* Remember that you can use the Compare With on a folder (from the context menu) to see all the difference. Worth taking a look before class. And is useful to have open if you have the screen space!

Start with the Restaurant Controller and work back through the Restaurant Service, Restaurant Service Implementation. The Restaurant Repository and Model are mostly done.

Add the POST method Header:

```JAVA
    @PostMapping(value = "/restaurant",
        consumes = {"application/json"})
    public ResponseEntity<?> addNewRestaurant(
        @Valid
        @RequestBody
            Restaurant newRestaurant)
    {
```

* POST is for adding a new restaurant. Adapted from POSTing a new message to a forum.
* POST reads data from the RequestBody. We validate this data using @Valid.
  * Jackson Dependencies added by Spring Boot converts the JSON to our Java Object

Add the call to save the data

```JAVA
        // ids are not recognized by the Post method
        newRestaurant.setRestaurantid(0);
        newRestaurant = restaurantService.save(newRestaurant);
```

Set the location header for the newly created resource

```JAVA
        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();

        URI newRestaurantURI = ServletUriComponentsBuilder.fromCurrentRequest() // get the URI for this request
            .path("/{restaurantid}") // add to it a path variable
            .buildAndExpand(newRestaurant.getRestaurantid()) // populate that path variable with the newly created restaurant id
            .toUri(); // covert that work into a human readable URI
        responseHeaders.setLocation(newRestaurantURI); // in the header, set the location header to that URI
```

Return that header and a status of CREATED

```JAVA
        return new ResponseEntity<>(null,
            responseHeaders,
            HttpStatus.CREATED);
    }
```

Now enter the method header for save in RestaurantService interface

```JAVA
<... other code ...>
    Restaurant save(Restaurant restaurant);
<... other code ...>
```

Enter the save method in RestaurantService Implementation. Notice we leave out the find restaurant by id section for now.

```JAVA
<... other code ...>
    @Transactional
    @Override
    public Restaurant save(Restaurant restaurant)
    {
        Restaurant newRestaurant = new Restaurant();

        newRestaurant.setName(restaurant.getName());
        newRestaurant.setAddress(restaurant.getAddress());
        newRestaurant.setCity(restaurant.getCity());
        newRestaurant.setState(restaurant.getState());
        newRestaurant.setTelephone(restaurant.getTelephone());
        newRestaurant.setSeatcapacity(restaurant.getSeatcapacity());

        newRestaurant.getPayments()
            .clear();
        for (Payment p : restaurant.getPayments())
        {
            Payment newPay = paymentService.findPaymentById(p.getPaymentid());

            newRestaurant.addPayment(newPay);
        }

        newRestaurant.getMenus()
            .clear();
        for (Menu m : restaurant.getMenus())
        {
            Menu newMenu = new Menu(m.getDish(),
                m.getPrice(),
                newRestaurant);

            newRestaurant.getMenus()
                .add(newMenu);
        }

        return restrepos.save(newRestaurant);
<... other code ...>
```

Notice the save method requires the PaymentService class so autowire it in

```JAVA
<... other code ...>
    @Autowired
    private PaymentService paymentService;
<... other code ...>
```

In PaymentService, we need access to findPaymentById (save is added for the SeedData class) so add to the PaymentService interface

```JAVA
<... other code ...>
    Payment findPaymentById(long id);
<... other code ...>
```

And finally add the code to PaymentService Implementation

```JAVA
<... other code ...>
    @Override
    public Payment findPaymentById(long id)
    {
        return paymentrepos.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Payment " + id + " Not Found"));
    }
<... other code ...>
```

Now add the PUT method to the RestaurantController

Now add the find restaurant by id section to the save method giving a final save method of

```JAVA
    @Transactional
    @Override
    public Restaurant save(Restaurant restaurant)
    {
        Restaurant newRestaurant = new Restaurant();

        if (restaurant.getRestaurantid() != 0)
        {
            restrepos.findById(restaurant.getRestaurantid())
                .orElseThrow(() -> new EntityNotFoundException("Restaurant " + restaurant.getRestaurantid() + " Not Found"));

            newRestaurant.setRestaurantid(restaurant.getRestaurantid());
        }

        newRestaurant.setName(restaurant.getName());
        newRestaurant.setAddress(restaurant.getAddress());
        newRestaurant.setCity(restaurant.getCity());
        newRestaurant.setState(restaurant.getState());
        newRestaurant.setTelephone(restaurant.getTelephone());
        newRestaurant.setSeatcapacity(restaurant.getSeatcapacity());

        newRestaurant.getPayments()
            .clear();
        for (Payment p : restaurant.getPayments())
        {
            Payment newPay = paymentService.findPaymentById(p.getPaymentid());

            newRestaurant.addPayment(newPay);
        }

        newRestaurant.getMenus()
            .clear();
        for (Menu m : restaurant.getMenus())
        {
            Menu newMenu = new Menu(m.getDish(),
                m.getPrice(),
                newRestaurant);

            newRestaurant.getMenus()
                .add(newMenu);
        }

        return restrepos.save(newRestaurant);
    }
```

* [Check for Understanding CFU - Google Form](https://forms.gle/gqZE1auPdx6Fs5HDA)

#### use Postman to manually test Web APIs with all CRUD operations

* [Check for Understanding CFU - Google Form](https://forms.gle/huQqfCuGSNehZk3c8)

#### Working with the objective: Understand and implement @Transactional annotation

* [Check for Understanding CFU - Google Form](https://forms.gle/qwDv4ERDweYzpL787)

#### Working with the objective: CRUD Partially Updating Data

Add hasvalueforseatcapacity to Restaurant Model including the JsonIgnoreProperties annotation

Add the PATCH method to the RestaurantController

Add Update to the RestaurantService Interface

Add Update to the RestaurantService Implementation.

* [Check for Understanding CFU - Google Form](https://forms.gle/NPDe7pAwYkRFkX9n9)

#### Working with the objective: CRUD Deleting Data

Add the DELETE method to the RestaurantController

Add Delete to the RestaurantService Interface

Add Delete to the RestaurantService Implementation

* [Check for Understanding CFU - Google Form](https://forms.gle/1FNpsPr5v62NMJ3t9)

#### Working with the objective: Data Seeding using Java Spring

Add the Java class SeedData.java to the main package of the application.

* The main package is the package where the main method is located
* Add the code unrelated to Javafaker.
  * No random value needed.
  * Stop on the comment // using Javafaker
* Stress how you comment out `@Component` annotation to keep this seed data from being added to the database.

* [Check for Understanding CFU - Google Form](https://forms.gle/ggpXt5mFNuSPjoLo6)

#### Objectives If Time Allows

#### Working with the objective: Mass Data Seeding

First add the required dependency to the POM file

```XML
        <!-- https://mvnrepository.com/artifact/com.github.javafaker/javafaker -->
        <dependency>
            <groupId>com.github.javafaker</groupId>
            <artifactId>javafaker</artifactId>
            <version>1.0.1</version>
        </dependency>
```

Add the lines related to Javafaker found in SeedData including the random value!

* [Check for Understanding - Google Form](https://forms.gle/eniPU9eXpjWgA9YQ7)

#### Working with the objective: Use H2 Console and H2 IntelliJ integration to explore data

* Time Permitting, show how to access the H2 database
  * These configurations should be added to the `application.properties` file

```TEXT
# Configurations useful for working with H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

Add this class in `config` package

```JAVA
package com.lambdaschool.sampleemps.config;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 * Configures H2 access through the JetBrains IntelliJ IDEA IDE.
 *
 * Adapted from https://techdev.io/en/developer-blog/querying-the-embedded-h2-database-of-a-spring-boot-application
 * necessary for using the database tool built into intellij
 */
@Configuration
public class H2ServerConfiguration
{

    /**
     * TCP port for remote connections, default 9092.
     */
    @Value("${h2.tcp.port:9092}")
    private String h2TcpPort;

    /**
     * Web port, default 8082.
     */
    @Value("${h2.web.port:8082}")
    private String h2WebPort;

    /**
     * TCP connection to connect with SQL clients to the embedded h2 database.
     * <p>
     * Connect to "jdbc:h2:tcp://localhost:9092/mem:testdb", username "sa", password empty.
     *
     * @return The created TcpServer needed to access H2.
     * @throws SQLException If the server cannot be created.
     */
    @Bean
    @ConditionalOnExpression("${h2.tcp.enabled:true}")
    public Server h2TcpServer() throws SQLException
    {
        return Server.createTcpServer("-tcp",
                                      "-tcpAllowOthers",
                                      "-tcpPort",
                                      h2TcpPort)
                     .start();
    }

    /**
     * Web console for the embedded h2 database.
     * <p>
     * Go to http://localhost:8082 and connect to the database "jdbc:h2:mem:testdb", username "sa", password empty.
     *
     * @return The created web server needed to access H2.
     * @throws SQLException If the server cannot be created.
     */
    @Bean
    @ConditionalOnExpression("${h2.web.enabled:true}")
    public Server h2WebServer() throws SQLException
    {
        return Server.createWebServer("-web",
                                      "-webAllowOthers",
                                      "-webPort",
                                      h2WebPort)
                     .start();
    }
}
```

* POM entry was made in previous lesson
  
* Access the H2 database

  * Must be done while the application is running - H2 is an in memory database and thus is only available when the application is running.
  * Inside IntelliJ
  
![Gif using H2 in IntelliJ](https://lambdaschool.github.io/java-curriculum-assets/Sprint%2011%20-%20Java%20with%20RDBMS%20and%20API%20Intros/Module%203%20-%20JX%20Java%20-%20Inserting%20Deleting%20and%20Updating%20Data%20using%20CRUD%20Operations%20including%20generating%20Seed%20Data/assets/JX-SP11-M3-06.gif)

  * Print Diagram

![Gif using H2 in IntelliJ to Print Diagram](https://lambdaschool.github.io/java-curriculum-assets/Sprint%2011%20-%20Java%20with%20RDBMS%20and%20API%20Intros/Module%203%20-%20JX%20Java%20-%20Inserting%20Deleting%20and%20Updating%20Data%20using%20CRUD%20Operations%20including%20generating%20Seed%20Data/assets/JX-SP11-M3-08.gif)

  * From the H2 console

![Gif using H2 in Console](https://lambdaschool.github.io/java-curriculum-assets/Sprint%2011%20-%20Java%20with%20RDBMS%20and%20API%20Intros/Module%203%20-%20JX%20Java%20-%20Inserting%20Deleting%20and%20Updating%20Data%20using%20CRUD%20Operations%20including%20generating%20Seed%20Data/assets/JX-SP11-M3-07.gif)

* [Check for Understanding CFU - Google Form](https://forms.gle/eqATYQvJS5hoUr818)

## Closing

### Conclusion

#### Review what we just learned

* How to create a full CRUD application
* How to turn methods into single transactions
* How to see data
  * Using Java
* How to generate random seed data
* How to access your H2 database

#### How is this related to tomorrow's topic

* Revisit Many to Many Relationships where the join tables can have additional columns
* How to audit when data is created or updated
* When JPA Queries are not enough, how to use "raw" SQL in your application

### Exit Ticket

Please take a moment to reflect on what you have learned in today's Guided Project. Remember your response will be read by your instructor to help guide future lessons.

* [Guided Project Exit Ticket](https://forms.gle/dHZYs9er7T8mQbqg8)
