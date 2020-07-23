package com.lambdaschool.crudyrestaurants.repositories;

import com.lambdaschool.crudyrestaurants.models.Menu;
import org.springframework.data.repository.CrudRepository;

// Repository
// Repos
// DOA (Database Object Access)
public interface MenuRepository extends CrudRepository<Menu, Long> {
}
