package com.kb.databasedemo.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee{
	private BigDecimal hourlyWage;
	protected PartTimeEmployee() {}
	public BigDecimal getHourlyWage() {
		return hourlyWage;
	}
	public void setHourlyWage(BigDecimal hourlyWage) {
		this.hourlyWage = hourlyWage;
	}
	public PartTimeEmployee(String name,BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage=hourlyWage;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PartTimeEmployee [hourlyWage=" + hourlyWage + "]";
	}
	
}
