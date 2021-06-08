package com.kb.databasedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kb.databasedemo.model.Person;

@Repository
@Transactional
public interface PersonJpaRepository2 extends JpaRepository<Person, Integer>{
	
	//@PersistenceContext
	//private EntityManager entityManager;
	public List<Person> findByLocation(String location);
}
