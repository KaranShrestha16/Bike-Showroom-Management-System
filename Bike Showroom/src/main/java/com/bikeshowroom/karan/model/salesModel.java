package com.bikeshowroom.karan.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="sales")
public class salesModel {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sales_id;
	@Column(name = "productName", nullable = false,length=50)
	private String productName;	
	
	@Column(name = "customerName", nullable = false,length=50)
	private String customerName;
	
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	@Column(name = "salesPrice", nullable = false)
	private int salesPrice ;
	
	@Column(name = "totalSales", nullable = false)
	private int totalSales;
	
	@Column(name = "salesDate", nullable = false,length=10)
	private String salesDate;
	
	@Column(name = "vat", nullable = false,length=10)
	private int vat;
	@Column(name = "cc", nullable = false,length=10)
	private int cc;
	public int getSales_id() {
		return sales_id;
	}
	public void setSales_id(int sales_id) {
		this.sales_id = sales_id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(int salesPrice) {
		this.salesPrice = salesPrice;
	}
	public int getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}
	public String getSalesDate() {
		return salesDate;
	}
	public void setSalesDate(String salesDate) {
		this.salesDate = salesDate;
	}
	public int getVat() {
		return vat;
	}
	public void setVat(int vat) {
		this.vat = vat;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	
	
	
	
	
	

	
}
