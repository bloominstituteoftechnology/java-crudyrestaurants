package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Menu;

import java.util.List;

/**
 * The Service that works with the Menu Model.
 */
public interface MenuServices
{
    /**
     * Returns a list of all the menus.
     *
     * @return List of Menus. If no Menus, empty list.
     */
    List<Menu> findAllMenus();
}
