package com.cmvrs.dao.inte;

import java.util.List;

import com.cmvrs.model.Machine;

public interface MachineDao {

	Long saveMachine(Machine machine);
	Machine getMachine(Long machine);
	List<Machine> findMachineByIdName(String name);
	List<Machine> getAllMachines();
	void updateMachine(Machine machine);
	
}
