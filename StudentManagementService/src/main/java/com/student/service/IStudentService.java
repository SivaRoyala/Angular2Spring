package com.student.service;

import java.util.List;

import com.student.dto.StudentDto;

public interface IStudentService {
	
	public List<StudentDto> getStudentList();
	
	public boolean addStudent(StudentDto dto);
	
	public StudentDto updateStudent(StudentDto dto);
	
	public boolean deleteStudent(int StudentId);

}
