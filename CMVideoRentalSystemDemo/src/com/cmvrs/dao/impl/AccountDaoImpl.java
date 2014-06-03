package com.cmvrs.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmvrs.dao.inte.AccountDao;
import com.cmvrs.model.Account;

@Repository("accountDao")
@Transactional(propagation = Propagation.SUPPORTS)
public class AccountDaoImpl implements AccountDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly= false,propagation = Propagation.REQUIRED)
	public Long saveAccount(Account account) {
		sessionFactory.openSession();
		sessionFactory.getCurrentSession().save(account);
		return account.getAccountId();
	}

	@Transactional(readOnly= true)
	public Account getAccount(Long account) {
		
		return (Account)sessionFactory.getCurrentSession().get(Account.class,account );
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly= true)
	public List<Account> findAccountByName(String name) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Account.class);

		criteria.add(Restrictions.like("accountType", name));
		
		return (List<Account>)criteria.list();

	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly= true)
	public List<Account> getAllAccounts() {
		return (List<Account>)sessionFactory.getCurrentSession().createCriteria(Account.class).list();
	}

	@Transactional(readOnly= false)
	public void updateAccount(Account account) {
		sessionFactory.getCurrentSession().update(account);
		
	}

}
