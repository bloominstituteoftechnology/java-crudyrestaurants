package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Menu;
import com.lambdaschool.crudyrestaurants.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "menuService")
public class MenuServicesImpl implements MenuServices{

    @Autowired
    private MenuRepository menurepos;

    @Override
    public List<Menu> findAllMenus() {
        List<Menu> list = new ArrayList<>();
        menurepos.findAll().iterator().forEachRemaining(list::add);

        return list;

    }


}
