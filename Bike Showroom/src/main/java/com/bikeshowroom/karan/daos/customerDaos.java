package com.bikeshowroom.karan.daos;

import java.util.List;

import com.bikeshowroom.karan.model.customerModel;

public interface customerDaos {

	public void addCustomer( customerModel customermodel);
	public void deleteCustomer(int id);
	public List countCustomer();
	public void updateUpdate(customerModel customermodel);
	public customerModel getById(int id);
	public List<customerModel> getAllCustomerDetails();
	public boolean emailCheck(String email);
}
