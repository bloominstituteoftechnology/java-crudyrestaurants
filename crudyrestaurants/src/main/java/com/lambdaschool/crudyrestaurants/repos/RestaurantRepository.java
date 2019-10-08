package com.lambdaschool.crudyrestaurants.repos;

import com.lambdaschool.crudyrestaurants.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long>
{
    Restaurant findByName(String name);

    ArrayList<Restaurant> findByStateIgnoringCase(String state);

    ArrayList<Restaurant> findByNameContainingIgnoringCase(String likename);

    // the following does not work
    // Restaurant findByRestaurantName(String name);
}

