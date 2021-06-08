package com.kb.databasedemo.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//@NamedQuery(name="find_all_persons",query = "SELECT p from Person p")
@Entity
@Table
public class Passport {
	@Id
	@GeneratedValue()
	private Long id;
	private String number;
	
	// this is to create a bidirectional relationship we are ysoung mappedBy="passport" here because
	// in order to remove redundency like creating a person_id column in the passport table and passport_id in Person table
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "passport")// this means it will not create the passport object when retrieving.
	@JoinColumn(referencedColumnName = "id")
	private Person person;
	public Passport()
	{
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id; 
	}
	public String getNumber() {
		return number; 
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Passport(String number) {
		super();
		this.number = number;
	}
	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + "]";
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
