package com.cmvrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmvrs.dao.inte.AdminDao;
import com.cmvrs.model.Admin;
import com.cmvrs.service.service.AdminService;

@Service("adminService")
@Transactional(propagation = Propagation.SUPPORTS)
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminDao adminDao;
	
	
	public Long saveAdmin(Admin admin) {
	
	return	adminDao.saveAdmin(admin);
	}

	
	public Admin getAdmin(Long admin) {
	
		return adminDao.getAdmin(admin);
	}

	
	public Admin findAdminByIdNumber(String idNumber) {
	
		return adminDao.findAdminByIdNumber(idNumber);
	}

	
	public List<Admin> getAllAdmins() {
	
		return adminDao.getAllAdmins();
	}

	
	public void updateAdmin(Admin admin) {
	adminDao.updateAdmin(admin);
		
	}

}
