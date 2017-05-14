package com.abc.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseQController {
	
	@RequestMapping(value="/questions", method=RequestMethod.GET)
	public String getQuestionPage(){
		return "questions";
	}

}
