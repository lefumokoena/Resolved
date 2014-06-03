package com.cmvrs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;


@Entity
@Table(name = "tblPerson")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Serializable
{

	private static final long serialVersionUID = -6808357505912604111L;
	
	//Attributes
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column(name= "tblPerson_PersonKey")
	private Long personKey;
		
	@Column(name ="tblPerson_Title")
	private String title;
	
	@Column(name ="tblPerson_Name")
	private String name;
	
	@Column(name ="tblPerson_Surname")
	private String surname;
	
	@NotNull(message = "Enter ID Number")
	@Column(name = "tblPerson_IdNumber",unique = true, nullable=false)
	private String idNumber;
	
	@NotNull(message = "Enter username")
	@Column(name = "tblPerson_Username", unique = true)
	private String username;
	
	@NotNull(message = "Enter password")
	@Size(min = 6, max = 15, message = "Password must have 6 to 10 Characters")
	@Column(name = "tblPerson_Password")
	private String password;
	
	@Email(message = "email must be unique")
	@Column(name = "tblPerson_Email")
	private String email;
	
	@Column(name ="tblPerson_WorkPhone")
	private String workPhone;
	
	@Column(name ="tblPerson_HomePhone")
	private String homePhone;
	
	@Column(name ="tblPerson_mobilePhone")
	private String mobilePhone;
	
	//End Attributes
		
	
	//Relationship Attributes
	
	
	//Relationship Attributes
	
	
	public Person() {}

	//Standard Getters and Setters
	
	public Long getPersonKey() {
		return personKey;
	}

	public void setPersonKey(Long personKey) {
		this.personKey = personKey;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
	//End Standard Getters and Setters
	
	
	
	
	
}
