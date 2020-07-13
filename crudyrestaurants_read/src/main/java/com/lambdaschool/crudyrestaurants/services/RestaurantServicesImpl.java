package com.lambdaschool.crudyrestaurants.services;

/*
 * Note: "Unless there's some extra information that isn't clear from the interface description (there rarely is), the implementation documentation should then simply link to the interface method."
 * Taken from https://stackoverflow.com/questions/11671989/best-practice-for-javadocs-interface-implementation-or-both?lq=1
 */

import com.lambdaschool.crudyrestaurants.models.Restaurant;
import com.lambdaschool.crudyrestaurants.repositories.RestaurantRepository;
import com.lambdaschool.crudyrestaurants.views.MenuCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements the RestaurantService Interface.
 */
@Transactional
@Service(value = "restaurantService")
public class RestaurantServicesImpl
        implements RestaurantServices
{
    /**
     * Connects this service to the Restaurant Table.
     */
    @Autowired
    private RestaurantRepository restrepos;

    @Override
    public List<Restaurant> findAllRestaurants()
    {
        List<Restaurant> list = new ArrayList<>();
        /*
         * findAll returns an iterator set.
         * iterate over the iterator set and add each element to an array list.
         */
        restrepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Restaurant findRestaurantById(long id) throws
            EntityNotFoundException
    {
        return restrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant " + id + " Not Found"));
    }

    @Override
    public Restaurant findRestaurantByName(String name) throws
            EntityNotFoundException
    {
        Restaurant restaurant = restrepos.findByName(name);

        if (restaurant == null)
        {
            throw new EntityNotFoundException("Restaurant " + name + " not found!");
        }

        return restaurant;
    }

    @Override
    public List<Restaurant> findByState(String state)
    {
        List<Restaurant> list = restrepos.findByStateIgnoringCase(state);
        return list;
    }

    @Override
    public List<Restaurant> findByNameLike(String thename)
    {
        List<Restaurant> list = restrepos.findByNameContainingIgnoringCase(thename);
        return list;
    }

    @Override
    public List<Restaurant> findByDish(String thedish)
    {
        List<Restaurant> list = restrepos.findByMenus_dishContainingIgnoringCase(thedish);
        return list;
    }

    @Override
    public List<MenuCounts> getMenuCounts()
    {
        List<MenuCounts> list = restrepos.findMenuCounts();
        return list;
    }

    @Override
    public Restaurant save(Restaurant restaurant)
    {
        return restrepos.save(restaurant);
    }
}
