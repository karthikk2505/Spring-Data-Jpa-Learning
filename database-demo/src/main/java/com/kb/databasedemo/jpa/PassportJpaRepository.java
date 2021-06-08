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

import com.kb.databasedemo.model.Passport;
import com.kb.databasedemo.model.Person;

@Repository
@Transactional
public class PassportJpaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Passport> findAll()
	{
		// this is also one way
		//return entityManager.createQuery("select p from Passport p").getResultList();
		TypedQuery<Passport> namedQuery = entityManager.createNamedQuery("find_all_passports", Passport.class);
		return namedQuery.getResultList();
	}
	
	public Passport findById(Long id)
	{
		return entityManager.find(Passport.class,id);
	}
	/*
	 * This method will update the row by checking the id. id the id is present 
	 * it will update
	 * or else it will insert.
	 */
	public Passport update(Passport passport)
	{
		return entityManager.merge(passport);
	}
	public Passport insert(Passport passport)
	{
		return entityManager.merge(passport);
	}
	
	public void deleteById(Long id)
	{
		Passport passport = findById(id);
		entityManager.remove(passport);
	}
	public void playWithEntityManager()
	{
		Passport passport = new Passport("IFD22222");
		entityManager.persist(passport);
		entityManager.flush();
		Person person = new Person("Hellak","Chennai",new Timestamp(new Date().getTime()));
		person.setPassport(passport);
		entityManager.persist(person);
	}
}
