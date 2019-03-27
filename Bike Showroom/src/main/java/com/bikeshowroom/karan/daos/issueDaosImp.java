package com.bikeshowroom.karan.daos;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bikeshowroom.karan.model.IssueModel;
import com.bikeshowroom.karan.model.productModel;
@Repository
public class issueDaosImp implements issueDaos {
	@Resource
	public SessionFactory sessionfactory;
	
	@Override
	@Transactional
	public void addIssue(IssueModel issuemodel) {
		Session session= sessionfactory.getCurrentSession();
		session.save(issuemodel);	
	}

	@Override
	@Transactional
	public List<IssueModel> getAllIssue() {
		Session session= sessionfactory.getCurrentSession();
		Criteria crit= session.createCriteria(IssueModel.class);
		List <IssueModel> slist= crit.list();
		return slist;
	}

}
