package com.abc.springmvc.dao;

import java.util.List;

import com.abc.springmvc.model.IQAnswers;

public interface AnswersDao {
	
	List<IQAnswers> findAnswersByQuestionId(String questionId);

}
