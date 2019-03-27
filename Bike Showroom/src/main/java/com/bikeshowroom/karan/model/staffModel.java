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
@Table(name="staff")
public class staffModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "firstName", nullable = false,length=50)
	private String firstName;
	@Column(name = "lastName", nullable = false,length=50)
	private String lastName;
	@Column(name = "address", nullable = false,length=100)
	private String address;
	@Column(name = "birthDate", nullable = false,length=20)
	private String birthDate;
	@Column(name = "phone", nullable = false,length=100)
	private String phone;
	@Column(name = "gender", nullable = false,length=10)
	private String gender;
	@Column(name = "email", nullable = false,length=100)
	private String email;
	@Column(name = "password", nullable = false,length=50)
	private String password;
	@Column(name = "salary", nullable = false,length=20)
	private String salary;
	@Column(name = "imageName", nullable = false,length=200)
	private String imageName;
	
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBrithDate() {
		return birthDate;
	}
	public void setBrithDate(String brithDate) {
		this.birthDate = brithDate;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public int getId() {
		return id;
	}
	
	
	
	
	
}

