package com.lambdaschool.crudyrestaurants.views;

/**
 * Used to format the JSON output for a custom query that gathers information on restaurants
 * and the count of their menu items
 */
public interface MenuCounts
{
   /**
    * The name of the restaurant. Must be called name
    *
    * @return the name (String) of restaurant
    */
   String getName();

   /**
    * The count of the count of the menu items. Must be called countmenus
    *
    * @return the count (int) of the menu items
    */
   int getCountmenus();
}
