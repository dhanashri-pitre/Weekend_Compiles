package com.october20.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.october20.Entity.Student;
import com.october20.Entity.StudentRepository;

@SpringBootApplication(scanBasePackages={"com.october20"})
@EnableJpaRepositories(basePackages = {"com.october20"})
@EntityScan(basePackages = {"com.october20"})
public class SpringBoot2JPAWithHibernateAndH2Application implements CommandLineRunner{
	
	//http://www.springboottutorial.com/hibernate-jpa-tutorial-with-spring-boot-starter-jpa : Tutorial Referred
	public SpringBoot2JPAWithHibernateAndH2Application() {
		// TODO Auto-generated constructor stub
	}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2JPAWithHibernateAndH2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Code to run at application startup
		
		logger.info("Student id 10001 -> {}", repository.findById(10001L));
		
		logger.info("All users 1 -> {}", repository.findAll());
		
		//Insert
		logger.info("Inserting -> {}", repository.save(new Student("John", "A1234657")));

		//Update
		logger.info("Update 10001 -> {}", repository.save(new Student(10001L, "Name-Updated", "New-Passport")));

		repository.deleteById(10002L);
		
		logger.info("All users 2 -> {}", repository.findAll());
	}

}
