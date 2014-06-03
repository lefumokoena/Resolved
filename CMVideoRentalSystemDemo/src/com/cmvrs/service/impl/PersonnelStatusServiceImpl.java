package com.cmvrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmvrs.dao.inte.PersonnelStatusDao;
import com.cmvrs.model.PersonnelStatus;
import com.cmvrs.service.service.PersonnelStatusService;

@Service("personnelStatusService")
@Transactional(propagation = Propagation.SUPPORTS)
public class PersonnelStatusServiceImpl implements PersonnelStatusService
{
	@Autowired
	private PersonnelStatusDao personnelStatusDao;
	
	
	public Long savePersonnelStatus(PersonnelStatus personnelStatus) {

		return personnelStatusDao.savePersonnelStatus(personnelStatus);
	}

	
	public PersonnelStatus getPersonnelStatus(Long personnelStatus) {
	
		return personnelStatusDao.getPersonnelStatus(personnelStatus);
	}

	
	public List<PersonnelStatus> findPersonnelStatusByRole(String role) {
	
		return personnelStatusDao.findPersonnelStatusByRole(role);
	}

	
	public List<PersonnelStatus> getAllPersonnelStatuss() {
	
		return personnelStatusDao.getAllPersonnelStatuss();
	}

	
	public void updatePersonnelStatus(PersonnelStatus personnelStatus) {
	personnelStatusDao.updatePersonnelStatus(personnelStatus);
		
	}

}
