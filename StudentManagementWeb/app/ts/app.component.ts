import { Component } from '@angular/core';
import { Student } from './student';

const STUDENTS: Student[] = [
  { id: 1, name: 'Mr. Nice' },
  { id: 2, name: 'Narco' },
  { id: 3, name: 'Bombasto' },
  { id: 4, name: 'Celeritas' },
  { id: 5, name: 'Magneta' },
  { id: 6, name: 'RubberMan' },
  { id: 7, name: 'Dynama' },
  { id: 18, name: 'Dr IQ' },
  { id: 9, name: 'Magma' },
  { id: 10, name: 'Tornado' }
];

@Component({
  selector: 'my-app',
  template:
    '<h1>{{title}}</h1>'+
    '<h2>My Students</h2>'+
    '<ul class="students">'+
    '<li *ngFor="let student of students" [class.selected]="student === selectedStudent" (click)="onSelect(student)">'+
    '<span class="badge">{{student.id}}</span> {{student.name}}'+
    '</li>'+
    '</ul>'+
    '<my-student-detail [student]="selectedStudent"></my-student-detail>'
  
})

export class AppComponent {
  title = 'Tour of Students';
  students = STUDENTS;
  selectedStudent: Student;
  onSelect(student: Student): void {
    this.selectedStudent = student;
  }
}
