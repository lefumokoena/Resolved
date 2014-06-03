package com.cmvrs.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tblAddress")
public class Address implements Serializable
{
	
	private static final long serialVersionUID = -4008605595988376248L;
	
	//Standard Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tblAddress_AddressId")
	private Long addressId;
	
	@NotNull(message = "house number and street name must be provided")
	@Column(name = "tblAddress_StreetName")
	private String streetName;
	
	@NotNull(message = "surburb name must be provided")
	@Column(name = "tblAddress_Surburb")
	private String surburb;
	
	@NotNull(message = "city or town name must be provided")
	@Column(name = "tblAddress_Town")
	private String town;
	
	@Column(name = "tblAddress_PostalCode")
	private String postalCode;
	//End Standard Attributes
	
	public Address() {
	
	}

	
	
	//Relatioinships
	
	@OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
	private Admin admin;
	
	@OneToOne(mappedBy = "address", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Employee employee;
	
	@OneToOne(mappedBy = "address", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Customer customer;
	
	//End Relatioinships
	
	
	
	//Standard Getters and Setters
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getSurburb() {
		return surburb;
	}

	public void setSurburb(String surburb) {
		this.surburb = surburb;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}	
	
	//Standard Getters and Setters

	
	
}
