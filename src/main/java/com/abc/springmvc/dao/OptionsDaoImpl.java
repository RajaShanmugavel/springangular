package com.abc.springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abc.springmvc.model.IQOptions;

@Repository
public class OptionsDaoImpl implements OptionsDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public IQOptions findOptionsById(String oId) {
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<IQOptions> findOptionsByQuestionId(String qId) {
		
		List<Object[]> list = sessionFactory.getCurrentSession().createQuery("from IQOptions as op join op.iqQuestions as qu where qu.qId='"+qId+"'").list();
		List<IQOptions> optionsList = new ArrayList<IQOptions>();
		
		
		for(Object[] obArr:list){
			IQOptions op = new IQOptions();
			op = (IQOptions)obArr[0];
			optionsList.add(op);
//			System.out.println(op.getoId());
//			System.out.println(op.getoText());
		}
		
		return optionsList;
	}

}
