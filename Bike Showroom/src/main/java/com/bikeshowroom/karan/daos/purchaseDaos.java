package com.bikeshowroom.karan.daos;

import java.util.List;


import com.bikeshowroom.karan.model.purchaseModel;

public interface purchaseDaos {

	public void addPurchase(purchaseModel purchasemodel);
	public void deletePurchase(int id);
	public void updatePurchase(purchaseModel purchasemodel);
	public purchaseModel getById(int id);
	public List<purchaseModel> getAllPurchaseDetails();
	public List TotalSum();
	
}
