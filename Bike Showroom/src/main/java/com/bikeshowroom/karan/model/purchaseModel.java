package com.bikeshowroom.karan.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.cfg.CreateKeySecondPass;
@Entity
@Table(name="purchase")
public class purchaseModel {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int purchase_id;
	@Column(name = "supplierName", nullable = false,length=50)
	private String supplierName;	
	
	@Column(name = "productName", nullable = false,length=50)
	private String productName;	
	
	@Column(name = "purchase_date", length=10 ,nullable = false)
	private String purchase_date;
	
	@Column(name = "quantity", nullable = false)
	private int quantity;	
	
	@Column(name = "purchasePrice", nullable = false)
	private int purchasePrice;	
	
	@Column(name = "salesPrice", nullable = false)
	private int salesPrice;	
	
	@Column(name = "totalPurchase", nullable = false)
	private int totalPurchase;

	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public int getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(int salesPrice) {
		this.salesPrice = salesPrice;
	}

	public int getTotalPurchase() {
		return totalPurchase;
	}

	public void setTotalPurchase(int totalPurchase) {
		this.totalPurchase = totalPurchase;
	}	
	
	

}
