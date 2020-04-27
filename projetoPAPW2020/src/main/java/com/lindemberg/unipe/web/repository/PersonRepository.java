package com.lindemberg.unipe.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lindemberg.unipe.web.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	public List<Person> findPersonByFirstNameAndEmail(String firstName, String email);
	
	public List<Person> findPersonByFirstNameAndLastName(String firstName, String lastName);
	
	public List<Person> findPersonByFirstNameAndPhoneNumber(String firstName, String phoneNumber);
		
	
}
