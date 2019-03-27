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
@Entity
@Table(name="admin")
public class adminModel {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int admin_id;	
	@Column(name = "fullName", nullable = false,length=50)
	private String fullName;
	@Column(name = "email", nullable = false,length=100)
	private String email;
	@Column(name = "password", nullable = false,length=50)
	private String password;
	@Column(name = "imageName", nullable = false,length=220)
	private String imageName;
	@Column(name = "userType", nullable = false,length=10)
	private String userType;
	

	
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
	
	
}