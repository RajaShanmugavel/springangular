package com.abc.springmvc.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Service;

import com.abc.springmvc.bean.DisplayQABean;
import com.abc.springmvc.bean.NameBean;
import com.abc.springmvc.bean.Options;
import com.abc.springmvc.bean.OptionsSelected;
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
	public List<DisplayQABean> checkAnswersForQuestions(QuestionsandOptionsSelected[] qaoCollection) {
		List<List<IQAnswers>> answerFullList = new ArrayList<List<IQAnswers>>();
//		System.out.println("qaoCollection.length::"+qaoCollection.length);
		for(QuestionsandOptionsSelected qao:qaoCollection){
			List<IQAnswers> anList = answersDao.findAnswersByQuestionId(qao.getQuestionId());
			answerFullList.add(anList);
		}
		
		List<DisplayQABean> returnList = validateAnswersWithSubmittedQuestions(qaoCollection, answerFullList);
		
		for(DisplayQABean d:returnList){
			System.out.println("Quesss:"+d.getQuestion());
			d.getSelectedOption().forEach(o->System.out.println("Sel Op:"+o.getName()));
			d.getCorrectOption().forEach(o->System.out.println("Cor Op:"+o.getName()));
		}
		
		return returnList;
	}
	
	private List<DisplayQABean> validateAnswersWithSubmittedQuestions(QuestionsandOptionsSelected[] qaoCollection, List<List<IQAnswers>> answerFullList) {
		List<DisplayQABean> respList = new ArrayList<DisplayQABean>();
		for(QuestionsandOptionsSelected qAO:qaoCollection){
			DisplayQABean dispBean = new DisplayQABean();
			dispBean.setQuestion(qAO.getQuestionText());
//			System.out.println("Question TEST::"+qAO.getQuestionText());
//			qAO.getOptions().stream().filter(o->o.isSelectedOptionId()).collect(Collectors.toList()).forEach(i->System.out.println(i.getOptionText()));
			List<OptionsSelected> listOp = qAO.getOptions().stream().filter(o->o.isSelectedOptionId()).collect(Collectors.toList());
			List<NameBean> listNameBean = new ArrayList<NameBean>();
//			listOp.forEach(o->System.out.println("Sel Opt TESTTTT:::::"+o.getOptionText()));
			listOp.forEach(o->{
				NameBean nB = new NameBean();
				nB.setName(o.getOptionText());
//				System.out.println(o.getOptionText()+" ....Sel....");
				listNameBean.add(nB);
			});
			dispBean.setSelectedOption(listNameBean);
			
			List<NameBean> listNameBean2 = new ArrayList<NameBean>();
			for(List<IQAnswers> outerList:answerFullList){
//				outerList.stream().filter(o->o.getIqQuestions().getqId().equals(qAO.getQuestionId())).collect(Collectors.toList()).forEach(i->System.out.println(i.getIqOptions().getoText()));
				List<IQAnswers> ansOpList = outerList.stream().filter(o->o.getIqQuestions().getqId().equals(qAO.getQuestionId())).collect(Collectors.toList());
//				ansOpList.forEach(o->System.out.println("Corr option Test::"+o.getIqOptions().getoText()));
				ansOpList.forEach(o->{
					NameBean nB = new NameBean();
					nB.setName(o.getIqOptions().getoText());
//					System.out.println(o.getIqOptions().getoText()+" ...Corr.....");
					listNameBean2.add(nB);
				});
			}
			dispBean.setCorrectOption(listNameBean2);
			
		  	respList.add(dispBean);
		}

	  return respList;	
	}
	
	/*
	 * Miscellaneous method - TODO Remove it later
	 */
	private void displayAnswers(List<List<IQAnswers>> answerFullList) {
		for(List<IQAnswers> aList:answerFullList){
			for(IQAnswers iQA:aList){
				System.out.println(iQA.getaId());
				System.out.println(iQA.getIqOptions().getoId());
				System.out.println(iQA.getIqOptions().getoText());
				System.out.println(iQA.getIqQuestions().getqId());
			}
		}
	}
	
	/*
	 * Miscellaneous method - TODO Remove it later
	 */
	private void displayAllQandP(QuestionsandOptionsSelected[] qaoList){
		for(QuestionsandOptionsSelected qao:qaoList){
			System.out.print("--");
			System.out.println(qao.getQuestionId());
			System.out.println(qao.getQuestionText());
			qao.getOptions().forEach(o->{
				System.out.print(o.getOptionId());
				System.out.print(" ");
				System.out.print(o.getOptionText());
				System.out.print(" ");
				System.out.println(o.isSelectedOptionId());
				System.out.print(" ");
			});
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
