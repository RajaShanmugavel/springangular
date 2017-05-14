package com.abc.springmvc.dao;

import java.util.List;

import com.abc.springmvc.model.IQQuestions;

public interface QuestionsDao {

	IQQuestions findQuestionById(String questionId);
	
	List<IQQuestions> findAllQuestions();
	
	void addQuestion(IQQuestions iqQuestions);
	
	void deleteQuestion(String questionId);
	
	void updateQuestion(IQQuestions iqQuestions);
	
}
