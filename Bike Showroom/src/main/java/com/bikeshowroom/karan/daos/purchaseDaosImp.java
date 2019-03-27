package com.bikeshowroom.karan.daos;
import java.util.List;

import javax.annotation.Resource;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bikeshowroom.karan.model.customerModel;
import com.bikeshowroom.karan.model.purchaseModel;
import com.bikeshowroom.karan.model.suppliersModel;
@Repository
public class purchaseDaosImp implements purchaseDaos{
	@Resource
	public SessionFactory sessionfactory;	
	@Override
	@Transactional
	public void addPurchase(purchaseModel purchasemodel) {
		Session session= sessionfactory.getCurrentSession();
		session.save(purchasemodel);
	}
	@Override
	@Transactional
	public void deletePurchase(int id) {
		Session session=sessionfactory.getCurrentSession();
		purchaseModel purchasemodel=(purchaseModel)session.get(purchaseModel.class, id);
		session.delete(purchasemodel);		
	}
	@Override
	@Transactional
	public void updatePurchase(purchaseModel purchasemodel) {
		Session session= sessionfactory.getCurrentSession();
		session.update(purchasemodel);		
	}
	@Override
	@Transactional
	public purchaseModel getById(int id) {
		Session session= sessionfactory.getCurrentSession();
		purchaseModel purchasemodel = (purchaseModel) session.get(purchaseModel.class, id);
		return purchasemodel;
	}

	@Override
	@Transactional
	public List<purchaseModel> getAllPurchaseDetails() {
		   Session session= sessionfactory.getCurrentSession();
			Criteria crit= session.createCriteria(purchaseModel.class);
			List <purchaseModel> slist= crit.list();
			return slist;
         
     
  
		
	}
	@Override
	@Transactional
	public List TotalSum() {
		Session session = sessionfactory.getCurrentSession();
		Criteria crt=session.createCriteria(purchaseModel.class);
		String hql="select sum(totalPurchase) from  purchase";
		Query query=session.createSQLQuery(hql);
		List list=query.list();
		return list;
	}

}
