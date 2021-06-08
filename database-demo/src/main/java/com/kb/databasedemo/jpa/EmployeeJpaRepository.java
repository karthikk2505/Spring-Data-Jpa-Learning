package com.kb.databasedemo.jpa;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kb.databasedemo.model.Employee;
import com.kb.databasedemo.model.FullTimeEmployee;
import com.kb.databasedemo.model.PartTimeEmployee;
import com.kb.databasedemo.model.Review;

@Repository
@Transactional
public class EmployeeJpaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(Employee employee)
	{
		entityManager.persist(employee);
	}
	
	// this function is not valid if you use mappedSuper class since Employee entity will not be created.
	public List<Employee> retriveAllEmployee()
	{
		return entityManager.createQuery("select e from Employee e",Employee.class).getResultList();
	}
	public List<FullTimeEmployee> retriveAllFullTimeEmployee()
	{
		return entityManager.createQuery("select e from FullTimeEmployee e",FullTimeEmployee.class).getResultList();
	}
	public List<PartTimeEmployee> retriveAllPartTimeEmployee()
	{
		return entityManager.createQuery("select e from PartTimeEmployee e",PartTimeEmployee.class).getResultList();
	}
	
	
}
