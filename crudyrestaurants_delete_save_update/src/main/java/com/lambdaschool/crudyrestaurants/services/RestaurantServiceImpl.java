package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Menu;
import com.lambdaschool.crudyrestaurants.models.Restaurant;
import com.lambdaschool.crudyrestaurants.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "restaurantService")
public class RestaurantServiceImpl implements RestaurantService
{
    @Autowired
    private RestaurantRepository restrepos;

    @Override
    public List<Restaurant> findAll()
    {
        List<Restaurant> list = new ArrayList<>();
        restrepos.findAll()
                 .iterator()
                 .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Restaurant findRestaurantById(long id) throws EntityNotFoundException
    {
        return restrepos.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public Restaurant findRestaurantByName(String name) throws EntityNotFoundException
    {
        Restaurant restaurant = restrepos.findByName(name);

        if (restaurant == null)
        {
            throw new EntityNotFoundException("Restaurant " + name + " not found!");
        }

        return restaurant;
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        if (restrepos.findById(id)
                     .isPresent())
        {
            restrepos.deleteById(id);
        } else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Transactional
    @Override
    public Restaurant save(Restaurant restaurant)
    {
        Restaurant newRestaurant = new Restaurant();

        newRestaurant.setName(restaurant.getName());
        newRestaurant.setAddress(restaurant.getAddress());
        newRestaurant.setCity(restaurant.getCity());
        newRestaurant.setState(restaurant.getState());
        newRestaurant.setTelephone(restaurant.getTelephone());

        for (Menu m : restaurant.getMenus())
        {
            newRestaurant.getMenus()
                         .add(new Menu(m.getDish(),
                                       m.getPrice(),
                                       newRestaurant));
        }

        System.out.println("***** Saving *****");
        try
        {
            return restrepos.save(newRestaurant);
        } catch (Exception e)
        {
            return null;
        }
    }

    @Transactional
    @Override
    public Restaurant update(Restaurant restaurant,
                             long id)
    {
        Restaurant currentRestaurant = restrepos.findById(id)
                                                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (restaurant.getName() != null)
        {
            currentRestaurant.setName(restaurant.getName());
        }

        if (restaurant.getAddress() != null)
        {
            currentRestaurant.setAddress(restaurant.getAddress());
        }

        if (restaurant.getCity() != null)
        {
            currentRestaurant.setCity(restaurant.getCity());
        }

        if (restaurant.getState() != null)
        {
            currentRestaurant.setState(restaurant.getState());
        }

        if (restaurant.getTelephone() != null)
        {
            currentRestaurant.setTelephone(restaurant.getTelephone());
        }

        if (restaurant.getMenus()
                      .size() > 0)
        {
            for (Menu m : restaurant.getMenus())
            {
                currentRestaurant.getMenus()
                                 .add(new Menu(m.getDish(),
                                               m.getPrice(),
                                               currentRestaurant));
            }
        }

        return restrepos.save(currentRestaurant);
    }

    @Override
    public List<Restaurant> findByState(String state)
    {
        ArrayList<Restaurant> list = restrepos.findByStateIgnoringCase(state);
        return list;
    }

    @Override
    public List<Restaurant> findByNameLike(String thename)
    {
        ArrayList<Restaurant> list = restrepos.findByNameContainingIgnoringCase(thename);
        return list;
    }
}
