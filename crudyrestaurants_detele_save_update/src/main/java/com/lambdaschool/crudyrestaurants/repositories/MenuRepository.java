package com.lambdaschool.crudyrestaurants.repositories;

import com.lambdaschool.crudyrestaurants.models.Menu;
import org.springframework.data.repository.CrudRepository;

/**
 * The CRUD Repository connecting Menu to rest of the application.
 */
public interface MenuRepository extends CrudRepository<Menu, Long>
{
}
