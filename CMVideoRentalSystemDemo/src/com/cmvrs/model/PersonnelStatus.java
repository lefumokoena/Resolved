package com.cmvrs.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "tblPersonnelStatus")
@NamedQuery(name ="PersonnelStatus.ByRole", 
			query ="from PersonnelStatus where accessId = ? ")
//@NamedNativeQuery(name="")
public class PersonnelStatus implements Serializable
{

	private static final long serialVersionUID = 2660165753073447395L;
	
	//Standard attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tblPersonnelStatus_AccessId")
	private Long accessId;
	
	@NotNull(message ="Enter role of the user")
	@Column(name = "tblPersonnelStatus_AccessType", unique = true)
	private String accessType;
	
	//End Standard attributes
	
	//Relationships
	
	@ManyToMany(mappedBy = "personnelStatus", cascade = CascadeType.ALL)
	private List<Admin> admin;
	
	@ManyToMany(mappedBy = "personnelStatus", cascade = CascadeType.ALL)
	private List<Employee> employee;
	
	@ManyToMany(mappedBy = "personnelStatus", cascade = CascadeType.ALL)
	private List<Customer> customer;
	//End Relationships

	public Long getAccessId() {
		return accessId;
	}

	public void setAccessId(Long accessId) {
		this.accessId = accessId;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public List<Admin> getAdmin() {
		return admin;
	}

	public void setAdmin(List<Admin> admin) {
		this.admin = admin;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public PersonnelStatus() {
	}
	
	
}
