package com.lambdaschool.crudyrestaurants.controllers;

import com.lambdaschool.crudyrestaurants.models.Menu;
import com.lambdaschool.crudyrestaurants.services.MenuServices;
import com.lambdaschool.crudyrestaurants.services.PaymentServices;
import com.lambdaschool.crudyrestaurants.services.RestaurantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The entry point for clients to access menu data.
 */
@RestController
@RequestMapping("/menus")
public class MenuController
{
    /**
     * Using the menu service to process menu data.
     */
    @Autowired
    private MenuServices menuServices;

    @Autowired
    private PaymentServices paymentServices;

    @Autowired
    private RestaurantServices restaurantServices;

    /**
     * Returns a list of all menus.
     * <br>Example: <a href="http://localhost:2019/menus/menus">http://localhost:2019/menus/menus</a>.
     *
     * @return JSON list of all menus with a status of OK.
     * @see MenuServices#findAllMenus() MenuServices.findAllMenus()
     */
    @GetMapping(value = "/menus",
        produces = {"application/json"})
    public ResponseEntity<?> listAllMenus()
    {
        List<Menu> myMenus = menuServices.findAllMenus();
        return new ResponseEntity<>(myMenus,
                                    HttpStatus.OK);
    }
}
