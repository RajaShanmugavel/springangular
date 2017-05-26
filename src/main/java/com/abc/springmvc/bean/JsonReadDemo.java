package com.abc.springmvc.bean;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReadDemo {

	public static void main(String[] args) throws Exception {
		
		String jsonString = "["
				+"{questionId:Q1002,questionText:Who holds the record for winning most number of Grand Slam single titles in tennis?,options:[{optionId:OP00005,optionText:Serena Williams},{optionId:OP00006,optionText:Steffi Graf},{optionId:OP00007,optionText:Margaret Court},{optionId:OP00008,optionText:Chris Evert}]},"
		+"{questionId:Q1003,questionText:Who is known as the father of Computers?,options:[{optionId:OP00009,optionText:Charles Babbage},{optionId:OP00010,optionText:Allan Turing},{optionId:OP00011,optionText:Bill Gates},{optionId:OP00012,optionText:Ada Lovelace}]},"
		+"{questionId:Q1004,questionText:Which country first introduced the VAT (Value Added Tax)?,options:[{optionId:OP00013,optionText:Italy},{optionId:OP00014,optionText:France},{optionId:OP00015,optionText:United Kingdom},{optionId:OP00016,optionText:Japan}]},"
		+"{questionId:Q1005,questionText:Capital of Venezuela?,options:[{optionId:OP00017,optionText:Capetown},{optionId:OP00018,optionText:Karakkas},{optionId:OP00019,optionText:Monacco},{optionId:OP00020,optionText:Zurich,selectedOptionId:true}]}"
		+"]";
		
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		
		QuestionsandOptionsSelected[] qaoArr = mapper.readValue(jsonString, QuestionsandOptionsSelected[].class);
		
		for(QuestionsandOptionsSelected qao:qaoArr){
			System.out.println(qao);
		}
		

	}

}
