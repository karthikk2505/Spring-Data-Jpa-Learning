/**
 * 
 */
package com.cognizant.truyum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.truyum.model.MenuItem;

/**
 * @author KB
 *
 */
@Repository
@Transactional
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
	
	@Query(value="SELECT * FROM MENU_ITEM WHERE ACTIVE = TRUE AND date_of_launch < now()",nativeQuery = true)
	public List<MenuItem> getMenuItemCustomer();
}
