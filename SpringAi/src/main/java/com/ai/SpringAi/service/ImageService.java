package com.ai.SpringAi.service;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

	 private OpenAiImageModel openAiImageModel;
	 
	 public ImageService(OpenAiImageModel openAiImageModel) {
		 this.openAiImageModel=openAiImageModel;
		 
	 }
	 
	 public ImageResponse generateImage(String prompt,String quality,int n,int widht,int height) {
//		 ImageResponse imageResponse =openAiImageModel.call(
//				 new ImagePrompt(prompt)
//				 );
//		 
		 ImageResponse imageResponse =openAiImageModel.call(
				 new ImagePrompt(prompt,
					        OpenAiImageOptions.builder()
					                .withQuality("hd")
					                .withN(4)
					                .withHeight(1024)
					                .withWidth(1024).build()
					               )); 
				 
		 
		 return imageResponse;
		 
	 }
	
}
