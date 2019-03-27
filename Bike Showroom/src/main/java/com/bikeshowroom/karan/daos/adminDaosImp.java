package com.bikeshowroom.karan.daos;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bikeshowroom.karan.model.adminModel;

@Repository
public class adminDaosImp implements adminDaos {
	@Resource
	SessionFactory sessionfactory;
	@Override
	@Transactional
	public adminModel login(String email, String password) {
		Session session = sessionfactory.getCurrentSession();
		Criteria critical=session.createCriteria(adminModel.class);
		critical.add(Restrictions.eq("email", email)).add(Restrictions.eq("password", password));
		
		System.out.println("Admin DaosImp");
		adminModel admodel= (adminModel) critical.uniqueResult();
		if (admodel != null)
			return admodel;		
		return null;
	}
	@Override
	@Transactional
	public adminModel getAdminDetailsById(int admin_id) {
		Session session = sessionfactory.getCurrentSession();
		adminModel adminmodel=(adminModel)session.get(adminModel.class, admin_id);
		return adminmodel;		
	}
	@Override
	@Transactional
	public void addAdmin(adminModel adminmodel) {
		Session session=sessionfactory.getCurrentSession();
		session.save(adminmodel);
	System.out.println("mc");
		
	}
	@Override
	@Transactional
	public void deleteAdmin(int id) {
		Session session=sessionfactory.getCurrentSession();
		adminModel adminmodel=(adminModel)session.get(adminModel.class, id);
		session.delete(adminmodel);
		
	}
	@Override
	@Transactional
	public void updateAdmin(adminModel adminmodel) {
		Session session=sessionfactory.getCurrentSession();
		session.update(adminmodel);
		
	}
	@Override
	@Transactional
	public List<adminModel> getAlladminDetails() {
		Session session=sessionfactory.getCurrentSession();
		Criteria crt=session.createCriteria(adminModel.class);
		List<adminModel> slist=crt.list();
		return slist;
	}
	@Override
	@Transactional
	public adminModel getAdminDetailsByemail(String email) {
		Session session = sessionfactory.getCurrentSession();
		Criteria critical=session.createCriteria(adminModel.class);
		critical.add(Restrictions.eq("email", email));
		
		System.out.println("Admin DaosImp");
		adminModel admodel= (adminModel) critical.uniqueResult();
		if (admodel != null)
			return admodel;		
		return null;
	}
	@Override
	@Transactional
	public boolean emailCheck(String email) {
		Session session = sessionfactory.getCurrentSession();
		Criteria critical=session.createCriteria(adminModel.class);
		critical.add(Restrictions.eq("email", email));
		adminModel admodel= (adminModel) critical.uniqueResult();
		if (admodel != null)
			return false;		
		return true;
	}		
}
