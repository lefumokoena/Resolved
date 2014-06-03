package com.cmvrs.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tblMachine")
public class Machine implements Serializable
{

	private static final long serialVersionUID = 3309103779186886905L;
	
	@Id
	@GeneratedValue
	@Column(name = "tblMachine_MachineId")
	private Long machineId;
	
	@Column(name = "tblMachine_MachineType")
	private String machineType;
	
	@NotNull(message = "enter machine name")
	@Column(name = "tblMachine_Name")
	private String name;
	
	@Column(name = "tblMachine_Description")
	private String description;
	
	@NotNull(message = "Enter model number")
	@Column(name = "tblMachine_ModelNumber")
	private String modelNumber;

	@NotNull(message = "Enter number f copies")
	@Column(name = "tblMachine_NumOfCopies")
	private int numOfCopies;
	
	@NotNull(message = "Enter number f copies")
	@Column(name = "tblMachine_NumOfCopiesDamaged")
	private int numOfCopiesDamaged;
	
	public Set<VideoRental> getVideoRental() {
		return videoRental;
	}

	public void setVideoRental(Set<VideoRental> videoRental) {
		this.videoRental = videoRental;
	}

	//Relationship
	@OneToOne
	@JoinColumn(name = "PriceID")
	private StockPrice stockPrice;

	@OneToMany(mappedBy ="machine", cascade = CascadeType.ALL)
	private Set<VideoRental> videoRental;
	
	@OneToMany(mappedBy ="machine", cascade = CascadeType.ALL)
	private Set<ReserveVideo> reserveVideo;

	
	//End Relationship
	
	public Long getMachineId() {
		return machineId;
	}

	public Set<ReserveVideo> getReserveVideo() {
		return reserveVideo;
	}

	public void setReserveVideo(Set<ReserveVideo> reserveVideo) {
		this.reserveVideo = reserveVideo;
	}

	public void setMachineId(Long machineId) {
		this.machineId = machineId;
	}

	public String getMachineType() {
		return machineType;
	}

	public void setMachineType(String machineType) {
		this.machineType = machineType;
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

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public StockPrice getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(StockPrice stockPrice) {
		this.stockPrice = stockPrice;
	}
	
	
	public int getNumOfCopies() {
		return numOfCopies;
	}

	public void setNumOfCopies(int numOfCopies) {
		this.numOfCopies = numOfCopies;
	}

	
	
	public int getNumOfCopiesDamaged() {
		return numOfCopiesDamaged;
	}

	public void setNumOfCopiesDamaged(int numOfCopiesDamaged) {
		this.numOfCopiesDamaged = numOfCopiesDamaged;
	}

	public Machine() {
	} 
	
	

}
