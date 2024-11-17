package com.ai.SpringAi.controller;

import java.util.List;

import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ai.SpringAi.service.ChatService;
import com.ai.SpringAi.service.ImageService;
import com.ai.SpringAi.service.RecipeService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class GenAIController {
	
	ChatService chatService;
	ImageService imageService;
	RecipeService recipeService;
	
	
	

	public GenAIController(ChatService chatService,ImageService imageService,RecipeService recipeService) {
		super();
		this.chatService = chatService;
		this.imageService=imageService;
		this.recipeService=recipeService;
		
		
	}
	
	@GetMapping("/ask-ai")
	public String getResponse(@RequestParam String prompt) {
		
		return chatService.getResponse(prompt);
	}
	
	@GetMapping("/ask-ai-options")
	public String getResponseOptions(@RequestParam String prompt) {
		
		return chatService.getResponseOptions(prompt);
	}
	

	@GetMapping("/generate-image")
	public void generateImages(HttpServletResponse response , @RequestParam String prompt,@RequestParam (defaultValue="hd") String quality, @RequestParam (defaultValue="1") int n,@RequestParam (defaultValue="1024")int width,@RequestParam (defaultValue="1024")int height) {
		
		ImageResponse imageResponse =imageService.generateImage(prompt,quality,width,height,n);
        String imageurl= imageResponse.getResult().getOutput().getUrl();
        
	}
	
	public String recipeCreator (@RequestParam String ingredients,
			@RequestParam(defaultValue="any") String cuisine,
			@RequestParam(defaultValue="") String dietaryRestriction)
	{
		return recipeService.createRecipe(ingredients, cuisine, dietaryRestriction);
	}
	
	
	

}
