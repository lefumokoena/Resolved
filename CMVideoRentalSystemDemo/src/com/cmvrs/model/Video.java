package com.cmvrs.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tblVideo")
public class Video implements Serializable
{
	private static final long serialVersionUID = 3079691357990829446L;
	
	@Id
	@GeneratedValue
	@Column(name = "tblVideo_MovieId")
	private Long movieId;
		
	@Column(name = "tblVideo_VideoType")
	private String videoType;
	
	@NotNull(message = "Enter video name")
	@Column(name = "tblVideo_Name")
	private String name;
	
	@NotNull(message = "Enter video description")
	@Column(name = "tblVideo_Description")
	private String description;
	
	@NotNull(message = "Enter age restriction")
	@Column(name = "tblVideo_AgeRestriction")
	private String ageRestriction;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tblVideo_ReleaseDate")
	private Date releaseDate;

	@NotNull(message = "Enter number of copies")
	@Column(name = "tblVideo_Copies")
	private int numOfCopies;
	
	
	@Column(name = "tblVideo_CopiesDamaged")
	private int numOfCopiesDamaged;

	//Relationship
	
	@OneToOne
	@JoinColumn(name = "PriceID")
	private StockPrice stockPrice; 
	
	@OneToMany(mappedBy="video", cascade = CascadeType.ALL)
	private Set<VideoRental> videoRental;
	
	@OneToMany(mappedBy="video", cascade = CascadeType.ALL)
	private Set<ReserveVideo> reserveVideo;
	
	//Relationship
	
	
	
	public String getVideoType() {
		return videoType;
	}

	public int getNumOfCopiesDamaged() {
		return numOfCopiesDamaged;
	}

	public void setNumOfCopiesDamaged(int numOfCopiesDamaged) {
		this.numOfCopiesDamaged = numOfCopiesDamaged;
	}

	public int getNumOfCopies() {
		return numOfCopies;
	}

	public void setNumOfCopies(int numOfCopies) {
		this.numOfCopies = numOfCopies;
	}

	public Set<ReserveVideo> getReserveVideo() {
		return reserveVideo;
	}

	public void setReserveVideo(Set<ReserveVideo> reserveVideo) {
		this.reserveVideo = reserveVideo;
	}

	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}

	public StockPrice getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(StockPrice stockPrice) {
		this.stockPrice = stockPrice;
	}

	
	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAgeRestriction() {
		return ageRestriction;
	}

	public void setAgeRestriction(String ageRestriction) {
		this.ageRestriction = ageRestriction;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	

	public Set<VideoRental> getVideoRental() {
		return videoRental;
	}

	public void setVideoRental(Set<VideoRental> videoRental) {
		this.videoRental = videoRental;
	}

	public Video() {
		
	}
	
	
}
