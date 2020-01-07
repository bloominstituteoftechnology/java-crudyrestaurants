package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Restaurant;

import java.util.List;

/**
 * The Service that works with the Restaurant Model.
 */
public interface RestaurantService
{
    /**
     * Returns a list of all the restaurants.
     *
     * @return List of Restaurant. If no Restaurant, empty list.
     */
    List<Restaurant> findAll();

    /**
     * Returns the restaurant with the given primary key.
     *
     * @param id The primary key (long) of the restaurant you seek.
     * @return The given Restaurant or throws an exception if not found.
     */
    Restaurant findRestaurantById(long id);

    /**
     * Returns the restaurant with the given name
     *
     * @param name The full name (String) of the Restaurant you seek.
     * @return The Restaurant with the given name or throws an exception if not found.
     */
    Restaurant findRestaurantByName(String name);

    /**
     * A list of all restaurants in a given state.
     *
     * @param state The two character (String) abbreviation of the state you seek.
     * @return List of Restaurant from that state. If no matching Restaurant, empty list.
     */
    List<Restaurant> findByState(String state);

    /**
     * A list of all restaurants whose name contains the given substring.
     *
     * @param thename The substring (String) of name you wish to search for.
     * @return A list of all restaurants whose name contains the given substring. If no matching Restaurant, empty list.
     */
    List<Restaurant> findByNameLike(String thename);
}
