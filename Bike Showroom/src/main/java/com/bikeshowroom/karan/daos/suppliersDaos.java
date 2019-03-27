package com.bikeshowroom.karan.daos;

import java.util.List;

import com.bikeshowroom.karan.model.suppliersModel;

public interface suppliersDaos {

	public void addSupplier( suppliersModel suppliermodel);
	public void deleteSupplier(int id);
	public boolean getByemail(String email);
	public void updateUpdate(suppliersModel suppliermodel);
	public suppliersModel getById(int id);
	public List<suppliersModel> getAllSuppliersDetails();
	public List countSupplier();
}
