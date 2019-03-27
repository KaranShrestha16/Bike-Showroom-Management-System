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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="customer")
public class customerModel {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customer_id;
	
	@Column(name = "fullName", nullable = false,length=60)
	private String fullName;
	
	@Column(name = "address", nullable = false,length=50)
	private String address;
	
	@Column(name = "age", nullable = false)
	private int age;
	
	@Column(name = "phone", nullable = false,length=20)
	private String phone;
	
	@Column(name = "gender", nullable = false,length=10)
	private String gender;
	
	@Column(name = "email", nullable = false,length=100)
	private String email;

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	 
	
	
}
