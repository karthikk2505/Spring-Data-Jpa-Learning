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

import com.kb.databasedemo.model.Review;

@Repository
@Transactional
public class ReviewJpaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Review> findAll()
	{
		// this is also one way
		return entityManager.createQuery("select p from Review p").getResultList();
		//TypedQuery<Review> namedQuery = entityManager.createNamedQuery("find_all_reviews", Review.class);
		//return namedQuery.getResultList();
	}
	
	public Review findById(Long id)
	{
		return entityManager.find(Review.class,id);
	}
	/*
	 * This method will update the row by checking the id. id the id is present 
	 * it will update
	 * or else it will insert.
	 */
	public Review update(Review review)
	{
		return entityManager.merge(review);
	}
	public Review insert(Review review)
	{
		return entityManager.merge(review);
	}
	
	public void deleteById(Long id)
	{
		Review review = findById(id);
		entityManager.remove(review);
	}
	
	
	public void playWithEntityManager()
	{
		//Review review = new Review("IFD22222");
		//entityManager.persist(review);
		//entityManager.flush();
		//entityManager.persist(person);
	}
}
