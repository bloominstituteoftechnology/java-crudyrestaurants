package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Restaurant;
import com.lambdaschool.crudyrestaurants.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "restaurantServices")
public class RestaurantServicesImpl implements RestaurantServices
{
    @Autowired
    RestaurantRepository restrepos;

    @Override
    public Restaurant save(Restaurant restaurant) {
        return restrepos.save(restaurant);
    }
}
