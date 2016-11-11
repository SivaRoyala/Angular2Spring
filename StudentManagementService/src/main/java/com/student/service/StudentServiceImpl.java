package com.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.siva.exception.StudentDaoException;
import com.siva.exception.StudentServiceException;
import com.student.dao.IStudentDao;
import com.student.dto.StudentDto;

@Service
public class StudentServiceImpl implements IStudentService {
	
	private IStudentDao studentDao;

	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public List<StudentDto> getStudentList() throws StudentServiceException {
		try{
			return this.studentDao.getStudentList();
		}catch(StudentDaoException ex){
			throw new StudentServiceException(ex.getErrorMsg());
		}
	}

	@Override
	public boolean addStudent(StudentDto dto) throws StudentServiceException {
		try{
			return this.studentDao.createStudent(dto);
		}catch(StudentDaoException ex){
			throw new StudentServiceException(ex.getErrorMsg());
		}
	}

	@Override
	public StudentDto updateStudent(StudentDto dto) throws StudentServiceException {		
		try{
			return this.studentDao.updateStudent(dto);
		}catch(StudentDaoException ex){
			throw new StudentServiceException(ex.getErrorMsg());
		}
	}

	@Override
	public boolean deleteStudent(int StudentId) throws StudentServiceException {
		try{
			return this.studentDao.deleteStudent(StudentId);
		}catch(StudentDaoException ex){
			throw new StudentServiceException(ex.getErrorMsg());
		}
	}

}
