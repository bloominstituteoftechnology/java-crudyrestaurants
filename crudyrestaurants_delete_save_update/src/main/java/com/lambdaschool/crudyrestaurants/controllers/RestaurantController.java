package com.lambdaschool.crudyrestaurants.controllers;

import com.lambdaschool.crudyrestaurants.models.Restaurant;
import com.lambdaschool.crudyrestaurants.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController
{
    @Autowired
    private RestaurantService restaurantService;

    // http://localhost:2019/restaurants/restaurants
    @GetMapping(value = "/restaurants",
                produces = {"application/json"})
    public ResponseEntity<?> listAllRestaurants()
    {
        List<Restaurant> myRestaurants = restaurantService.findAll();
        return new ResponseEntity<>(myRestaurants,
                                    HttpStatus.OK);
    }

    // http://localhost:2019/restaurants/restaurant/3
    @GetMapping(value = "/restaurant/{restaurantId}",
                produces = {"application/json"})
    public ResponseEntity<?> getRestaurantById(
            @PathVariable
                    Long restaurantId)
    {
        Restaurant r = restaurantService.findRestaurantById(restaurantId);
        return new ResponseEntity<>(r,
                                    HttpStatus.OK);
    }

    // http://localhost:2019/restaurants/restaurant/name/Supreme%20Eats
    @GetMapping(value = "/restaurant/name/{name}",
                produces = {"application/json"})
    public ResponseEntity<?> getRestaurantByName(
            @PathVariable
                    String name)
    {
        Restaurant r = restaurantService.findRestaurantByName(name);
        return new ResponseEntity<>(r,
                                    HttpStatus.OK);
    }

    // http://localhost:2019/restaurants/restaurant
    //        {
    //            "name": "Good East",
    //                "address": "123 Main Avenue",
    //                "city": "Uptown",
    //                "state": "ST",
    //                "telephone": "555-777-7777",
    //                "menus": [
    //            {
    //                "dish": "Soda",
    //                    "price": 3.50
    //            },
    //            {
    //                "dish": "Latte",
    //                    "price": 5.00
    //            }
    //        ]
    //        }
    @PostMapping(value = "/restaurant",
                 consumes = {"application/json"})
    public ResponseEntity<?> addNewRestaurant(@Valid
                                              @RequestBody
                                                      Restaurant newRestaurant) throws URISyntaxException
    {
        newRestaurant = restaurantService.save(newRestaurant);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newRestaurantURI = ServletUriComponentsBuilder.fromCurrentRequest()
                                                          .path("/{restaurantid}")
                                                          .buildAndExpand(newRestaurant.getRestaurantid())
                                                          .toUri();
        responseHeaders.setLocation(newRestaurantURI);

        return new ResponseEntity<>(null,
                                    responseHeaders,
                                    HttpStatus.CREATED);
    }

    // localhost:2019/restaurants/restaurant/18
    //        {
    //            "telephone" : "555-555-1234"
    //        }
    @PutMapping(value = "/restaurant/{restaurantid}",
                consumes = {"application/json"})
    public ResponseEntity<?> updateRestaurant(
            @RequestBody
                    Restaurant updateRestaurant,
            @PathVariable
                    long restaurantid)
    {
        restaurantService.update(updateRestaurant,
                                 restaurantid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // localhost:2019/restaurants/restaurant/22
    @DeleteMapping("/restaurant/{restaurantid}")
    public ResponseEntity<?> deleteRestaurantById(
            @PathVariable
                    long restaurantid)
    {
        restaurantService.delete(restaurantid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // localhost:2019/restaurants/restaurant/state/st
    @GetMapping(value = "/restaurant/state/{findstate}",
                produces = "application/json")
    public ResponseEntity<?> findRestaurantByState(
            @PathVariable
                    String findstate)
    {
        List<Restaurant> rtnList = restaurantService.findByState(findstate);
        return new ResponseEntity<>(rtnList,
                                    HttpStatus.OK);
    }

    // localhost:2019/restaurants/restaurant/likename/eat
    @GetMapping(value = "/restaurant/likename/{restname}",
                produces = "application/json")
    public ResponseEntity<?> findRestaurantByNameLike(
            @PathVariable
                    String restname)
    {
        List<Restaurant> rtnList = restaurantService.findByNameLike(restname);
        return new ResponseEntity<>(rtnList,
                                    HttpStatus.OK);
    }

}

