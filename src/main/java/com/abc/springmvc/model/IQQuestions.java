package com.abc.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="IQQuestions")
@Table(name="IQ_QUESTIONS")
public class IQQuestions {
	
	@Id
	@Column(name="qid")
	private String qId;
	
	@Column(name="qtxt")
	private String qTxt;

	public String getqId() {
		return qId;
	}

	public void setqId(String qId) {
		this.qId = qId;
	}

	public String getqTxt() {
		return qTxt;
	}

	public void setqTxt(String qTxt) {
		this.qTxt = qTxt;
	}
	
	
}
