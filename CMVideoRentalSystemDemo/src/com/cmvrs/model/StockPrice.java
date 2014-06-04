package com.cmvrs.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tblStockPrice")
public class StockPrice implements Serializable
{
	private static final long serialVersionUID = 2526065646827485239L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="tblStockPrice_PriceID")
	private Long priceID;
	
	@Column(name ="tblStockPrice_PriceType")
	private String priceType;
	
	@Column(name ="tblStockPrice_Price")
	private double price;

	//Relationship
	
	@OneToMany(mappedBy = "stockPrice", cascade = CascadeType.ALL)
	private List<Video> video;
	
	@OneToMany(mappedBy = "stockPrice", cascade = CascadeType.ALL)
	private List<Machine> machine;
	
	//End Relationship
	
	
	public Long getPriceID() {
		return priceID;
	}

	public List<Video> getVideo() {
		return video;
	}

	public void setVideo(List<Video> video) {
		this.video = video;
	}

	public List<Machine> getMachine() {
		return machine;
	}

	public void setMachine(List<Machine> machine) {
		this.machine = machine;
	}

	public void setPriceID(Long priceID) {
		this.priceID = priceID;
	}

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public StockPrice() {
	}
	
}
