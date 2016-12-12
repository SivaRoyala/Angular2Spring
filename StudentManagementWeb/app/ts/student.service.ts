import { Injectable } from '@angular/core';

@Injectable()
export class StudentService {

    students:Array<any>;

    constructor() {
        this.students = [
            { id: 1, name: 'Mr. Siva', address: 'SMR'},
            { id: 2, name: 'Narco', address: 'NRT'},
            { id: 3, name: 'Bombasto', address: 'SMR'},
            { id: 4, name: 'Celeritas', address: 'HYD'},
            { id: 5, name: 'Magneta', address: 'GNT'},
            { id: 6, name: 'RubberMan', address: 'SMR'},
            { id: 7, name: 'Dynama', address: 'HYD'},
            { id: 18, name: 'Dr IQ', address: 'SMR'},
            { id: 9, name: 'Magma', address: 'HYD'},
            { id: 10, name: 'Tornado', address: 'NRT'}
        ];
    }

    getStudents() {
        return this.students;
    }
    
}