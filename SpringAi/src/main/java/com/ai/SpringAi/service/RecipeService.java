package com.ai.SpringAi.service;

import java.util.Map;

import org.apache.groovy.util.Maps;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

	private  ChatModel chatModel;
	
	
	public RecipeService(ChatModel chatModel) {
		this.chatModel=chatModel;
	}
	
	public String createRecipe(String ingrdients,
			String cuisine,String dietaryRestrictions) {
		
		var template ="""
				I want to create a recipe using the following ingredients:{ingrdients}.
				The cuisine type i prefer is {cuisine} .
				Please consider the follwoing dietary restrictions :{dietaryRestrictions}.
				Please provide me with a detailed recipe including title,list of ingrdients ,and cooking instrctrions""";
	
		PromptTemplate promptTemplate = new PromptTemplate(template);
		Map<String,Object> parms =Maps.of("ingrdients", ingrdients, "cuisine", cuisine, "dietaryRestrictions", dietaryRestrictions);
		
		Prompt prompt =promptTemplate.create(parms);
		
		return chatModel.call(prompt).getResult().getOutput().getContent();
		
		
	}
	
	
	
	
}
