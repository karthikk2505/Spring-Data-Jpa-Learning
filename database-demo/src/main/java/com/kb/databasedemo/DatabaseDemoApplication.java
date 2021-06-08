package com.kb.databasedemo;



import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.sql.ordering.antlr.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.transaction.annotation.Transactional;

import com.kb.databasedemo.jpa.EmployeeJpaRepository;
import com.kb.databasedemo.jpa.PassportJpaRepository;
import com.kb.databasedemo.jpa.PersonJpaRepository;
import com.kb.databasedemo.jpa.PersonJpaRepository2;
import com.kb.databasedemo.jpa.ProductJpaRepository;
import com.kb.databasedemo.model.FullTimeEmployee;
import com.kb.databasedemo.model.PartTimeEmployee;
import com.kb.databasedemo.model.Passport;
import com.kb.databasedemo.model.Person;
import com.kb.databasedemo.model.Product;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner{

	@Autowired
	PersonJpaRepository repository;
	@Autowired
	PersonJpaRepository2 repository2;
	
	@Autowired
	ProductJpaRepository productRepo;
	
	@Autowired
	PassportJpaRepository passRepo;
	@Autowired
	EmployeeJpaRepository employeeRepo;
	
	Logger logger = LoggerFactory.getLogger(DatabaseDemoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}
	@Override
	@Transactional // this is adding because when the repository findById method executes
	// the session gets closed after that line but we are calling passport object internally by calling the person object in the logger.
	//so that we cannot fetch the passport data while using lazy fetching so that we have
	// to make the function transactional hence session will be persist
	public void run(String... args) throws Exception {
		logger.info("Logging using slf4j logger");
		//logger.info("findById by repository1: {}",repository.findById(10001));
		//logger.info("findById by repository2: {}",repository2.findById(10001));
		//inserting
		//logger.info("Updating by repository1: {}",repository.update(new Person(10005,"haysel","metravel",new Timestamp(new Date().getTime()))));
		//logger.info("Inserting by repository1: {}",repository.insert(new Person(10007,"bob","indonesia",new Timestamp(new Date().getTime()))));
		//logger.info("findAll by repository1: {}",repository.findAll());
		//logger.info("findAll by repository2: {}",repository2.findAll());
		//repository.playWithEntityManager();
		//logger.info("EntityManager Feature by repository find by Location: {}",repository2.findByLocation("Banglore"));
		//oneto one relationship
		//passRepo.playWithEntityManager();
		//retriving the one to one data from table.
		//Person person = repository.findById(22);
		// it will get the passport data fully and convert that also into passport object
		//by default it will do left outer join
		//logger.info("One to one relation Person Data along with Passport:{}",person);
		// a seperate query will be executed when we explicitly need the passport object.( thats how lazy fetching helpful
		//logger.info("One to one relation fetching Passport:{}",person.getPassport());
		//Getting stuudent details through pass port object so using biderectional
		//Passport passport = passRepo.findById(29L);
		//logger.info("One to one relation fetching Passport:{}",passport);
		//logger.info("One to one relation fetching Passport:{}",passport.getPerson());
		//--------------------------------------------------------------------------------------
		
		//oNE TO Many Product to reviews:
		//productRepo.addReviewsForProduct();
		//Product product = productRepo.findById(1L);
		//System.out.println(product);
		//System.out.println(product.getReviews());
		
		//Many to Many Relationship
		//Person person = repository.findById(30);
		//System.out.println(person);
		//System.out.println(person.getProducts()); 
		// inserting
		//Person person = new Person("kb","Canada",new Timestamp(new Date().getTime()));
		//Product product = new Product("Oneplus");
		//repository.insertPersonAndCource(person, product);
		//----------Inheritance----------------------------------
		employeeRepo.insert(new FullTimeEmployee("Kell", new BigDecimal("10000")));
		employeeRepo.insert(new PartTimeEmployee("Nike", new BigDecimal("1000")));
		System.out.println(employeeRepo.retriveAllEmployee());
		//------------------MAppedSuperClass--------------
		// this will create two individual table which has the required field like fulltimeemployee table has name ,id, salary.
		// there is no relationship between the employee in database.
		System.out.println(employeeRepo.retriveAllFullTimeEmployee());
		System.out.println(employeeRepo.retriveAllPartTimeEmployee());
		/*
		 * if Data integrity matters we can go with inheritance like non nullable.
		 * if performance matters we can go with MappedSuperClass
		 */
	}
	
	
}
// if we give ddl.auto =update if the table does not exists it will update and it will create table and insert data