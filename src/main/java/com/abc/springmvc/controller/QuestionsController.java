package com.abc.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abc.springmvc.bean.DisplayQABean;
import com.abc.springmvc.bean.QuestionsAndOptions;
import com.abc.springmvc.bean.QuestionsandOptionsSelected;
import com.abc.springmvc.model.IQQuestions;
import com.abc.springmvc.service.QuestionsService;

@RestController
public class QuestionsController {

	@Autowired
	private QuestionsService questionsService;
	
	private static List<DisplayQABean> res = new ArrayList<DisplayQABean>();
	
	
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
	
	@RequestMapping(value="/submitQuestions", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void submitQuestions(@RequestBody QuestionsandOptionsSelected[] qaoList){
		res = questionsService.checkAnswersForQuestions(qaoList);
		System.out.println("::::res.size::::"+res.size());
	}
	
	@RequestMapping(value="/getResultString", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<DisplayQABean> getResultString(){
		return res;
	}
	
	@RequestMapping(value="/testMethod", method=RequestMethod.GET)
	public String testMethod(String str, ModelMap model){
		model.addAttribute("testAttr","Appended.."+str);
		return "sample";
	}


}
