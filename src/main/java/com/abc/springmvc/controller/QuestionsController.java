package com.abc.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abc.springmvc.bean.Options;
import com.abc.springmvc.bean.QuestionsAndOptions;
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
	
	@RequestMapping(value="/getRandomQuestions", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<IQQuestions> getRandomQuestions(){
		return questionsService.getRandomQuestions(10);
	}
	
	@RequestMapping(value="/getRandomQuestionsAndAnswers", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<QuestionsAndOptions> getRandomQuestionsAndAnswers(){
		return questionsService.getQuestionsAndOptions();
	}
	
	@RequestMapping(value="/submitQuestions", method=RequestMethod.POST)
	public void submitQuestions(@RequestBody Options qo){
		System.out.println("qId:"+qo.getOptionId());
	}

}
