package com.lambdaschool.crudyrestaurants.repositories;

import com.lambdaschool.crudyrestaurants.models.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * The CRUD Repository connecting Restaurant to the rest of the application.
 */
public interface RestaurantRepository extends CrudRepository<Restaurant, Long>
{
    /**
     * Find a restaurant by its full name.
     *
     * @param name The name to search for.
     * @return The found Restaurant or NULL if not found.
     */
    Restaurant findByName(String name);

    /**
     * List of all restaurants found in a state.
     *
     * @param state The two character abbreviation of the state to search for.
     * @return The list of Restaurants in the given state.
     */
    ArrayList<Restaurant> findByStateIgnoringCase(String state);

    /**
     * List of all restaurants whose name contains a given substring.
     *
     * @param likename The substring to search for in a restaurant name.
     * @return The list of Restaurants whose name contains the given substring.
     */
    ArrayList<Restaurant> findByNameContainingIgnoringCase(String likename);

    // the following does not work on purpose. It is an example of how JPA Querying works.
    // Restaurant findByRestaurantName(String name);
}
