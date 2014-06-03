package com.cmvrs.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "tblEmployee")
@PrimaryKeyJoinColumn(name = "personKey")
public class Employee extends Person implements Serializable
{
	
	private static final long serialVersionUID = -3686287024077436983L;
	
	@Column(name = "tblEmployee_UserStatus")
	private String userStatus;
	
	//Relationships
	@OneToOne
	@JoinColumn(name = "Address")
	private Address address;

	public String getUserStatus() {
		return userStatus;
	}



	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}



	public List<PersonnelStatus> getPersonnelStatus() {
		return personnelStatus;
	}



	public void setPersonnelStatus(List<PersonnelStatus> personnelStatus) {
		this.personnelStatus = personnelStatus;
	}



	@ManyToMany
	@JoinTable(name = "EmployeeAndRoles",joinColumns = @JoinColumn(name ="personKey"),
	inverseJoinColumns = @JoinColumn(name = "accessId"))
	private List<PersonnelStatus> personnelStatus;
	
	//End Relationships
	
	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public Employee()
	{
	}

}
