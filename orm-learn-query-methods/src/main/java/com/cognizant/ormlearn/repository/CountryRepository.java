package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@Repository
@Transactional
public interface CountryRepository extends JpaRepository<Country, String> {
	public List<Country> findByNameLike(String name);
	public List<Country> findByNameStartingWith(String name);
}