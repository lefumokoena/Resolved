package com.cmvrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmvrs.dao.inte.MachineDao;
import com.cmvrs.model.Machine;
import com.cmvrs.service.service.MachineService;

@Service("machineService")
@Transactional(propagation = Propagation.SUPPORTS)
public class MachineServiceImpl implements MachineService
{
	@Autowired
	private MachineDao machineDao;
	
	
	public Long saveMachine(Machine machine) {
	
		return machineDao.saveMachine(machine);
	}

	
	public Machine getMachine(Long machine) {
		
	return machineDao.getMachine(machine);
	}

	
	public List<Machine> findMachineByIdName(String name) {
	
		return machineDao.findMachineByIdName(name);
	}

	
	public List<Machine> getAllMachines() {
	
		return machineDao.getAllMachines();
	}

	
	public void updateMachine(Machine machine) {
	machineDao.updateMachine(machine);
		
	}

}
