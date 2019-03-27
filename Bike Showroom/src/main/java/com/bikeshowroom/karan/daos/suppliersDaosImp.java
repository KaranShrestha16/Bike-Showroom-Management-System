package com.bikeshowroom.karan.daos;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bikeshowroom.karan.model.adminModel;
import com.bikeshowroom.karan.model.suppliersModel;
@Repository
public class suppliersDaosImp implements suppliersDaos{
	@Resource
	public SessionFactory sessionfactory;
	@Override
	@Transactional
	public void addSupplier(suppliersModel suppliermodel) {
		Session session= sessionfactory.getCurrentSession();
		session.save(suppliermodel);		
	}
	@Override
	@Transactional
	public void deleteSupplier(int id) {
		Session session= sessionfactory.getCurrentSession();
		suppliersModel suppliermodel=(suppliersModel) session.get(suppliersModel.class, id);
		session.delete(suppliermodel);
	}
	@Override
	@Transactional
	public void updateUpdate(suppliersModel suppliermodel) {
		Session session=sessionfactory.getCurrentSession();
		session.update(suppliermodel);		
	}
	@Override
	@Transactional
	public suppliersModel getById(int id) {
		Session session =sessionfactory.getCurrentSession();
		suppliersModel suppliermodel= (suppliersModel) session.get(suppliersModel.class, id);
		
		return suppliermodel;
	}
	@Override
	@Transactional
	public List<suppliersModel> getAllSuppliersDetails() {
		Session session =sessionfactory.getCurrentSession();
		Criteria crit= session.createCriteria(suppliersModel.class);
		List<suppliersModel> slist=crit.list();
		return slist;
	}
	@Override
	@Transactional
	public boolean getByemail(String email) {
		Session session=sessionfactory.getCurrentSession();
		Criteria critical=session.createCriteria(suppliersModel.class);
		critical.add(Restrictions.eq("email", email));
		suppliersModel suppliermodel= (suppliersModel) critical.uniqueResult();
		if (suppliermodel != null)
			return false;		
		return true;
	
	}
	@Override
	@Transactional
	public List countSupplier() {
		Session session=sessionfactory.getCurrentSession();
		Criteria crt=session.createCriteria(suppliersModel.class);
		Query query= session.createSQLQuery("select count(*) from suppliers");
		List list=query.list();
		return list;
	}

}
