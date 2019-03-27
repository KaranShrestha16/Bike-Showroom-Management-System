package com.bikeshowroom.karan.daos;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bikeshowroom.karan.model.customerModel;
import com.bikeshowroom.karan.model.productModel;
import com.bikeshowroom.karan.model.purchaseModel;
import com.bikeshowroom.karan.model.salesModel;
@Repository
public class salesDaosImp implements salesDaos {
	@Resource
	public SessionFactory sessionfactory;			
	@Override
	@Transactional
	public void addSales(salesModel salesModel) {
		Session session= sessionfactory.getCurrentSession();
		session.save(salesModel);
	}
	@Override
	@Transactional
	public void deleteSales(int id) {
		Session session=sessionfactory.getCurrentSession();
		salesModel salesModel=(salesModel)session.get(salesModel.class, id);
		session.delete(salesModel);
	}
	@Override
	@Transactional
	public void updateSales(salesModel salesmodel) {
		Session session= sessionfactory.getCurrentSession();
		session.update(salesmodel);
	}
	@Override
	@Transactional
	public salesModel getById(int id) {
		Session session= sessionfactory.getCurrentSession();
		salesModel salesmodel = (salesModel) session.get(salesModel.class, id);
		return salesmodel;		
	}
	@Override
	@Transactional
	public List<salesModel> getAllSalesDetails() {
		Session session= sessionfactory.getCurrentSession();
		Criteria crit= session.createCriteria(salesModel.class);
		List <salesModel> slist= crit.list();
		return slist;
		
	}
	@Override
	@Transactional
	public List totalSales() {
		Session session = sessionfactory.getCurrentSession();
		Criteria crt=session.createCriteria(salesModel.class);
		String hql="select sum(totalSales) from  sales";
		Query query=session.createSQLQuery(hql);
		List list=query.list();
		return list;
	}

}
