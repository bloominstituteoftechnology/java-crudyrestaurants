package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Restaurant;
import com.lambdaschool.crudyrestaurants.repositories.RestaurantRepository;
import com.lambdaschool.crudyrestaurants.views.MenuCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "restuarntService")
public class RestaurantServicesImpl implements RestaurantServices {

    @Autowired
    private RestaurantRepository restaurantrepos;


    @Transactional
    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurantrepos.save(restaurant);
    }

    @Override
    public List<Restaurant> findAllRestaurants() {
        List<Restaurant> list = new ArrayList<>();
        restaurantrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Restaurant findById(long id) {

        return restaurantrepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Restaurant " + id + " does not exist"));

    }

    @Override
    public Restaurant findByName(String name) {
        Restaurant myRest = new Restaurant();
        myRest = restaurantrepos.subname);
        if (myRest == null){
            throw new EntityNotFoundException("Restaurant " + name + " does not exist");
        }
        return myRest;
    }

    public List<Restaurant> findByNameLike(String name){

        return restaurantrepos.findByNameContainingIgnoringCase(name);
    }

    @Override
    public List<MenuCounts> getMenuCounts() {
        return restaurantrepos.getMenuCounts();
    }

    @Override
    public List<Restaurant> findByDish(String dish) {
        return restaurantrepos.findByMenus_dishContainingIgnoringCase(dish);
    }
}
