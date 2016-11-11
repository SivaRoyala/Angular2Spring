package com.student.dao;

import java.util.List;

import com.siva.exception.StudentDaoException;
import com.student.dto.StudentDto;

public interface IStudentDao {
	
	public List<StudentDto> getStudentList() throws StudentDaoException;
	
	public boolean createStudent(StudentDto studentDto) throws StudentDaoException;
	
	public StudentDto updateStudent(StudentDto studentDto) throws StudentDaoException;
	
	public boolean deleteStudent(int id) throws StudentDaoException;

}
