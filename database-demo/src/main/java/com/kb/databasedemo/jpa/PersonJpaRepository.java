package com.kb.databasedemo.jpa;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kb.databasedemo.model.Person;
import com.kb.databasedemo.model.Product;

@Repository
@Transactional
public class PersonJpaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Person> findAll()
	{
		// this is also one way
		//return entityManager.createQuery("select p from Person p").getResultList();
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}
	
	public Person findById(int id)
	{
		return entityManager.find(Person.class,id);
	}
	/*
	 * This method will update the row by checking the id. id the id is present 
	 * it will update
	 * or else it will insert.
	 */
	public Person update(Person person)
	{
		return entityManager.merge(person);
	}
	public Person insert(Person person)
	{
		return entityManager.merge(person);
	}
	
	public void deleteById(int id)
	{
		Person person = findById(id);
		entityManager.remove(person);
	}
	public void insertPersonAndCource(Person person,Product product)
	{
		entityManager.persist(person);
		entityManager.persist(product);
		//establishing relation ship
		person.addProduct(product);
		product.addPerson(person);
		entityManager.persist(person);
	}
	public void playWithEntityManager()
	{
		Person person = new Person("Harry","Banglore",new Timestamp(new Date().getTime()));
		entityManager.persist(person);
		entityManager.flush();
		// at this time the data will be updated in database ie.. entityManager keep track of the object so that it updates into db whenever the object is updated.
		
		//which means if any updates occur to the object person that will not be reflected to the data base.
		//entityManager.detach(person);
		person.setName("Harry - Updated");
		
		//if you want to revoke the changes that are done to person we have to use refresh.
		entityManager.refresh(person);
	}
}
