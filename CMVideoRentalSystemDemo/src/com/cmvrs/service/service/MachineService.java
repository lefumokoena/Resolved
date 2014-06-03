package com.cmvrs.service.service;

import java.util.List;

import com.cmvrs.model.Machine;

public interface MachineService {

	Long saveMachine(Machine machine);
	Machine getMachine(Long machine);
	List<Machine> findMachineByIdName(String name);
	List<Machine> getAllMachines();
	void updateMachine(Machine machine);
	
}
