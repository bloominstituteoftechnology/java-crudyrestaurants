package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Menu;
import com.lambdaschool.crudyrestaurants.models.Payment;
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

    @Autowired
    private PaymentService paymentService;

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
                        .orElseThrow(() -> new EntityNotFoundException("Restaurant " + Long.toString(id) + " Not Found"));
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
            throw new EntityNotFoundException("Restaurant " + Long.toString(id) + " Not Found");
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
        newRestaurant.setSeatcapacity(restaurant.getSeatcapacity());

        // payments must already exist
        for (Payment p : restaurant.getPayments())
        {
            newRestaurant.addPayment(paymentService.findPaymentById(p.getPaymentid()));
        }

        for (Menu m : restaurant.getMenus())
        {
            newRestaurant.getMenus()
                         .add(new Menu(m.getDish(),
                                       m.getPrice(),
                                       newRestaurant));
        }

        return restrepos.save(newRestaurant);
    }

    @Transactional
    @Override
    public Restaurant update(Restaurant restaurant,
                             long id)
    {
        Restaurant currentRestaurant = restrepos.findById(id)
                                                .orElseThrow(() -> new EntityNotFoundException("Restaurant " + Long.toString(id) + " Not Found"));

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

        // just adds payments. Payments must already exist. Deleting payment items is a different method
        if (restaurant.getPayments().size() > 0)
        {
            for (Payment p : restaurant.getPayments())
            {
                currentRestaurant.addPayment(paymentService.findPaymentById(p.getPaymentid()));
            }
        }

        if (restaurant.hasvalueforseatcapacity)
        {
            currentRestaurant.setSeatcapacity(restaurant.getSeatcapacity());
        }

        // just adds new Menus items. Deleting menu items is a different method
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
