package com.cmvrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmvrs.dao.inte.AccountDao;
import com.cmvrs.model.Account;
import com.cmvrs.service.service.AccountService;


@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS)
public class AccountServiceImpl implements AccountService
{
	@Autowired
	private AccountDao accountDao;
	
	
	public Long saveAccount(Account account) {
		
		return accountDao.saveAccount(account);
	}

	
	public Account getAccount(Long account) {
	
		return accountDao.getAccount(account);
	}

	
	public List<Account> findAccountByName(String name) {
	
		return accountDao.findAccountByName(name);
	}

	
	public List<Account> getAllAccounts() {
	
		return accountDao.getAllAccounts();
	}

	
	public void updateAccount(Account account) {
	accountDao.updateAccount(account);
		
	}

	

}
