package com.kb.databasedemo.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
//@NamedQuery(name="find_all_persons",query = "SELECT p from Person p")
@Entity
@Table
public class Product {
	@Id
	@GeneratedValue()
	private Long id;
	private String description;
	//by default fetch is lazy 
	@OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
	private List<Review> reviews = new ArrayList<>();
	@ManyToMany(mappedBy = "products")
	private List<Person> persons = new ArrayList<>();
	public Product(String description)
	{
		this.description=description;
	}
	public Product()
	{
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id; 
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description +  "]";
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void addReview(Review review) {
		this.reviews.add(review);
	}
	public void removeReview(Review review) {
		this.reviews.remove(review);
	}
	public List<Person> getPersons() {
		return persons;
	}
	public void addPerson(Person person) {
		this.persons.add(person);
	}
	public void removePerson(Person person) {
		this.persons.remove(person);
	}
}
