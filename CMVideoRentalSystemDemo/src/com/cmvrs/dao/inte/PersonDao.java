package com.cmvrs.dao.inte;

import java.util.List;

import com.cmvrs.model.Person;

public interface PersonDao {
	
	Long savePerson(Person person);
	Person getPerson(Long person);
	Person findPersonByIdNumber(String idNumber);
	List<Person> getAllPersons();
	void updatePerson(Person person);
}
