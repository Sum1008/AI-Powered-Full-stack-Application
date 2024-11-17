import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';  // For HTTP requests
import { FormsModule } from '@angular/forms';  // For two-way data binding
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,  // Import HttpClientModule here
    FormsModule        // Import FormsModule here
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
