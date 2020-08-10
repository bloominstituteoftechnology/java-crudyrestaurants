package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Menu;
import com.lambdaschool.crudyrestaurants.models.Payment;
import com.lambdaschool.crudyrestaurants.models.Restaurant;
import com.lambdaschool.crudyrestaurants.repositories.PaymentRepository;
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

    @Autowired
    private PaymentRepository paymentrepos;


    @Transactional
    @Override
    public Restaurant save(Restaurant restaurant) {
        Restaurant newRestaurant = new Restaurant();
        if (restaurant.getRestaurantid() != 0){
            restaurantrepos.findById(restaurant.getRestaurantid()).orElseThrow(() -> new EntityNotFoundException("Restaurant " + restaurant.getRestaurantid() + " not found"));
            newRestaurant.setRestaurantid(restaurant.getRestaurantid());

        }
        newRestaurant.setName(restaurant.getName());
        newRestaurant.setAddress(restaurant.getAddress());
        newRestaurant.setCity(restaurant.getCity());
        newRestaurant.setState(restaurant.getState());
        newRestaurant.setTelephone(restaurant.getTelephone());
        newRestaurant.setSeatcapacity(restaurant.getSeatcapacity());

        // one to many
        newRestaurant.getMenus().clear();

        for (Menu m: restaurant.getMenus()){
            Menu newMenu = new Menu(m.getDish(), m.getPrice(), newRestaurant);
            newRestaurant.getMenus().add(newMenu);
        }

        // many to many
        newRestaurant.getPayments().clear();
        for (Payment p: restaurant.getPayments()){
            Payment newPayment = paymentrepos.findById(p.getPaymentid()).orElseThrow(() -> new EntityNotFoundException("Payemnt " + p.getPaymentid() + " not found"));
            newRestaurant.getPayments().add(newPayment);
        }

        return restaurantrepos.save(newRestaurant);
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
        myRest = restaurantrepos.findByNameIgnoringCase(name);
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

    @Transactional
    @Override
    public void deleteAll() {
        restaurantrepos.deleteAll();
    }

    @Transactional
    @Override
    public void delete(long restaurantid) {
        restaurantrepos.findById(restaurantid).orElseThrow(() -> new EntityNotFoundException("Restuarnt " + restaurantid + " not found"));
        restaurantrepos.deleteById(restaurantid);
    }

    @Transactional
    @Override
    public Restaurant update(Restaurant restaurant, long restaurantid) {

        Restaurant currentRestaurant = restaurantrepos.findById(restaurantid).orElseThrow(() -> new EntityNotFoundException("Restaurant " + restaurantid + " not found"));

        if (restaurant.getName() != null){
            currentRestaurant.setName(restaurant.getName());
        }

        if (restaurant.getAddress() != null){
            currentRestaurant.setAddress(restaurant.getAddress());
        }

        if (restaurant.getCity() != null){
            currentRestaurant.setCity(restaurant.getCity());
        }

        if (restaurant.getState() != null){
            currentRestaurant.setState(restaurant.getState());
        }

        if (restaurant.getTelephone() != null){
            currentRestaurant.setTelephone(restaurant.getTelephone());
        }

        if (restaurant.hasvalueforseatingcapacity){
            currentRestaurant.setSeatcapacity(restaurant.getSeatcapacity());
        }


        // one to many

        if (restaurant.getMenus().size() > 0){
            currentRestaurant.getMenus().clear();

            for (Menu m: restaurant.getMenus()){
                Menu newMenu = new Menu(m.getDish(), m.getPrice(), currentRestaurant);
                currentRestaurant.getMenus().add(newMenu);
            }
        }


        // many to many
        if (restaurant.getPayments().size() > 0){
            currentRestaurant.getPayments().clear();
            for (Payment p: restaurant.getPayments()){
                Payment newPayment = paymentrepos.findById(p.getPaymentid()).orElseThrow(() -> new EntityNotFoundException("Payemnt " + p.getPaymentid() + " not found"));
                currentRestaurant.getPayments().add(newPayment);
            }
        }


        return restaurantrepos.save(currentRestaurant);
    }
}
