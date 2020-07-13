package com.lambdaschool.crudyrestaurants.controllers;

import com.lambdaschool.crudyrestaurants.models.Restaurant;
import com.lambdaschool.crudyrestaurants.services.RestaurantServices;
import com.lambdaschool.crudyrestaurants.views.MenuCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private RestaurantServices restaurantServices;

    /**
     * Returns a list of all restaurants.
     * <br>Example: <a href="http://localhost:2019/restaurants/restaurants">http://localhost:2019/restaurants/restaurants</a>.
     *
     * @return JSON list of all restaurants with a status of OK.
     * @see RestaurantServices#findAllRestaurants() RestaurantServices.findAllRestaurants().
     */
    @GetMapping(value = "/restaurants",
        produces = {"application/json"})
    public ResponseEntity<?> listAllRestaurants()
    {
        List<Restaurant> myRestaurants = restaurantServices.findAllRestaurants();
        return new ResponseEntity<>(myRestaurants,
                                    HttpStatus.OK);
    }

    /**
     * Returns a single restaurant based off a restaurant id number.
     * <br>Example: <a href="http://localhost:2019/restaurants/restaurant/3">http://localhost:2019/restaurants/restaurant/3</a>.
     *
     * @param restaurantId The primary key number of the restaurant you seek.
     * @return JSON of the restaurant you seek with a status of OK.
     * @see RestaurantServices#findRestaurantById(long) RestaurantServices.findRestaurantById(long).
     */
    @GetMapping(value = "/restaurant/{restaurantId}",
        produces = {"application/json"})
    public ResponseEntity<?> getRestaurantById(
        @PathVariable
            Long restaurantId)
    {
        Restaurant r = restaurantServices.findRestaurantById(restaurantId);
        return new ResponseEntity<>(r,
                                    HttpStatus.OK);
    }

    /**
     * Returns a single restaurant based off of a restaurant's name.
     * <br>Example: <a href="http://localhost:2019/restaurants/restaurant/name/Supreme%20Eats">http://localhost:2019/restaurants/restaurant/name/Supreme%20Eats</a>.
     *
     * @param name The complete name of the restaurant you seek.
     * @return JSON of the restaurant you seek with a status of OK.
     * @see RestaurantServices#findRestaurantByName(String) RestaurantServices.findRestaurantByName(String).
     */
    @GetMapping(value = "/restaurant/name/{name}",
        produces = {"application/json"})
    public ResponseEntity<?> getRestaurantByName(
        @PathVariable
            String name)
    {
        Restaurant r = restaurantServices.findRestaurantByName(name);
        return new ResponseEntity<>(r,
                                    HttpStatus.OK);
    }

    /**
     * Returns a list of restaurants that reside in the given state.
     * <br>Example: <a href="http://localhost:2019/restaurants/restaurant/state/st">http://localhost:2019/restaurants/restaurant/state/st</a>.
     *
     * @param findstate The two character abbreviation of the state where you want to local restaurants.
     * @return JSON list of the restaurants found in the specified state with a status of OK.
     * @see RestaurantServices#findByState(String) RestaurantServices.findByState(String).
     */
    @GetMapping(value = "/restaurant/state/{findstate}",
        produces = "application/json")
    public ResponseEntity<?> findRestaurantByState(
        @PathVariable
            String findstate)
    {
        List<Restaurant> rtnList = restaurantServices.findByState(findstate);
        return new ResponseEntity<>(rtnList,
                                    HttpStatus.OK);
    }

    /**
     * Returns a list of restaurants whose name contains the given substring.
     * <br> Example: <a href="http://localhost:2019/restaurants/restaurant/likename/eat">http://localhost:2019/restaurants/restaurant/likename/eat</a>.
     *
     * @param restname The substring in the restaurants' names that you seek.
     * @return JSON list of the restaurants found with the given substring in their name with a status of OK.
     * @see RestaurantServices#findByNameLike(String) RestaurantServices.findByNameLike(String).
     */
    @GetMapping(value = "/restaurant/likename/{restname}",
        produces = "application/json")
    public ResponseEntity<?> findRestaurantByNameLike(
        @PathVariable
            String restname)
    {
        List<Restaurant> rtnList = restaurantServices.findByNameLike(restname);
        return new ResponseEntity<>(rtnList,
                                    HttpStatus.OK);
    }

    /**
     * Returns a list of restaurants whose menu contains the given dish
     * <br> Example: <a href="http://localhost:2019/restaurants/restaurant/likedish/cake">http://localhost:2019/restaurants/restaurant/likedish/cake</a>.
     *
     * @param dishname The substring in the restaurants' menu dish that you seek.
     * @return JSON list of the restaurants found with the given substring in their list of menu items with a status of OK.
     * @see RestaurantServices#findByDish(String) RestaurantServices.findByDish(String)
     */
    @GetMapping(value = "/restaurant/likedish/{dishname}",
            produces = "application/json")
    public ResponseEntity<?> findRestaurantByDishLike(
            @PathVariable
                    String dishname)
    {
        List<Restaurant> rtnList = restaurantServices.findByDish(dishname);
        return new ResponseEntity<>(rtnList,
                                    HttpStatus.OK);
    }

    /**
     * Returns a list of all restaurants with their menu counts
     * <br>Example: <a href="http://localhost:2019/restaurants/menucounts">http://localhost:2019/restaurants/menucounts</a>.
     *
     * @return JSON list of all restaurants with their menu counts with a status of OK.
     * @see RestaurantServices#getMenuCounts() () RestaurantServices.getMenuCounts().
     */
    @GetMapping(value = "/menucounts",
            produces = {"application/json"})
    public ResponseEntity<?> getMenuCounts()
    {
        List<MenuCounts> myList = restaurantServices.getMenuCounts();
        return new ResponseEntity<>(myList,
                                    HttpStatus.OK);
    }

}
