package com.abc.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.springmvc.dao.QuestionsDao;
import com.abc.springmvc.model.IQQuestions;

@Service
@Transactional
public class QuestionsServiceImpl implements QuestionsService {
	
	@Autowired
	private QuestionsDao questionsDao;

	@Override
	public IQQuestions findQuestionById(String questionId) {
		return questionsDao.findQuestionById(questionId);
	}

	@Override
	public List<IQQuestions> findAllQuestions() {
		return questionsDao.findAllQuestions();
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
