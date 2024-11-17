// src/app/services/gen-ai.service.ts
import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class GenAIService {
  private apiUrl = 'http://localhost:8080';  // Replace with your actual backend API URL

  constructor(private http: HttpClient) {}

  // 1. Get response from AI based on the prompt
  getAIResponse(prompt: string): Observable<string> {
    return this.http.get<string>(`${this.apiUrl}/ask-ai?prompt=${prompt}`);
  }

  // 2. Get response options from AI based on the prompt
  getAIResponseOptions(prompt: string): Observable<string> {
    return this.http.get<string>(`${this.apiUrl}/ask-ai-options?prompt=${prompt}`);
  }

  // 3. Generate image based on the prompt and other parameters
  generateImage(prompt: string, quality: string = 'hd', n: number = 1, width: number = 1024, height: number = 1024): Observable<any> {
    const params = new HttpParams()
      .set('prompt', prompt)
      .set('quality', quality)
      .set('n', n.toString())
      .set('width', width.toString())
      .set('height', height.toString());

    return this.http.get<any>(`${this.apiUrl}/generate-image`, { params });
  }

  // 4. Generate recipe based on ingredients, cuisine, and dietary restrictions
  generateRecipe(ingredients: string, cuisine: string = 'any', dietaryRestriction: string = ''): Observable<string> {
    const params = new HttpParams()
      .set('ingredients', ingredients)
      .set('cuisine', cuisine)
      .set('dietaryRestriction', dietaryRestriction);

    return this.http.get<string>(`${this.apiUrl}/recipe-creator`, { params });
  }
}
