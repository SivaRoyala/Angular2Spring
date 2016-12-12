package com.student.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.student.dto.StudentDto;
import com.student.entity.Student;
import com.student.exception.StudentDaoException;

@Repository
public class StudentDaoImpl implements IStudentDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentDto> getStudentList() throws StudentDaoException {
		Session session = null;
		List<StudentDto> studentDtoList = null;		
		try{
			session = this.sessionFactory.openSession();
			List<Student> studentList = session.createQuery("from Student").list();
			studentDtoList = getDtoList(studentList);
		}catch(Exception e){
			throw new StudentDaoException("Something went wrong while getting Students details");
		}finally{
			closeSession(session);
		}
		return studentDtoList;
	}

	@Override
	public boolean createStudent(StudentDto studentDto) throws StudentDaoException {
		Session session = null;
		Transaction tr = null;
		boolean saveFlag = false;
		try{
			session = this.sessionFactory.openSession();
			tr = session.beginTransaction();
			Student student = getStudent(studentDto);
			session.save(student);
			tr.commit();
			saveFlag = true;
		}catch(Exception e){
			tr.rollback();
			//e.printStackTrace();
			throw new StudentDaoException("Something went wrong while creating Student");
		}finally{
			closeSession(session);
		}
		return saveFlag;
	}

	@Override
	public StudentDto updateStudent(StudentDto studentDto) throws StudentDaoException {
		Session session = null;
		Transaction tr = null;
		StudentDto dto = null;
		try{
			session = this.sessionFactory.openSession();
			tr = session.beginTransaction();
			Student student = getStudent(studentDto);
			Student updatedStudent = (Student) session.merge(student);
			dto = getStudentDto(updatedStudent);
			tr.commit();
		}catch(Exception e){
			tr.rollback();
			//e.printStackTrace();
			throw new StudentDaoException("Something went wrong while updting Student");
		}finally{
			closeSession(session);
		}
		return dto;
	}

	@Override
	public boolean deleteStudent(int id) throws StudentDaoException {
		Session session = null;
		Transaction tr = null;
		boolean deleteFlag = false;	
		try{
			session = this.sessionFactory.openSession();
			tr = session.beginTransaction();
			Query query = session.createQuery("delete Student where id = :id");
			query.setParameter("id", id);
			int result = query.executeUpdate();			 
			if (result > 0) {
			    System.out.println("Student was removed");
			    tr.commit();
			    deleteFlag = true;
			}			
		}catch(Exception e){
			tr.rollback();
			//e.printStackTrace();
			throw new StudentDaoException("Something went wrong while deleting Student");
		}finally{
			closeSession(session);
		}
		return deleteFlag;
	}
	
	private List<StudentDto> getDtoList(List<Student> studentList) {
		List<StudentDto> list = new ArrayList<StudentDto>();
		for(Student dto: studentList){
			StudentDto s = new StudentDto();
			s.setId(dto.getId());
			s.setName(dto.getName());
			s.setAddress(dto.getAddress());
			list.add(s);
		}
		return list;
	}
	

	private StudentDto getStudentDto(Student updatedStudent) {
		StudentDto dto = new StudentDto();
		dto.setId(updatedStudent.getId());
		dto.setName(updatedStudent.getName());
		dto.setAddress(updatedStudent.getAddress());
		return dto;
	}
	

	private Student getStudent(StudentDto studentDto) {
		Student student = new Student();
		student.setId(studentDto.getId());
		student.setName(studentDto.getName());
		student.setAddress(studentDto.getAddress());
		return student;
	}
	
	private void closeSession(Session session){
		if(session != null){
			session.close();
		}
	}

}
