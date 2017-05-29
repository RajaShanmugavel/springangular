package com.abc.springmvc.bean;

import java.util.List;

public class DisplayQABean {

	private String question;
	private List<NameBean> selectedOption;
	private List<NameBean> correctOption;
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<NameBean> getSelectedOption() {
		return selectedOption;
	}
	public void setSelectedOption(List<NameBean> selectedOption) {
		this.selectedOption = selectedOption;
	}
	public List<NameBean> getCorrectOption() {
		return correctOption;
	}
	public void setCorrectOption(List<NameBean> correctOption) {
		this.correctOption = correctOption;
	}
	
}
