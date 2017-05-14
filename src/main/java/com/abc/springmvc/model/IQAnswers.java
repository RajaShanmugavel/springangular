package com.abc.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="IQAnswers")
@Table(name="IQ_ANSWERS")
public class IQAnswers {
	
	@Id
	@Column(name="aid")
	private String aId;
	
	@ManyToOne
	@JoinColumn(name="qid")
	private IQQuestions iqQuestions;
	
	@ManyToOne
	@JoinColumn(name="oid")
	private IQOptions iqOptions;

	public String getaId() {
		return aId;
	}

	public void setaId(String aId) {
		this.aId = aId;
	}

	public IQQuestions getIqQuestions() {
		return iqQuestions;
	}

	public void setIqQuestions(IQQuestions iqQuestions) {
		this.iqQuestions = iqQuestions;
	}

	public IQOptions getIqOptions() {
		return iqOptions;
	}

	public void setIqOptions(IQOptions iqOptions) {
		this.iqOptions = iqOptions;
	}
	
	

}
