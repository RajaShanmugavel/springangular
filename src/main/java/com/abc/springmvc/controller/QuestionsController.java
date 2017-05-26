package com.abc.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abc.springmvc.bean.QuestionsAndOptions;
import com.abc.springmvc.bean.QuestionsandOptionsSelected;
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
	
	@RequestMapping(value="/submitQuestions", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void submitQuestions(@RequestBody QuestionsandOptionsSelected[] qaoList){
		
		System.out.println("QuestionsandOptionsSelected::"+qaoList);
		if(qaoList != null)
			System.out.println("qaoList.length::"+qaoList.length);
		
		questionsService.checkAnswersForQuestions(qaoList);
		
	}
	
	/*
	 * Miscellaneous method
	 */
	private void displayAllQandP(QuestionsandOptionsSelected[] qaoList){
		for(QuestionsandOptionsSelected qao:qaoList){
			System.out.print("--");
			System.out.println(qao.getQuestionId());
			System.out.println(qao.getQuestionText());
			qao.getOptions().forEach(o->{
				System.out.print(o.getOptionId());
				System.out.print(" ");
				System.out.print(o.getOptionText());
				System.out.print(" ");
				System.out.println(o.isSelectedOptionId());
				System.out.print(" ");
			});
		}

	}

}
