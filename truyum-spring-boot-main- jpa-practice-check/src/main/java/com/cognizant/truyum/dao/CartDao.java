/**
 * An Interface for aiding in the implementation of Cart Dao Classes
 * 
 */
package com.cognizant.truyum.dao;

import java.util.Set;

import com.cognizant.truyum.model.MenuItem;



public interface CartDao {
	

	public void addCartItem(long userId, long menuItemId);
	

	
	public Set<MenuItem> getAllCartItems(long userId) throws CartEmptyException;
	
	
	public void removeCartItem(long userId, long menuItemId);
	
}
