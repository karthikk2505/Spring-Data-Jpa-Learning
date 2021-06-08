package com.cognizant.truyum.dao;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.CartRepository;
import com.cognizant.truyum.repository.MenuItemRepository;

@Component("cartDao")
public class CartDaoJpaImpl implements CartDao {

	@Autowired
	CartRepository cartRepository;
	@Autowired
	MenuItemRepository menuItemRepository;
	@Override
	public void addCartItem(long userId, long menuItemId) {
		Cart cart = null;
		Optional<Cart> optional = cartRepository.findById(userId);
		if(optional.isPresent())
		{
			cart = optional.get();
		}
		MenuItem menuItem = menuItemRepository.getOne(menuItemId);
		cart.addMenuItem(menuItem);
		menuItem.addCart(cart);
		cartRepository.save(cart);
	}

	@Override
	public Set<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		Cart cart = null;
		Optional<Cart> optional = cartRepository.findById(userId);
		if(!optional.isPresent())
		{
			throw new CartEmptyException("Cart is Empty");
		}
		cart =  optional.get();
		return cart.getMenuItemList();
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		Cart cart = null;
		Optional<Cart> optional = cartRepository.findById(userId);
		if(optional.isPresent())
		{
			cart = optional.get();
		}
		MenuItem menuItem = menuItemRepository.getOne(menuItemId);
		cart.removeMenuItem(menuItem);
		menuItem.removeCart(cart);
		cartRepository.save(cart);
	}

}
