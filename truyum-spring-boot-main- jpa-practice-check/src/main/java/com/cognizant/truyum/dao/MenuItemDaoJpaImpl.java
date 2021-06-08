package com.cognizant.truyum.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;

@Component("menuItemDao")
public class MenuItemDaoJpaImpl implements MenuItemDao {

	@Autowired
	MenuItemRepository menuItemRepository;
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		
		return menuItemRepository.findAll();
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		return menuItemRepository.getMenuItemCustomer();
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		
		menuItemRepository.save(menuItem);
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		
		return menuItemRepository.getOne(menuItemId);
	}

}
