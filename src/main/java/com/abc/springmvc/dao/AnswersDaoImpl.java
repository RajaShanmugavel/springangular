package com.abc.springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abc.springmvc.model.IQAnswers;

@Repository
public class AnswersDaoImpl implements AnswersDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<IQAnswers> findAnswersByQuestionId(String questionId) {
		
		List<Object[]> list = sessionFactory.getCurrentSession().createQuery("from IQAnswers as ans join ans.iqQuestions as qu where qu.qId='"+questionId+"'").list();
		List<IQAnswers> answersList = new ArrayList<IQAnswers>();
		
		for(Object[] obArr:list){
				IQAnswers an = (IQAnswers)obArr[0];
				System.out.println("an.getaId()::"+an.getaId());
				System.out.println("an.getQId()::"+an.getIqQuestions().getqId());
				System.out.println("an.getOId()::"+an.getIqOptions().getoId());
				System.out.println("an.getOText()::"+an.getIqOptions().getoText());
		}
		
		return answersList;
	}

}
