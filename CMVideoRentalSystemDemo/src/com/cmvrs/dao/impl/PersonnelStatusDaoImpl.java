package com.cmvrs.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmvrs.dao.inte.PersonnelStatusDao;
import com.cmvrs.model.PersonnelStatus;

@Repository("personnelStatusDao")
@Transactional(propagation = Propagation.SUPPORTS)
public class PersonnelStatusDaoImpl implements PersonnelStatusDao
{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly= false,propagation = Propagation.REQUIRED)
	public Long savePersonnelStatus(PersonnelStatus personnelStatus) {
		sessionFactory.openSession();
		sessionFactory.getCurrentSession().save(personnelStatus);
		return	personnelStatus.getAccessId();
			}

	@Transactional(readOnly= true)
	public PersonnelStatus getPersonnelStatus(Long personnelStatus) {
		
		return (PersonnelStatus)sessionFactory.getCurrentSession().get(PersonnelStatus.class, personnelStatus);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly= true)
	public List<PersonnelStatus> findPersonnelStatusByRole(String role) {
		/*Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PersonnelStatus.class);

		criteria.add(Restrictions.like("accessType", role));
		
		return (List<PersonnelStatus>)criteria.list();
*/		
		Query query = sessionFactory.getCurrentSession().getNamedQuery("PersonnelStatus.ByRole");
		
		query.setInteger(0, 1);
			
		return (List<PersonnelStatus>)query.list();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly= true)
	public List<PersonnelStatus> getAllPersonnelStatuss() {
		
		return (List<PersonnelStatus>)sessionFactory.getCurrentSession().createCriteria(PersonnelStatus.class).list();
	}

	@Transactional(readOnly= false)
	public void updatePersonnelStatus(PersonnelStatus personnelStatus) {
		sessionFactory.getCurrentSession().update(personnelStatus);
		
	}

}
