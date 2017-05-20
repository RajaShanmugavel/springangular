package com.abc.springmvc.dao;

import java.util.List;

import com.abc.springmvc.model.IQOptions;

public interface OptionsDao {
	
	IQOptions findOptionsById(String oId);
	
	List<IQOptions> findOptionsByQuestionId(String qId);

}
