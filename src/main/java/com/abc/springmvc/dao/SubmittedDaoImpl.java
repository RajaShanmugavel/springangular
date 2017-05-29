package com.abc.springmvc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abc.springmvc.model.IQSubmittedQA;

@Repository
public class SubmittedDaoImpl implements SubmittedDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addSubmittedQuestions(IQSubmittedQA iqSubmittedQA) {
		sessionFactory.getCurrentSession().save(iqSubmittedQA);
	}

}
