package com.cmvrs.dao.inte;

import java.util.List;

import com.cmvrs.model.PersonnelStatus;

public interface PersonnelStatusDao {
	
	Long savePersonnelStatus(PersonnelStatus personnelStatus);
	PersonnelStatus getPersonnelStatus(Long personnelStatus);
	List<PersonnelStatus> findPersonnelStatusByRole(String role);
	List<PersonnelStatus> getAllPersonnelStatuss();
	void updatePersonnelStatus(PersonnelStatus personnelStatus);
}
