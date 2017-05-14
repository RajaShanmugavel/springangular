package com.abc.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abc.springmvc.model.IQQuestions;
import com.abc.springmvc.service.QuestionsService;

@RestController
public class QuestionsController {

	@Autowired
	private QuestionsService questionsService;
	
	@RequestMapping(value="/getAllQuestions", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<IQQuestions> getAllQuestions(){
		return questionsService.findAllQuestions();
	}

}
