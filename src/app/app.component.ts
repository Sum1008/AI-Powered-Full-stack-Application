// src/app/app.component.ts
import { Component } from '@angular/core';
import { GenAIService } from './services/gen-ai.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  activeTab = 'generateImage';  // Default active tab
  imagePrompt: string = '';
  aiPrompt: string = '';
  recipeIngredients: string = '';
  recipeCuisine: string = 'any';
  dietaryRestriction: string = '';

  generatedImageUrl: string | null = null;
  aiResponse: string | null = null;
  generatedRecipe: string | null = null;

  constructor(private genAIService: GenAIService) {}

  // Generate Image
  generateImage() {
    this.genAIService.generateImage(this.imagePrompt).subscribe(
      (response) => {
        this.generatedImageUrl = response.imageUrl;  // Assume the backend sends image URL
      },
      (error) => {
        console.error('Error generating image:', error);
      }
    );
  }

  // Ask AI
  askAI() {
    this.genAIService.getAIResponse(this.aiPrompt).subscribe(
      (response) => {
        this.aiResponse = response;  // Backend AI response
      },
      (error) => {
        console.error('Error asking AI:', error);
      }
    );
  }

  // Generate Recipe
  generateRecipe() {
    this.genAIService.generateRecipe(this.recipeIngredients, this.recipeCuisine, this.dietaryRestriction).subscribe(
      (response) => {
        this.generatedRecipe = response;  // Backend recipe result
      },
      (error) => {
        console.error('Error generating recipe:', error);
      }
    );
  }
}
