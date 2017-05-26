package com.abc.springmvc.bean;

import java.util.List;

public class QuestionsandOptionsSelected {

	private String questionId;
	private String questionText;
	private List<OptionsSelected> optionsSel;

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public List<OptionsSelected> getOptions() {
		return optionsSel;
	}

	public void setOptions(List<OptionsSelected> optionsSel) {
		this.optionsSel = optionsSel;
	}
	
//	@Override
//	public String toString(){
//		return "questionId:"+questionId+", questionText:"+questionText+",optionList:"+optionsSel;
//	}
}
