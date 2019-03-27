package com.bikeshowroom.karan.daos;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bikeshowroom.karan.model.staffModel;
@Repository
public class staffDaosImp implements staffDaos {
	@Resource
	SessionFactory sessionFactory;
	@Override
	@Transactional
	public void staffRegister(staffModel staffModel) {
		Session session=sessionFactory.getCurrentSession();
		session.save(staffModel);
	}
	@Override
	@Transactional
	public staffModel staffLogin(String email, String password) {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria critical=session.createCriteria(staffModel.class);
		critical.add(Restrictions.eq("email", email)).add(Restrictions.eq("password", password));
		
		System.out.println("Staff DaosImp");
		staffModel staffmodel= (staffModel) critical.uniqueResult();
		if (staffmodel != null)
			return staffmodel;	
		return null;
	}
	@Override
	@Transactional
	public void deleteStaff(int id) {
		Session session=sessionFactory.getCurrentSession();
		staffModel staffModel=(staffModel)session.get(staffModel.class, id);
		session.delete(staffModel);
	}
	@Override
	@Transactional
	public void updateStaff(staffModel staffModel) {
		Session session=sessionFactory.getCurrentSession();
		session.update(staffModel);
	}
	@Override
	@Transactional
	public staffModel getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		staffModel staffmodel=(staffModel)session.get(staffModel.class, id);
		return staffmodel;
	}
	@Override
	@Transactional
	public List<staffModel> getAllStaffDetails() {
		Session session=sessionFactory.getCurrentSession();
		Criteria crt=session.createCriteria(staffModel.class);
		List<staffModel> slist=crt.list();
		return slist;
		
	}
	@Override
	@Transactional
	public staffModel getByemail(String email) {
		Session session = sessionFactory.getCurrentSession();
		Criteria critical=session.createCriteria(staffModel.class);
		critical.add(Restrictions.eq("email", email));
		
		System.out.println("Staff DaosImp");
		staffModel staffmodel= (staffModel) critical.uniqueResult();
		if (staffmodel != null)
			return staffmodel;	
		
		return null;
	}
	@Override
	@Transactional
	public Boolean CheckEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		Criteria critical=session.createCriteria(staffModel.class);
		critical.add(Restrictions.eq("email", email));
		
		System.out.println("Staff DaosImp");
		staffModel staffmodel= (staffModel) critical.uniqueResult();
		if (staffmodel != null)
			return false;	
		
		return true;
	}
	@Override
	@Transactional
	public List countStaff() {
	Session session=sessionFactory.getCurrentSession();
	Criteria crit=session.createCriteria(staffModel.class);
	Query query=session.createSQLQuery("Select count(*) from staff");
		List list= query.list();
		return list;
	}

}
