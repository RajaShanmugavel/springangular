package com.abc.springmvc.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="IQSubmittedQA")
@Table(name="IQ_SUBMITTED_QA")
public class IQSubmittedQA {

	@Id
	@Column(name="subid")
	private String subId;
	
	@Column(name="qid")
	private String qId;
	
	@Column(name="qtxt")
	private String qTxt;
	
	@Column(name="selopid")
	private String selOpId;
	
	@Column(name="selopTxt")
	private String selOpTxt;
	
	@Column(name="coropid")
	private String corOpId;
	
	@Column(name="coroptxt")
	private String corOpTxt;
	
	@Column(name="userid")
	private String userId;
	
	@Column(name="saveddate")
	private Date savedDate;
	
	public String getSubId() {
		return subId;
	}

	public void setSubId(String subId) {
		this.subId = subId;
	}

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

	public String getSelOpId() {
		return selOpId;
	}

	public void setSelOpId(String selOpId) {
		this.selOpId = selOpId;
	}

	public String getSelOpTxt() {
		return selOpTxt;
	}

	public void setSelOpTxt(String selOpTxt) {
		this.selOpTxt = selOpTxt;
	}

	public String getCorOpId() {
		return corOpId;
	}

	public void setCorOpId(String corOpId) {
		this.corOpId = corOpId;
	}

	public String getCorOpTxt() {
		return corOpTxt;
	}

	public void setCorOpTxt(String corOpTxt) {
		this.corOpTxt = corOpTxt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getSavedDate() {
		return savedDate;
	}

	public void setSavedDate(Date savedDate) {
		this.savedDate = savedDate;
	}
	
	
}
