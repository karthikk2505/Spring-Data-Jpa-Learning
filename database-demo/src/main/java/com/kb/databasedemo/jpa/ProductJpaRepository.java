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

import com.kb.databasedemo.model.Product;
import com.kb.databasedemo.model.Review;
import com.kb.databasedemo.model.Person;

@Repository
@Transactional
public class ProductJpaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Product> findAll()
	{
		// this is also one way
		return entityManager.createQuery("select p from Product p").getResultList();
		//TypedQuery<Product> namedQuery = entityManager.createNamedQuery("find_all_products", Product.class);
		//return namedQuery.getResultList();
	}
	
	public Product findById(Long id)
	{
		return entityManager.find(Product.class,id);
	}
	/*
	 * This method will update the row by checking the id. id the id is present 
	 * it will update
	 * or else it will insert.
	 */
	public Product update(Product product)
	{
		return entityManager.merge(product);
	}
	public Product insert(Product product)
	{
		return entityManager.merge(product);
	}
	
	public void deleteById(Long id)
	{
		Product product = findById(id);
		entityManager.remove(product);
	}
	public void addReviewsForProduct()
	{
		Product product = findById(1L);
		Review review1 = new Review();
		review1.setRating(4);
		review1.setDescription("Nice One");
		product.addReview(review1);
		review1.setProduct(product);
		entityManager.persist(review1);
		System.out.println(product);
	}
	//generic method
	public void addReviewsForProduct(Long courseId,List<Review> reviews)
	{
		Product product = findById(courseId);
		for(Review review: reviews) {
			product.addReview(review);
			review.setProduct(product);
			entityManager.persist(review);
		}
		System.out.println(product);
	}
	
	public void playWithEntityManager()
	{
		Product product = new Product("IFD22222");
		entityManager.persist(product);
		entityManager.flush();
		//entityManager.persist(person);
	}
}
