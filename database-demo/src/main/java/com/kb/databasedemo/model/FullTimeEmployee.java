package com.kb.databasedemo.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee{
	
	private BigDecimal salary;
	
	
	protected FullTimeEmployee() {}
	
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "FullTimeEmployee [salary=" + salary + "]";
	}

	public FullTimeEmployee(String name,BigDecimal salary) {
		super(name);
		this.salary=salary;
		// TODO Auto-generated constructor stub
	}
	
}
