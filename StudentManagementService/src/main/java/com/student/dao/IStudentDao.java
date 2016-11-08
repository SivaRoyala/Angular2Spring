package com.student.dao;

import java.util.List;

import com.student.dto.StudentDto;

public interface IStudentDao {
	
	public List<StudentDto> getStudentList();
	
	public boolean createStudent(StudentDto studentDto);
	
	public StudentDto updateStudent(StudentDto studentDto);
	
	public boolean deleteStudent(int id);

}
