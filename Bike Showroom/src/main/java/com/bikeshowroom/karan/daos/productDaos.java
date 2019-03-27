package com.bikeshowroom.karan.daos;

import java.util.List;

import com.bikeshowroom.karan.model.adminModel;
import com.bikeshowroom.karan.model.productModel;

public interface productDaos {


	public void addProduct( productModel productmodel);
	public void deleteProduct(int id);
	public void updateProduct(productModel productmodel);
	public productModel getById(int id);
	public List<productModel> getAllProductDetails();
	public boolean getByProductName(String productName);
	public productModel getDetailsByProductName(String productName);
	
	
}
