package com.cmvrs.service.service;

import java.util.List;

import com.cmvrs.model.Person;

public interface PersonService {

	Long savePerson(Person person);
	Person getPerson(Long person);
	Person findPersonByIdNumber(String idNumber);
	List<Person> getAllPersons();
	void updatePerson(Person person);
	
}
