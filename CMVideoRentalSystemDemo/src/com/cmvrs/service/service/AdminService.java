package com.cmvrs.service.service;

import java.util.List;

import com.cmvrs.model.Admin;

public interface AdminService {

	Long saveAdmin(Admin admin);
	Admin getAdmin(Long admin);
	Admin findAdminByIdNumber(String idNumber);
	List<Admin> getAllAdmins();
	void updateAdmin(Admin admin);
	
}
