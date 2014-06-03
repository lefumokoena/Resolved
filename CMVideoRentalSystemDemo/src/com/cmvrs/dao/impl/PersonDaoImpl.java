package com.cmvrs.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmvrs.dao.inte.PersonDao;
import com.cmvrs.model.Person;


@Repository("personDao")
@Transactional(propagation = Propagation.SUPPORTS)
public class PersonDaoImpl implements PersonDao
{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly= false,propagation = Propagation.REQUIRED)
	public Long savePerson(Person person) {
		
		sessionFactory.openSession();
		
		sessionFactory.getCurrentSession().save(person);
		
		return person.getPersonKey();
	}

	@Transactional(readOnly= true)
	public Person getPerson(Long person) {
		
		return (Person)sessionFactory.getCurrentSession().get(Person.class, person);
	}

	@Transactional(readOnly= true)
	public Person findPersonByIdNumber(String idNumber) {
	
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Person.class);
		
		criteria.add(Restrictions.eq("idNumber", idNumber));
		
		return (Person)criteria.uniqueResult();
	}

	@Transactional(readOnly= true)
	@SuppressWarnings("unchecked")
	public List<Person> getAllPersons() {
	
		return (List<Person>)sessionFactory.getCurrentSession().createCriteria(Person.class).list();
	}

	@Transactional(readOnly= false)
	public void updatePerson(Person person) {
		sessionFactory.getCurrentSession().update(person);
		
	}	
	
}
