package com.bikeshowroom.karan.daos;
import java.util.List;
import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bikeshowroom.karan.model.adminModel;
import com.bikeshowroom.karan.model.customerModel;
import com.bikeshowroom.karan.model.productModel;
@Repository
public class productDaosImp implements productDaos {
	@Resource
	public SessionFactory sessionfactory;	
	@Override
	@Transactional
	public void addProduct(productModel productmodel) {
		Session session= sessionfactory.getCurrentSession();
		session.save(productmodel);
	}
	@Override
	@Transactional
	public void deleteProduct(int id) {
		Session session=sessionfactory.getCurrentSession();
		productModel productmodel=(productModel)session.get(productModel.class, id);
		session.delete(productmodel);
	}
	@Override
	@Transactional
	public void updateProduct(productModel productmodel) {
		Session session= sessionfactory.getCurrentSession();
		session.update(productmodel);
	}
	@Override
	@Transactional
	public productModel getById(int id) {
		Session session= sessionfactory.getCurrentSession();
		productModel productmodel = (productModel) session.get(productModel.class, id);
		System.out.println("aaa");
		return productmodel;	
	}
	@Override
	@Transactional
	public List<productModel> getAllProductDetails() {
		Session session= sessionfactory.getCurrentSession();
		Criteria crit= session.createCriteria(productModel.class);
		List <productModel> slist= crit.list();
		return slist;
	}
	@Override
	@Transactional
	public boolean getByProductName(String productName) {
		Session session = sessionfactory.getCurrentSession();
		Criteria critical=session.createCriteria(productModel.class);
		critical.add(Restrictions.eq("productName", productName));
		productModel productmodel= (productModel) critical.uniqueResult();
		if (productmodel != null)
			return false;		
		return true;
	}
	@Override
	@Transactional
	public productModel getDetailsByProductName(String productName) {
		Session session = sessionfactory.getCurrentSession();
		Criteria critical=session.createCriteria(productModel.class);
		critical.add(Restrictions.eq("productName", productName));
		productModel productmodel= (productModel) critical.uniqueResult();
		if (productmodel != null)
			return productmodel;		
		return null;
	}
}
