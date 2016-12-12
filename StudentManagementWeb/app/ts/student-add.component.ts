import { Component, Input } from '@angular/core';
//import { FormBuilder, Validators } from '@angular/common';

@Component({
  selector: 'student-add',
  templateUrl: 'app/partials/add-student-details.html'
})


export class StudentAddComponent {
    
  onSubmit(form: any): void {  
    console.log('you submitted value:', form);  
  }
  
}