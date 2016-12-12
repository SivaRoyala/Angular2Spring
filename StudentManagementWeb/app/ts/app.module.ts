import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule }   from '@angular/forms';
import { AppComponent }  from './app.component';
import { StudentDetailComponent } from './student-detail.component';
import { StudentTab } from './student-tab.component';
import { StudentTabs } from './student-tabs.component';
import { StudentSearchComponent } from './student-search.component';
import { StudentAddComponent } from './student-add.component';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule
  ],
  declarations: [
    AppComponent,
    StudentDetailComponent,
    StudentTab,
    StudentTabs,
    StudentSearchComponent,
    StudentAddComponent
  ],
  bootstrap: [ AppComponent ]
})

export class AppModule { }