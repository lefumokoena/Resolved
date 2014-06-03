package com.cmvrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmvrs.dao.inte.PersonDao;
import com.cmvrs.model.Person;
import com.cmvrs.service.service.PersonService;

@Service("personService")
@Transactional(propagation = Propagation.SUPPORTS)
public class PersonServiceImpl implements PersonService
{
	@Autowired
	private PersonDao personDao;
	
	
	public Long savePerson(Person person) {
	
		return personDao.savePerson(person);
	}

	
	public Person getPerson(Long person) {
	
		return personDao.getPerson(person);
	}

	
	public Person findPersonByIdNumber(String idNumber) {
	
		return personDao.findPersonByIdNumber(idNumber);
	}

	
	public List<Person> getAllPersons() {
	
		return personDao.getAllPersons();
	}

	
	public void updatePerson(Person person) {
	personDao.updatePerson(person);
		
	}

}
