package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Restaurant;
import com.lambdaschool.crudyrestaurants.views.MenuCounts;

import java.util.List;

public interface RestaurantServices {

    Restaurant save(Restaurant rest);

    List<Restaurant> findAllRestaurants();
    Restaurant findById(long id);
    Restaurant findByName(String name);
    List<Restaurant> findByNameLike(String name);
    List<MenuCounts> getMenuCounts();
    List<Restaurant> findByDish(String dish);
    void deleteAll();
    void delete(long restaurantid);

    Restaurant update(Restaurant restaurant, long restaurantid);
}
