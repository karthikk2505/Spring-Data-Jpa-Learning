package com.cognizant.truyum.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class MenuItem {
	
	@Id
	@GeneratedValue
	@Column(name="menu_id")
    private long id;
    //@NotBlank(message="Title is required")
    @Size(min=2,max=65,message="Title should have 2 to 65 charecters")
    private String name;
    //@NotBlank(message="Price is required")
    //@Pattern(message="Price has to be a number")
    @NotNull
    private float price;
    private boolean active;
  //  @NotBlank(message="Launch Date Required")
    private Date dateOfLaunch;
    private String category;
    private boolean freeDelivery;

    @ManyToMany(mappedBy = "menuItemList")
    private Set<Cart> carts = new HashSet<>();
    
    public MenuItem(long id, String name, float price, boolean active, Date dateOfLaunch, String category,
            boolean freeDelivery) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.active = active;
        this.dateOfLaunch = dateOfLaunch;
        this.category = category;
        this.freeDelivery = freeDelivery;
    }
    
    public void addCart(Cart cart)
    {
    	carts.add(cart);
    }
    public void removeCart(Cart cart)
    {
    	carts.remove(cart);
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getDateOfLaunch() {
        return dateOfLaunch;
    }

    public void setDateOfLaunch(Date dateOfLaunch) {
        this.dateOfLaunch = dateOfLaunch;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isFreeDelivery() {
        return freeDelivery;
    }

    public void setFreeDelivery(boolean freeDelivery) {
        this.freeDelivery = freeDelivery;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
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
        MenuItem other = (MenuItem) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + ", dateOfLaunch="
                + dateOfLaunch + ", category=" + category + ", freeDelivery=" + freeDelivery + "]";
    }

}
