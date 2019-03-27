package com.bikeshowroom.karan.daos;
import java.util.List;
import javax.annotation.Resource;

import org.apache.poi.hssf.record.aggregates.CustomViewSettingsRecordAggregate;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.propertyeditors.CustomMapEditor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bikeshowroom.karan.model.adminModel;
import com.bikeshowroom.karan.model.customerModel;
import com.bikeshowroom.karan.model.staffModel;
@Repository
public class customerDaosImp implements customerDaos {	
	@Resource
	public SessionFactory sessionfactory;		
	@Override
	@Transactional
	public void addCustomer(customerModel customermodel) {
		Session session= sessionfactory.getCurrentSession();
		session.save(customermodel);
	}
	@Override
	@Transactional
	public void deleteCustomer(int id) {
		Session session=sessionfactory.getCurrentSession();
		customerModel customermodel=(customerModel)session.get(customerModel.class, id);
		session.delete(customermodel);
	}
	@Override
	@Transactional
	public void updateUpdate(customerModel customermodel) {
		Session session= sessionfactory.getCurrentSession();
		session.update(customermodel);
	}
	@Override
	@Transactional
	public customerModel getById(int id) {
		Session session= sessionfactory.getCurrentSession();
		customerModel customermodel = (customerModel) session.get(customerModel.class, id);
		return customermodel;
	}

	@Override
	@Transactional
	public List<customerModel> getAllCustomerDetails() {
		Session session= sessionfactory.getCurrentSession();
		Criteria crit= session.createCriteria(customerModel.class);
		List <customerModel> slist= crit.list();
		return slist;
	}
	@Override
	@Transactional
	public boolean emailCheck(String email) {
		Session session = sessionfactory.getCurrentSession();
		Criteria critical=session.createCriteria(customerModel.class);
		critical.add(Restrictions.eq("email", email));
		customerModel customerModel= (customerModel) critical.uniqueResult();
		if (customerModel != null)
			return false;		
		return true;
	}
	@Override
	@Transactional
	public List countCustomer() {
		Session session = sessionfactory.getCurrentSession();
		Criteria crt=session.createCriteria(customerModel.class);
		String hql="select count(*) from  customer";
		Query query=session.createSQLQuery(hql);
		List list=query.list();
		return list;
	}

}
