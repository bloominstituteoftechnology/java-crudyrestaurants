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

/**
 * The entry point for clients to access restaurant data.
 */
@RestController
@RequestMapping("/restaurants")
public class RestaurantController
{
    /**
     * Using the restaurant service to process restaurant data.
     */
    @Autowired
    private RestaurantService restaurantService;

    /**
     * Returns a list of all restaurants.
     * <br>Example: <a href="http://localhost:2019/restaurants/restaurants">http://localhost:2019/restaurants/restaurants</a>.
     *
     * @return JSON list of all restaurants with a status of OK.
     * @see RestaurantService#findAllRestaurants() RestaurantService.findAllRestaurants().
     */
    @GetMapping(value = "/restaurants",
        produces = {"application/json"})
    public ResponseEntity<?> listAllRestaurants()
    {
        List<Restaurant> myRestaurants = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(myRestaurants,
            HttpStatus.OK);
    }

    /**
     * Returns a single restaurant based off a restaurant id number.
     * <br>Example: <a href="http://localhost:2019/restaurants/restaurant/3">http://localhost:2019/restaurants/restaurant/3</a>.
     *
     * @param restaurantId The primary key number of the restaurant you seek.
     * @return JSON of the restaurant you seek with a status of OK.
     * @see RestaurantService#findRestaurantById(long) RestaurantService.findRestaurantById(long).
     */
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

    /**
     * Returns a single restaurant based off of a restaurant's name.
     * <br>Example: <a href="http://localhost:2019/restaurants/restaurant/name/Supreme%20Eats">http://localhost:2019/restaurants/restaurant/name/Supreme%20Eats</a>.
     *
     * @param name The complete name of the restaurant you seek.
     * @return JSON of the restaurant you seek with a status of OK.
     * @see RestaurantService#findRestaurantByName(String) RestaurantService.findRestaurantByName(String).
     */
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

    /**
     * Returns a list of restaurants that reside in the given state.
     * <br>Example: <a href="http://localhost:2019/restaurants/restaurant/state/st">http://localhost:2019/restaurants/restaurant/state/st</a>.
     *
     * @param findstate The two character abbreviation of the state where you want to local restaurants.
     * @return JSON list of the restaurants found in the specified state with a status of OK.
     * @see RestaurantService#findByState(String) RestaurantService.findByState(String).
     */
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

    /**
     * Returns a list of restaurants whose name contains the given substring.
     * <br> Example: <a href="http://localhost:2019/restaurants/restaurant/likename/eat">http://localhost:2019/restaurants/restaurant/likename/eat</a>.
     *
     * @param restname The substring in the restaurants' names that you seek.
     * @return JSON list of the restaurants found with the given substring in their name with a status of OK.
     * @see RestaurantService#findByNameLike(String) RestaurantService.findByNameLike(String).
     */
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

    /**
     * Given a complete Restaurant Object, create a new Restaurant record and accompanying menu records
     * and restaurant payment records.
     *
     * @param newRestaurant A complete new restaurant to add including menus and payments.
     *                      Payments must already exist.
     * @return A location header with the URI to the newly created restaurant and a status of CREATED
     * @throws URISyntaxException A URI to the newly created restaurant is put in the location header.
     *                            If an error occurs in generating that URI, an exception is thrown.
     */
    @PostMapping(value = "/restaurant",
        consumes = {"application/json"})
    public ResponseEntity<?> addNewRestaurant(
        @Valid
        @RequestBody
            Restaurant newRestaurant) throws
        URISyntaxException
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

    /**
     *
     * @param updateRestaurant
     * @param restaurantid
     * @return
     */
    @PutMapping(value = "/restaurant/{restaurantid}",
        consumes = {"application/json"})
    public ResponseEntity<?> updateFullRestaurant(
        @Valid
        @RequestBody
            Restaurant updateRestaurant,
        @PathVariable
            long restaurantid)
    {
        updateRestaurant.setRestaurantid(restaurantid);
        updateRestaurant = restaurantService.save(updateRestaurant);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newRestaurantURI = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{restaurantid}")
            .buildAndExpand(updateRestaurant.getRestaurantid())
            .toUri();
        responseHeaders.setLocation(newRestaurantURI);

        return new ResponseEntity<>(null,
            responseHeaders,
            HttpStatus.CREATED);
    }

    @PatchMapping(value = "/restaurant/{restaurantid}",
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

    @DeleteMapping("/restaurant/{restaurantid}")
    public ResponseEntity<?> deleteRestaurantById(
        @PathVariable
            long restaurantid)
    {
        restaurantService.delete(restaurantid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
