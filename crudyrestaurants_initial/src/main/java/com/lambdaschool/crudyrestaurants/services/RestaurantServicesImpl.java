package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Restaurant;
import com.lambdaschool.crudyrestaurants.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service(value="restuarntService")
public class RestaurantServicesImpl implements RestaurantServices {

    @Autowired
    private RestaurantRepository restaurantrepos;


    @Transactional
    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurantrepos.save(restaurant);
    }
}
