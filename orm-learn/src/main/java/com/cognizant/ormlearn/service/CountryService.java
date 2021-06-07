package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

/*
 * Spring data JPA Hands on 1 to 9:
 */
@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Transactional
	public List<Country> getAllCountries()
	{
		List<Country> result = countryRepository.findAll();
		return result;
	}
	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException{
		Optional<Country> result = countryRepository.findById(countryCode);
		Country country=null;
		if (result.isPresent())
		{
			 country= result.get();
			 return country;
		}
		else 
			throw new CountryNotFoundException("Country Code Not Found");
		//return country;
	}
	@Transactional
	public void addCountry(Country country) {
		countryRepository.save(country);
	}
	@Transactional
	public void updateCountry(Country country) {
		countryRepository.save(country);
	}
	@Transactional
	public void deleteCountry(String id) {
		countryRepository.deleteById(id);
	}
}
