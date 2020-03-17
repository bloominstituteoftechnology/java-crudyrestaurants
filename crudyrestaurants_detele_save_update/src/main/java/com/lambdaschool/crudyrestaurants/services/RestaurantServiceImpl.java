package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Menu;
import com.lambdaschool.crudyrestaurants.models.Payment;
import com.lambdaschool.crudyrestaurants.models.Restaurant;
import com.lambdaschool.crudyrestaurants.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/*
 * Note: "Unless there's some extra information that isn't clear from the interface description (there rarely is), the implementation documentation should then simply link to the interface method."
 * Taken from https://stackoverflow.com/questions/11671989/best-practice-for-javadocs-interface-implementation-or-both?lq=1
 */

/**
 * Implements the RestaurantService Interface.
 */
@Transactional
@Service(value = "restaurantService")
public class RestaurantServiceImpl implements RestaurantService
{
    /**
     * Connects this service to the Restaurant Table.
     */
    @Autowired
    private RestaurantRepository restrepos;

    /**
     * Connects this service to the Payment Table.
     */
    @Autowired
    private PaymentService paymentService;

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
        ArrayList<Restaurant> list = restrepos.findByStateIgnoringCase(state);
        return list;
    }

    @Override
    public List<Restaurant> findByNameLike(String thename)
    {
        ArrayList<Restaurant> list = restrepos.findByNameContainingIgnoringCase(thename);
        return list;
    }

    /*
     * New to delete save update
     */

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
            throw new EntityNotFoundException("Restaurant " + id + " Not Found");
        }
    }

    @Transactional
    @Override
    public Restaurant save(Restaurant restaurant)
    {
        Restaurant newRestaurant = new Restaurant();

        if (restaurant.getRestaurantid() != 0)
        {
            restrepos.findById(restaurant.getRestaurantid())
                .orElseThrow(() -> new EntityNotFoundException("Restaurant " + restaurant.getRestaurantid() + " Not Found"));

            newRestaurant.setRestaurantid(restaurant.getRestaurantid());
        }

        newRestaurant.setName(restaurant.getName());
        newRestaurant.setAddress(restaurant.getAddress());
        newRestaurant.setCity(restaurant.getCity());
        newRestaurant.setState(restaurant.getState());
        newRestaurant.setTelephone(restaurant.getTelephone());
        newRestaurant.setSeatcapacity(restaurant.getSeatcapacity());

        newRestaurant.getPayments()
            .clear();
        for (Payment p : restaurant.getPayments())
        {
            Payment newPay = paymentService.findPaymentById(p.getPaymentid());

            newRestaurant.addPayment(newPay);
        }

        newRestaurant.getMenus()
            .clear();
        for (Menu m : restaurant.getMenus())
        {
            Menu newMenu = new Menu(m.getDish(),
                m.getPrice(),
                newRestaurant);

            newRestaurant.getMenus()
                .add(newMenu);
        }

        return restrepos.save(newRestaurant);
    }

    @Transactional
    @Override
    public Restaurant update(
        Restaurant restaurant,
        long id)
    {
        Restaurant currentRestaurant = restrepos.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Restaurant " + id + " Not Found"));

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

        if (restaurant.getPayments()
            .size() > 0)
        {
            currentRestaurant.getPayments()
                .clear();
            for (Payment p : restaurant.getPayments())
            {
                Payment newPay = paymentService.findPaymentById(p.getPaymentid());

                currentRestaurant.addPayment(newPay);
            }
        }

        if (restaurant.hasvalueforseatcapacity)
        {
            currentRestaurant.setSeatcapacity(restaurant.getSeatcapacity());
        }

        if (restaurant.getMenus()
            .size() > 0)
        {
            currentRestaurant.getMenus()
                .clear();
            for (Menu m : restaurant.getMenus())
            {
                Menu newMenu = new Menu(m.getDish(),
                    m.getPrice(),
                    currentRestaurant);

                currentRestaurant.getMenus()
                    .add(newMenu);
            }
        }

        return restrepos.save(currentRestaurant);
    }
}
