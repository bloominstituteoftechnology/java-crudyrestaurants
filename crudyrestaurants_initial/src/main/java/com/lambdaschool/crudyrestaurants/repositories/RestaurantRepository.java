package com.lambdaschool.crudyrestaurants.repositories;


import com.lambdaschool.crudyrestaurants.models.Restaurant;
import com.lambdaschool.crudyrestaurants.views.MenuCounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

    Restaurant findByNameIgnoringCase(String name);

    @Query(value = "SELECT r.name, count(m.menuid) as menu_count FROM restaurants r LEFT JOIN menus m ON m.restaurantid = r.restaurantid GROUP BY r.restaurantid ORDER BY menu_count DESC", nativeQuery = true)
    List<MenuCounts> getMenuCounts();

    List<Restaurant> findByNameContainingIgnoringCase(String subname);

    List<Restaurant> findByMenus_dishContainingIgnoringCase(String dish);

}


