package com.abc.springmvc.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.springmvc.bean.Options;
import com.abc.springmvc.bean.QuestionsAndOptions;
import com.abc.springmvc.bean.QuestionsandOptionsSelected;
import com.abc.springmvc.dao.AnswersDao;
import com.abc.springmvc.dao.OptionsDao;
import com.abc.springmvc.dao.QuestionsDao;
import com.abc.springmvc.model.IQAnswers;
import com.abc.springmvc.model.IQOptions;
import com.abc.springmvc.model.IQQuestions;

@Service
@Transactional
public class QuestionsServiceImpl implements QuestionsService {
	
	static List<Integer> list = new ArrayList<Integer>();
	static int n, x = 20;
	
	@Autowired
	private QuestionsDao questionsDao;
	
	@Autowired
	private OptionsDao optionsDao;
	
	@Autowired
	private AnswersDao answersDao;

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
	
	@Override
	public void checkAnswersForQuestions(QuestionsandOptionsSelected[] qaoCollection) {
		int counter = 0;
		System.out.println("qaoCollection.length::"+qaoCollection.length);
		for(QuestionsandOptionsSelected qao:qaoCollection){
			System.out.println("Counter:"+counter);
			System.out.println("qao.getQuestionText()::"+qao.getQuestionText());
			List<IQAnswers> answersList = answersDao.findAnswersByQuestionId(qao.getQuestionId());
			counter++;
		}
		
		
	}
	
	@Override
	public List<QuestionsAndOptions> getQuestionsAndOptions(){
		List<IQQuestions> list = getRandomQuestions(10);
		List<QuestionsAndOptions> fullList = new ArrayList<QuestionsAndOptions>();
		
		for(IQQuestions iq:list){
			List<IQOptions> opList = optionsDao.findOptionsByQuestionId(iq.getqId());
			QuestionsAndOptions quesOptions = new QuestionsAndOptions();
			quesOptions.setQuestionId(iq.getqId());
			quesOptions.setQuestionText(iq.getqTxt());
			List<Options> subList = new ArrayList<Options>();
			for(IQOptions op:opList){
				Options options = new Options();
				options.setOptionId(op.getoId());
				options.setOptionText(op.getoText());
				subList.add(options);
			}
			quesOptions.setOptions(subList);
		   fullList.add(quesOptions);
		}
		return fullList;
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
