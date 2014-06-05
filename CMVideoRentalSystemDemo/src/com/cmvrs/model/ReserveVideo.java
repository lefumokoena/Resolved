package com.cmvrs.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tblReserve")
public class ReserveVideo implements Serializable
{

	private static final long serialVersionUID = -5479407436840146517L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tblReserve_ReserveId")
	private Long reserveId;
	
	@NotNull(message= "Enter movie copy number")
	@Column(name = "tblReserve_CopyOfMovie")
	private int copyOfMovie;
	
	@NotNull(message = "Enter booking status")
	@Column(name = "tblReserve_MovieBookingStatus")
	private String movieBookingStatus;
	
	@NotNull(message = "Enter number of days of the movie to be rented")
	@Column(name = "tblReserve_NumberOfDaysOfMovie")
	private int numberOfDaysOfMovie; 
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tblReserve_BookingDate",nullable = false)
	private Date bookingDate;
	
	//Relationships
	@ManyToOne
	@JoinColumn(name = "personKey")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "movieId")
	private Video video;
	
	@ManyToOne
	@JoinColumn(name = "machineId")
	private Machine machine;
	//End Relationships

	public Long getReserveId() {
		return reserveId;
	}

	public void setReserveId(Long reserveId) {
		this.reserveId = reserveId;
	}

	public int getCopyOfMovie() {
		return copyOfMovie;
	}

	public void setCopyOfMovie(int copyOfMovie) {
		this.copyOfMovie = copyOfMovie;
	}

	public String getMovieBookingStatus() {
		return movieBookingStatus;
	}

	public void setMovieBookingStatus(String movieBookingStatus) {
		this.movieBookingStatus = movieBookingStatus;
	}

	public int getNumberOfDaysOfMovie() {
		return numberOfDaysOfMovie;
	}

	public void setNumberOfDaysOfMovie(int numberOfDaysOfMovie) {
		this.numberOfDaysOfMovie = numberOfDaysOfMovie;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public ReserveVideo() {
	}
	
	

}
