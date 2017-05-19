package com.abc.springmvc.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.springmvc.dao.QuestionsDao;
import com.abc.springmvc.model.IQQuestions;

@Service
@Transactional
public class QuestionsServiceImpl implements QuestionsService {
	
	static List<Integer> list = new ArrayList<Integer>();
	static int n, x = 20;
	
	@Autowired
	private QuestionsDao questionsDao;

	@Override
	public IQQuestions findQuestionById(String questionId) {
		return questionsDao.findQuestionById(questionId);
	}

	@Override
	public List<IQQuestions> findAllQuestions() {
		return questionsDao.findAllQuestions();
	}

	@Override
	public void addQuestion(IQQuestions iqQuestions) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteQuestion(String questionId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateQuestion(IQQuestions iqQuestions) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<IQQuestions> getRandomQuestions(int count) {
		n = count;
		List<IQQuestions> allQuestionsList = questionsDao.findAllQuestions();
		List<IQQuestions> randomQuestionsList = new ArrayList<IQQuestions>();
		populateList();
		for(int i=0;i<n;i++){
			randomQuestionsList.add(allQuestionsList.get(list.get(i)));
		}
		return randomQuestionsList;
	}
	
	private void removeDuplicates(){
		HashSet<Integer> set = new HashSet<Integer>();
		set.addAll(list);
		list.clear();
		list.addAll(set);
	}

	private void populateList(){
		Random r = new Random();
		
		for(int i=0;i<n;i++){
			list.add(r.nextInt(x));
		}

		removeDuplicates();

		if(list.size() < n){
			populateList();
		}else{
			return;
		}
	}

}
