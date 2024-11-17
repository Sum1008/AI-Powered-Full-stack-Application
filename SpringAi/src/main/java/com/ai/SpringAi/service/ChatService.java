package com.ai.SpringAi.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatModel chatModel;

    // Injecting ChatModel through constructor
    public ChatService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    // Ensuring the prompt is passed correctly to the model
    public String getResponse(String prompt) {
        try {
            return chatModel.call(prompt);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while fetching response from the AI model.";
        }
    }
    
    public String getResponseOptions(String prompt) {
    	ChatResponse response = chatModel.call(
    			new Prompt(
    					prompt,
    					OpenAiChatOptions.builder()
    					.withModel("gpt-4o")
    					.withTemperature(0.4)
    					.build()
    					));
    	return response.getResult().getOutput().getContent();
    	
    					
    }

   
}
