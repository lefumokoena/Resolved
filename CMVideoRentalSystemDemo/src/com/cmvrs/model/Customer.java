package com.cmvrs.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "tblCustomer")
@PrimaryKeyJoinColumn(name = "personKey")
//@NamedQuery(name = "")
public class Customer extends Person implements Serializable
{

	private static final long serialVersionUID = -2377919678200933786L;
	
	@Column(name = "tblCustomer_UserStatus")
	private String userStatus;
	
	//Relationship
	@OneToOne
	@JoinColumn(name = "Address")
	private Address address;

	public List<VideoRental> getVideoRental() {
		return videoRental;
	}


	public void setVideoRental(List<VideoRental> videoRental) {
		this.videoRental = videoRental;
	}
	
	@OneToOne
	@JoinColumn(name = "Account")
	private Account account;
	
	@ManyToMany
	@JoinTable(name = "CustomerAndRoles",joinColumns = @JoinColumn(name ="personKey"),
	inverseJoinColumns = @JoinColumn(name = "accessId"))
	private List<PersonnelStatus> personnelStatus;
	
	@OneToMany(mappedBy = "customer",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<VideoRental> videoRental;

	@OneToMany(mappedBy="customer",cascade = CascadeType.ALL)
	private List<ReserveVideo> reserveVideo;

	
	//End Relationship
	
	public List<ReserveVideo> getReserveVideo() {
		return reserveVideo;
	}


	public void setReserveVideo(List<ReserveVideo> reserveVideo) {
		this.reserveVideo = reserveVideo;
	}


	public Address getAddress() {
		return address;
	}


	public String getUserStatus() {
		return userStatus;
	}


	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
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


	public Customer()
	{}
	
}
