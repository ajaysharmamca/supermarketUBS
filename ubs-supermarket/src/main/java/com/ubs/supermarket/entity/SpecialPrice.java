package com.ubs.supermarket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

//@Table(name="special_price", uniqueConstraints=
//@UniqueConstraint(columnNames={"quantity", "item_id"}))

@Table(name="special_price")

@IdClass(SpecialPricePK.class)

public class SpecialPrice {
	
//	@Id
//	@GeneratedValue
//    private Long id;
	@Id
	@Column(nullable=false)
    private int quantity = 1;
    
    @Column(nullable=false, precision=12, scale=2)
	private Double price;
    @Id
    @ManyToOne
	private Item item;
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public SpecialPrice() {
	}

	public SpecialPrice(Double price) {
		this.price = price;
	}

	public SpecialPrice(int quantity, Double price) {
		this(price);
		this.quantity = quantity;
	}

	/*public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}*/

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	

}
