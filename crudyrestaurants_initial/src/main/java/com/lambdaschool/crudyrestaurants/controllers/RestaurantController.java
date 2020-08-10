package com.lambdaschool.crudyrestaurants.controllers;


import com.lambdaschool.crudyrestaurants.models.Restaurant;
import com.lambdaschool.crudyrestaurants.services.RestaurantServices;
import com.lambdaschool.crudyrestaurants.views.MenuCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    // http://localhost:2019/restaurants/restaurants
    @Autowired
    private RestaurantServices restaurantService;
    @GetMapping(value="/restaurants", produces = "application/json")
    public ResponseEntity<?> listAllRestaurants(){


        List<Restaurant> myList = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    // http://localhost:2019/restaurants/restaurant/4
    @GetMapping(value="/restaurant/{restid}", produces = "application/json")
    public ResponseEntity<?> findRestaurantById(@PathVariable long restid){
        Restaurant myRestaurant = restaurantService.findById(restid);
        return new ResponseEntity<>(myRestaurant, HttpStatus.OK);

    }

    // / http://localhost:2019/restaurants/name/Eagel%2@Cafe
    @GetMapping(value = "/name/{name}", produces = "application/json")
    public ResponseEntity<?> findRestaurantByName(@PathVariable String name){

        Restaurant myRestaurant = restaurantService.findByName(name);
        return new ResponseEntity<>(myRestaurant, HttpStatus.OK);
    }

    // / http://localhost:2019/restaurants/namelike/cafe
    @GetMapping(value = "/namelike/{subname}", produces = "application/json")
    public ResponseEntity<?> findByNameLike(@PathVariable String subname){

        List<Restaurant> myList = restaurantService.findByNameLike(subname);
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    // http://localhost:2019/restaurants/menucounts
    @GetMapping(value = "/menucounts", produces = "application/json")
    public ResponseEntity<?> findMenuCounts(){
        // name, count
        List<MenuCounts> myList  =  restaurantService.getMenuCounts();
        return new ResponseEntity<>(myList, HttpStatus.OK);


    }

    // http://localhost:2019/restaurants/dishlike/cheese
    @GetMapping(value = "/dishlike/{dish}", produces = "application/json")
    public ResponseEntity<?> findByDish(@PathVariable String dish) {
        List<Restaurant> myList  = restaurantService.findByDish(dish);
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }


    // DELETE http://localhost:2019/restaurants/restaurant/14
    @DeleteMapping(value = "/restaurant/{restaurantid}")
    public ResponseEntity<?> deleteRestaurantById(@PathVariable long restaurantid){

        restaurantService.delete(restaurantid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // POST  http://localhost:2019/restaurants/restaurant
    // Request body - JSON Object New Restaurant
    @PostMapping(value = "/restaurant", consumes = "application/json")
    public ResponseEntity<?> addNewRestaurant(@Valid @RequestBody Restaurant newRestaurant){
        newRestaurant.setRestaurantid(0);
        newRestaurant = restaurantService.save(newRestaurant);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newRestaurantURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{restaurqntid}")
                .buildAndExpand(newRestaurant.getRestaurantid()).toUri();
        responseHeaders.setLocation(newRestaurantURI);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);

    }

    // PUT  http://localhost:2019/restaurants/restaurant/14
    // Request body - JSON Object complete Restaurant -> Menu -> Payment

    @PutMapping( value = "/restaurant/{restaurantid}", produces ="application/json", consumes = "application/json")
    public ResponseEntity<?> updateRestaurant(@Valid @RequestBody Restaurant updateRestaurant, @PathVariable long restaurantid){
        updateRestaurant.setRestaurantid(restaurantid);
        updateRestaurant =  restaurantService.save(updateRestaurant);
        return new ResponseEntity<>(updateRestaurant, HttpStatus.OK);
    }

    // PATCH  http://localhost:2019/restaurants/restaurant/14
    // Request body - JSON Object
    @PatchMapping( value = "/restaurant/{restaurantid}", consumes = "application/json")
    public ResponseEntity<?> updatePartRestaurant(@RequestBody Restaurant updateRestaurant, @PathVariable long restaurantid){

        restaurantService.update(updateRestaurant, restaurantid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
