package com.bikeshowroom.karan.model;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
@Entity
@Table(name="suppliers")
public class suppliersModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int supplier_id;
	@Column(name = "supplierName", nullable = false,length=80)
	private String supplierName;
	@Column(name = "supplierAddress", nullable = false,length=60)
	private String supplierAddress;
	@Column(name = "phone", nullable = false,length=30)
	private String phone;
	@Column(name = "email", nullable = false,length=80)
	private String email;
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
