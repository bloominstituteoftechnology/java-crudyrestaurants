package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Restaurant;

import java.util.List;

public interface RestaurantServices
{
    List<Restaurant> findAllRestaurants();

    Restaurant save(Restaurant restaurant);
}
