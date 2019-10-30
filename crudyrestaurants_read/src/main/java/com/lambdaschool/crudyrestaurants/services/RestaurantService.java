package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Restaurant;

import java.util.List;

public interface RestaurantService
{
    List<Restaurant> findAll();

    Restaurant findRestaurantById(long id);

    Restaurant findRestaurantByName(String name);

    List<Restaurant> findByState(String state);

    List<Restaurant> findByNameLike(String thename);
}
