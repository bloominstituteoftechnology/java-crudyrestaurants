package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Menu;
import com.lambdaschool.crudyrestaurants.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements the MenuService Interface
 */
@Transactional
@Service(value = "menuService")
public class MenuServicesImpl
        implements MenuServices
{
    /**
     * Connects this service to the Menus Table.
     */
    @Autowired
    private MenuRepository menurepos;

    @Override
    public List<Menu> findAllMenus()
    {
        List<Menu> list = new ArrayList<>();
        /*
         * findAll returns an iterator set.
         * iterate over the iterator set and add each element to an array list.
         */
        menurepos.findAll()
            .iterator()
            .forEachRemaining(list::add);
        return list;
    }
}
