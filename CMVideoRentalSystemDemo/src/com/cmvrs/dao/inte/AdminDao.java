package com.cmvrs.dao.inte;

import java.util.List;

import com.cmvrs.model.Admin;

public interface AdminDao {

	Long saveAdmin(Admin admin);
	Admin getAdmin(Long admin);
	Admin findAdminByIdNumber(String idNumber);
	List<Admin> getAllAdmins();
	void updateAdmin(Admin admin);
}
