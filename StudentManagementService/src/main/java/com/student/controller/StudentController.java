package com.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.siva.exception.ErrorResponse;
import com.siva.exception.StudentServiceException;
import com.student.dto.StudentDto;
import com.student.model.Student;
import com.student.service.IStudentService;

@RestController
public class StudentController {
	
	private IStudentService studentService;
	
	@Autowired(required=true)
	public void setStudentService(IStudentService ss){
		this.studentService = ss;
	}

	@GetMapping("/students")
	public List<Student> getStudentList()throws StudentServiceException{
		List<Student> list = new ArrayList<>();
		List<StudentDto> dtoList = this.studentService.getStudentList();
		list = getModelList(dtoList);
		return list;
	}
	
	@PutMapping("/editStudent")
	public ResponseEntity<Student> editStudent(@RequestBody Student student)throws StudentServiceException{
		Student newStudent = new Student();
		StudentDto dto = this.studentService.updateStudent(getStudentDto(student));
		newStudent = getStudent(dto);
		return new ResponseEntity<>(newStudent, HttpStatus.OK);
	}

	@PostMapping(value = "/addStudent")
	public ResponseEntity<String> addStudent(@RequestBody Student student)throws StudentServiceException{
		String msg = null;
		boolean flag = this.studentService.addStudent(getStudentDto(student));
		if(flag){
			msg = "Student added successfully";
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id)throws StudentServiceException{
		String msg = null;
		boolean flag = this.studentService.deleteStudent(id);
		if(flag){
			msg = "Student deleted successfully";
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@ExceptionHandler(StudentServiceException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
	
	private List<Student> getModelList(List<StudentDto> dtoList) {
		List<Student> list = new ArrayList<Student>();
		for(StudentDto dto: dtoList){
			Student s = new Student();
			s.setId(dto.getId());
			s.setName(dto.getName());
			s.setAddress(dto.getAddress());
			list.add(s);
		}
		return list;
	}
	
	private StudentDto getStudentDto(Student student) {
		StudentDto dto = new StudentDto();
		dto.setId(student.getId());
		dto.setName(student.getName());
		dto.setAddress(student.getAddress());
		return dto;
	}
	
	
	private Student getStudent(StudentDto dto) {
		Student student = new Student();
		student.setId(dto.getId());
		student.setName(dto.getName());
		student.setAddress(dto.getAddress());
		return student;
	}
}
