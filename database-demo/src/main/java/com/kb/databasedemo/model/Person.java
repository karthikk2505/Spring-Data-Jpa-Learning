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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
@NamedQuery(name="find_all_persons",query = "SELECT p from Person p")
@Entity
@Table(name="person")
public class Person {
	@Id
	@GeneratedValue()
    @Column(name = "id", insertable = true, updatable = true, nullable = false)// if we give insertable = true we ca manyally enter the primary value as well.
	private int id;
	private String name;
	private String location;
	@Column(name="birth_date")
	private Timestamp birthDate;
	
	@OneToOne(fetch = FetchType.LAZY)// this means it will not create the passport object when retrieving.
	@JoinColumn(referencedColumnName = "id")
	private Passport passport;
	
	@ManyToMany 
	// this will create the user defined join tables for many to many relationship
	@JoinTable(name = "PERSON_PRODUCT",
			joinColumns = @JoinColumn(name="PERSON_ID"),
			inverseJoinColumns = @JoinColumn(name="PRODUCT_ID")
			) 
	private List<Product> products = new ArrayList<>();
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", location=" + location + ", birthDate=" + birthDate
				+ "]";
	}
	public Person()
	{
		
	}
	public Person(int id, String name, String location, Timestamp birthDate) {
		this.id=id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}
	public Person(String name, String location, Timestamp birthDate) {
		super();
		this.name = name;
		this.location = location; 
		this.birthDate = birthDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Timestamp getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void addProduct(Product product) {
		this.products.add(product);
	}
	public void removeProduct(Product product) {
		this.products.remove(product);
	}
	
}
