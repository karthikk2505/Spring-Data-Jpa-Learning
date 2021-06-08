package com.kb.databasedemo.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;


//by default strategy is Single Table
// the insert and retrive does not change wven we are using different strategy
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// in table per class each concrete class has its own filed of parent class fields.
// here union will be used to retrive the data in table per class strategy
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// three individual tables will be created and join will be used to retrive
@Inheritance(strategy = InheritanceType.JOINED)
// while using ineritance it became more complex like joining multiple tables.
// so that @MappedSuperClass came which does not create a n entity for super class
// and while retriving data we have to seperately get each sub class Entity data.
@MappedSuperclass
//@Entity // while using mapped super class we should not give it as entity.
//@DiscriminatorColumn(name = "employee_type")//gives the name to the column which has type when using single Table.
public abstract class Employee {
	@Id
	@GeneratedValue()
    @Column(name = "id", insertable = true, updatable = true, nullable = false)// if we give insertable = true we ca manyally enter the primary value as well.
	private int id;
	private String name;
	
	public Employee()
	{
		
	}
	public Employee(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id)  {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
