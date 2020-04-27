package com.example.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String description, BigDecimal price, String imageUrl) {
		super();
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
