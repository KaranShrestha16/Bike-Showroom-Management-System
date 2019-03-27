package com.bikeshowroom.karan.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="product")
public class productModel {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int product_id;
	
	@Column(name = "productName", nullable = false,length=50)
	private String productName;
	
	@Column(name = "companyName", nullable = false,length=50)
	private String companyName;
	
	@Column(name = "avaibility", nullable = false,length=10)
	private String avaibility;
	
	@Column(name = "cc", nullable = false,length=10)
	private int cc;
	
	@Column(name = "color", nullable = false ,length=50)
	private String color;
	@Column(name = "quantity", nullable = false)
	private int quantity;
	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAvaibility() {
		return avaibility;
	}

	public void setAvaibility(String avaibility) {
		this.avaibility = avaibility;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	
	  
	
}
