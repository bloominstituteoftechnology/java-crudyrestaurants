package com.lambdaschool.crudyrestaurants.repositories;

import com.lambdaschool.crudyrestaurants.models.Restaurant;
import com.lambdaschool.crudyrestaurants.views.MenuCounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

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
    List<Restaurant> findByStateIgnoringCase(String state);

    /**
     * List of all restaurants whose name contains a given substring.
     *
     * @param likename The substring to search for in a restaurant name.
     * @return The list of Restaurants whose name contains the given substring.
     */
    List<Restaurant> findByNameContainingIgnoringCase(String likename);

    // the following does not work on purpose. It is an example of how JPA Querying works.
    // Restaurant findByRestaurantName(String name);

    List<Restaurant> findByMenus_dishContainingIgnoringCase(String thedish);

    /**
     * Custom Query to list the name of the restaurant and the number of menu items
     * in descending order by number of menu items
     *
     * SELECT r.name, count(menuid) as countmenus
     * FROM restaurants r LEFT JOIN menus m
     * ON r.restaurantid = m.restaurantid
     * GROUP BY r.name
     * ORDER BY countmenus desc
     *
     * @return List (element type is the interface MenuCounts)
     * containing restaurants and the number of menu items they have
     */
    @Query(value = "SELECT r.name as name, count(menuid) as countmenus " +
                   "FROM restaurants r LEFT JOIN menus m " +
                   "ON r.restaurantid = m.restaurantid " +
                   "GROUP BY r.name " +
                   "ORDER BY countmenus desc", nativeQuery = true)
    List<MenuCounts> findMenuCounts();
}