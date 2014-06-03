package com.cmvrs.service.service;

import java.util.List;

import com.cmvrs.model.PersonnelStatus;

public interface PersonnelStatusService {

	Long savePersonnelStatus(PersonnelStatus personnelStatus);
	PersonnelStatus getPersonnelStatus(Long personnelStatus);
	List<PersonnelStatus> findPersonnelStatusByRole(String role);
	List<PersonnelStatus> getAllPersonnelStatuss();
	void updatePersonnelStatus(PersonnelStatus personnelStatus);
	
}
