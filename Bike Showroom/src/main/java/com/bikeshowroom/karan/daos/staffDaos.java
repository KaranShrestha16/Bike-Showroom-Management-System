package com.bikeshowroom.karan.daos;

import java.util.List;

import com.bikeshowroom.karan.model.staffModel;

public interface staffDaos {
	
	public void staffRegister( staffModel staffModel); 
	public staffModel staffLogin(String email,String password);
	public staffModel getByemail(String email);
	public Boolean CheckEmail(String email);
	public void deleteStaff(int id);
	public void updateStaff(staffModel staffModel);
	public staffModel getById(int id);
	public List<staffModel> getAllStaffDetails();
	public List countStaff();
	
}
