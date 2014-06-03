package com.cmvrs.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmvrs.dao.inte.AdminDao;
import com.cmvrs.model.Admin;


@Repository("adminDao")
@Transactional(propagation = Propagation.SUPPORTS)
public class AdminDaoImpl implements AdminDao
{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly= false,propagation = Propagation.REQUIRED)
	public Long saveAdmin(Admin admin) {
		
		sessionFactory.openSession();
		
		sessionFactory.getCurrentSession().save(admin);
		
		return admin.getPersonKey();
	}
	
	@Transactional(readOnly= true)
	public Admin getAdmin(Long admin) {
	
		return (Admin)sessionFactory.getCurrentSession().get(Admin.class, admin);
	}
	
	@Transactional(readOnly= true)
	public Admin findAdminByIdNumber(String idNumber) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Admin.class);
		
		criteria.add(Restrictions.eq("idNumber", idNumber));
		
		return (Admin)criteria.uniqueResult();
	}
	
	@Transactional(readOnly= true)
	@SuppressWarnings("unchecked")
	public List<Admin> getAllAdmins() {
		
		return (List<Admin>)sessionFactory.getCurrentSession().createCriteria(Admin.class).list();
	}

	@Transactional(readOnly= false)
	public void updateAdmin(Admin admin) {
		sessionFactory.getCurrentSession().update(admin);
		
	}

		
}
