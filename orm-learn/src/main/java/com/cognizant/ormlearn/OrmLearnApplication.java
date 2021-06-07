package com.cognizant.ormlearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	
	@Autowired
	private static CountryService countryService;
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		LOGGER.info("Inside main");
		countryService = context.getBean(CountryService.class);
		//testGetAllCountries();
		getAllCountriesTest();
		testAddCountry();
	}
	private static void testGetAllCountries() {

		LOGGER.info("Start");

		List<Country> countries = countryService.getAllCountries();
		
		LOGGER.debug("countries={}", countries);

		LOGGER.info("End");

	}
	private static void getAllCountriesTest()  {

		LOGGER.info("Start");

		Country country = null;
		try {
			country = countryService.findCountryByCode("AD");
			LOGGER.debug("Country:{}", country);
		} catch (CountryNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LOGGER.info("End");

		}
	private static void testAddCountry()
	{
		Country country = new Country();
		country.setCode("ZQ");
		country.setName("Zetopia");
		countryService.addCountry(country);
	}
}
