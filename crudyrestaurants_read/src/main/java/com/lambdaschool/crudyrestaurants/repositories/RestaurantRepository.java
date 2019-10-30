package com.lambdaschool.crudyrestaurants.repositories;

import com.lambdaschool.crudyrestaurants.models.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long>
{
    Restaurant findByName(String name);

    ArrayList<Restaurant> findByStateIgnoringCase(String state);

    ArrayList<Restaurant> findByNameContainingIgnoringCase(String likename);

    // the following does not work
    // Restaurant findByRestaurantName(String name);
}

