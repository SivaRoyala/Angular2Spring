import { Component, Input } from '@angular/core';
import { StudentService } from './student.service';
import { Student } from './student';

@Component({
  selector: 'student-search',
  providers : [StudentService],
  templateUrl: 'app/partials/student-search.html'
})


export class StudentSearchComponent {
    
students: Student[] = []; 
    
    constructor(private _studentService: StudentService) {
        this._studentService = _studentService;
    }
    
    submitSearch(): void {
        alert('submit clicked');
        this.students = this._studentService.getStudents();
    }
    
    onSelect(student: Student): void {
        console.log(student.name);
        //this.selectedStudent = student;
    }
  
}