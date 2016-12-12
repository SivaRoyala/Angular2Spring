import { Component, Input } from '@angular/core';
import { Student } from './student';

@Component({
  selector: 'my-student-detail',
  templateUrl: 'app/partials/student-details.html'
})

export class StudentDetailComponent {
  @Input()
  student: Student;
}