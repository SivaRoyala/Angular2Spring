package com.student.service;

import java.util.List;

import com.student.dto.StudentDto;
import com.student.exception.StudentServiceException;

public interface IStudentService {
	
	public List<StudentDto> getStudentList() throws StudentServiceException;
	
	public boolean addStudent(StudentDto dto) throws StudentServiceException;
	
	public StudentDto updateStudent(StudentDto dto) throws StudentServiceException;
	
	public boolean deleteStudent(int StudentId) throws StudentServiceException;

}
