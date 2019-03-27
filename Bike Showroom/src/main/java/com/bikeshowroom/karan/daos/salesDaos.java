package com.bikeshowroom.karan.daos;

import java.util.List;


import com.bikeshowroom.karan.model.salesModel;

public interface salesDaos {

	
	public void addSales(salesModel salesModel);
	public void deleteSales(int id);
	public void updateSales(salesModel salesmodel);
	public salesModel getById(int id);
	public List<salesModel> getAllSalesDetails();
	public List totalSales();
}
