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
@Table(name = "tblVideoRental")
public class VideoRental implements Serializable
{

	private static final long serialVersionUID = -2500655592771719584L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tblVideoRental_RentalId")
	private Long rentalId;
	
	@NotNull(message= "Enter movie copy number")
	@Column(name = "tblVideoRental_CopyOfMovie")
	private int copyOfMovie;
	
	@NotNull(message = "Enter booking status")
	@Column(name = "tblVideoRental_MovieRentalStatus")
	private String movieRentalStatus;
	
	@NotNull(message = "Enter number of days of the movie to be rented")
	@Column(name = "tblVideoRental_NumberOfDaysOfMovie")
	private int numberOfDaysOfMovie; 
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tblVideoRental_RentalDate",nullable = false)
	private Date rentalDate;
	
	//Relationships
	@ManyToMany(mappedBy = "videoRental", cascade = CascadeType.ALL)
	private List<Customer> customer;
	
	@ManyToOne
	@JoinColumn(name = "movieId")
	private Video video;
	
	@ManyToOne
	@JoinColumn(name = "machineId")
	private Machine machine;
	//End Relationships

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public VideoRental() {
	}

	public Long getRentalId() {
		return rentalId;
	}

	public void setRentalId(Long rentalId) {
		this.rentalId = rentalId;
	}

	public int getCopyOfMovie() {
		return copyOfMovie;
	}

	public void setCopyOfMovie(int copyOfMovie) {
		this.copyOfMovie = copyOfMovie;
	}

	public String getMovieRentlStatus() {
		return movieRentalStatus;
	}

	public void setMovieRentalStatus(String movieRentalStatus) {
		this.movieRentalStatus = movieRentalStatus;
	}

	public int getNumberOfDaysOfMovie() {
		return numberOfDaysOfMovie;
	}

	public void setNumberOfDaysOfMovie(int numberOfDaysOfMovie) {
		this.numberOfDaysOfMovie = numberOfDaysOfMovie;
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
	
	
	
	
}
