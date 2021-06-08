package com.cognizant.truyum.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue
	@Column(name="cart_id")
	private long id;
	
	@ManyToMany 
	// this will create the user defined join tables for many to many relationship
	@JoinTable(name = "cart_menuItem",
			joinColumns = @JoinColumn(name="CART_ID"),
			inverseJoinColumns = @JoinColumn(name="MENU_ID")
			)
	private Set<MenuItem> menuItemList = new HashSet<>();
	
	private double total;

	public Cart(Set<MenuItem> menuItemList) {
		super();
		this.menuItemList = menuItemList;
	}
	
	public Cart(Set<MenuItem> menuItemList, double total) {
		super();
		this.menuItemList = menuItemList;
		this.total = total;
	}
	public Set<MenuItem> getMenuItemList() {
		return menuItemList;
	} 
	public void setMenuItemList(Set<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	} 
	public void addMenuItem(MenuItem menuItem) {
		this.menuItemList.add(menuItem);
	} 
	
	public void removeMenuItem(MenuItem menuItem) {
		this.menuItemList.remove(menuItem);
	} 
	
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuItemList == null) ? 0 : menuItemList.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (menuItemList == null) {
			if (other.menuItemList != null)
				return false;
		} else if (!menuItemList.equals(other.menuItemList))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cart [menuItemList=" + menuItemList + ", total=" + total + "]";
	}
	
}
