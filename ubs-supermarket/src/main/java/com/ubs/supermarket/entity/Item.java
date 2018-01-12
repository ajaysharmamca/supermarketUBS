package com.ubs.supermarket.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="item" , uniqueConstraints = { @UniqueConstraint(columnNames = "NAME") })

public class Item {
	
	@Id
	@GeneratedValue
	private Long id;
    
	@Column(unique=true, nullable=false, length=100)
	private String name;
	
	@Column(nullable=false, precision=12, scale=2)
	private Double price;

	@UpdateTimestamp
	private Timestamp  lastUpdatedDate;
	
	@CreationTimestamp
	private Timestamp  createdDate;

	
	@OneToMany(mappedBy="item", fetch=FetchType.EAGER)
	@OrderBy("quantity DESC")
	
	List<SpecialPrice> specialPrices = new ArrayList<>();
	
	public Item() {
	}
	public Item(String name) {
		this.name = name;
	}
	public Item(String name, Double price) {
		this(name);
		addPrice(new SpecialPrice(price));
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Timestamp  getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Timestamp  lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Timestamp  getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp  createdDate) {
		this.createdDate = createdDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void addPrice(SpecialPrice price) {
		this.specialPrices.add(price);
	}

	public void removePrice(SpecialPrice price) {
		this.specialPrices.remove(price);
	}
	
	public List<SpecialPrice> getPrices() {
		return this.specialPrices;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastUpdatedDate == null) ? 0 : lastUpdatedDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((specialPrices == null) ? 0 : specialPrices.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastUpdatedDate == null) {
			if (other.lastUpdatedDate != null)
				return false;
		} else if (!lastUpdatedDate.equals(other.lastUpdatedDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (specialPrices == null) {
			if (other.specialPrices != null)
				return false;
		} else if (!specialPrices.equals(other.specialPrices))
			return false;
		return true;
	}

}
