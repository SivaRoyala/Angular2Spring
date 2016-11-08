package com.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.dao.IStudentDao;
import com.student.dto.StudentDto;

@Service
public class StudentServiceImpl implements IStudentService {
	
	private IStudentDao studentDao;

	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public List<StudentDto> getStudentList() {
		return this.studentDao.getStudentList();
	}

	@Override
	public boolean addStudent(StudentDto dto) {
		return this.studentDao.createStudent(dto);
	}

	@Override
	public StudentDto updateStudent(StudentDto dto) {		
		return this.studentDao.updateStudent(dto);
	}

	@Override
	public boolean deleteStudent(int StudentId) {
		return this.studentDao.deleteStudent(StudentId);
	}

}
