package com.abc.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="IQOptions")
@Table(name="IQ_OPTIONS")
public class IQOptions {

	@Id
	@Column(name="oid")
	private String oId;
	
	@Column(name="otext")
	private String oText;
	
	@ManyToOne
	@JoinColumn(name="qid")
	private IQQuestions iqQuestions;

	public String getoId() {
		return oId;
	}

	public void setoId(String oId) {
		this.oId = oId;
	}

	public String getoText() {
		return oText;
	}

	public void setoText(String oText) {
		this.oText = oText;
	}

	public IQQuestions getIqQuestions() {
		return iqQuestions;
	}

	public void setIqQuestions(IQQuestions iqQuestions) {
		this.iqQuestions = iqQuestions;
	}
	
	
}
