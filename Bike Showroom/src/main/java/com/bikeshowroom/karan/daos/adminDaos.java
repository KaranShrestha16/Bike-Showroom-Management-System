package com.bikeshowroom.karan.daos;

import java.util.List;

import com.bikeshowroom.karan.model.adminModel;
import com.bikeshowroom.karan.model.staffModel;

public interface adminDaos {

	public adminModel login(String email, String password);
	public adminModel getAdminDetailsByemail(String email);
	public boolean emailCheck(String email);
	public adminModel getAdminDetailsById(int id);
	public void addAdmin( adminModel adminmodel); 
	public void deleteAdmin(int id);
	public void updateAdmin(adminModel adminModel);
	public List<adminModel> getAlladminDetails();
}
