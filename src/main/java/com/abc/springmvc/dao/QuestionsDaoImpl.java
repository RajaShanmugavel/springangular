package com.abc.springmvc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abc.springmvc.model.IQQuestions;

@Repository
public class QuestionsDaoImpl implements QuestionsDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public IQQuestions findQuestionById(String questionId) {
		IQQuestions iqQuestions = (IQQuestions)sessionFactory.getCurrentSession().get(IQQuestions.class, questionId);
		return iqQuestions;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IQQuestions> findAllQuestions() {
		List<IQQuestions> list = sessionFactory.getCurrentSession().createQuery("from IQQuestions iq").list();
		return list;
	}

	@Override
	public void addQuestion(IQQuestions iqQuestions) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteQuestion(String questionId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateQuestion(IQQuestions iqQuestions) {
		// TODO Auto-generated method stub

	}

}
