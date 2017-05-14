package com.abc.springmvc.service;

import java.util.List;

import com.abc.springmvc.model.IQQuestions;

public interface QuestionsService {

	IQQuestions findQuestionById(String questionId);

	List<IQQuestions> findAllQuestions();

	void addQuestion(IQQuestions iqQuestions);

	void deleteQuestion(String questionId);

	void updateQuestion(IQQuestions iqQuestions);

}
