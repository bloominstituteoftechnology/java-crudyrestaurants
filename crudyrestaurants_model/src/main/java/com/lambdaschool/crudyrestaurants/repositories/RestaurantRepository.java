package com.lambdaschool.crudyrestaurants.repositories;

import com.lambdaschool.crudyrestaurants.models.Restaurant;
import org.springframework.data.repository.CrudRepository;

/**
 * The CRUD Repository connecting Restaurant to the rest of the application.
 */
public interface RestaurantRepository extends CrudRepository<Restaurant, Long>
{

}