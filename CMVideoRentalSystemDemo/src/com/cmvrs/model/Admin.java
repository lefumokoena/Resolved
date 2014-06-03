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
@Table(name = "tblAdmin")
@PrimaryKeyJoinColumn(name = "personKey")
public class Admin extends Person implements Serializable
{

	
	private static final long serialVersionUID = 2092645026747019041L;
	
	@Column(name = "tblAdmin_UserStatus")
	private String userStatus;
	
	//Relationship
	@OneToOne
	@JoinColumn(name = "addressId")
	private Address address;

	@ManyToMany
	@JoinTable(name = "AdminAndRoles",joinColumns = @JoinColumn(name ="personKey"),
	inverseJoinColumns = @JoinColumn(name = "accessId"))
	private List<PersonnelStatus> personnelStatus;
	
	//End Relationship
				
	public Address getAddress() {
	return address;
	}



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



	public void setAddress(Address address) {
		this.address = address;
	}



	public Admin()
	{
		
	}

}
