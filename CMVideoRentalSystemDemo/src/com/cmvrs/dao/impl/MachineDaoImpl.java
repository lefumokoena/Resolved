package com.cmvrs.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmvrs.dao.inte.MachineDao;
import com.cmvrs.model.Machine;

@Repository("machineDao")
@Transactional(propagation = Propagation.SUPPORTS)
public class MachineDaoImpl implements MachineDao
{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly= false,propagation = Propagation.REQUIRED)
	public Long saveMachine(Machine machine) {
		sessionFactory.openSession();
		
		sessionFactory.getCurrentSession().save(machine);
		
		return machine.getMachineId();
	}

	@Transactional(readOnly= true)
	public Machine getMachine(Long machine) {
		return (Machine)sessionFactory.getCurrentSession().get(Machine.class, machine);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly= true)
	public List<Machine> findMachineByIdName(String name) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Machine.class);
		
		criteria.add(Restrictions.eq("name", name));
		
		return (List<Machine>)criteria.list();
	}

	@Transactional(readOnly= true)
	@SuppressWarnings("unchecked")
	public List<Machine> getAllMachines() {
		return (List<Machine>)sessionFactory.getCurrentSession().createCriteria(Machine.class).list();
	}

	@Transactional(readOnly= false)
	public void updateMachine(Machine machine) {
		sessionFactory.getCurrentSession().update(machine);
		
	}

}
