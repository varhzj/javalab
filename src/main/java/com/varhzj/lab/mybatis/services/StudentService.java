package com.varhzj.lab.mybatis.services;

import java.util.List;

import com.varhzj.lab.mybatis.domain.Student;
import com.varhzj.lab.mybatis.mappers.StudentMapper;
import com.varhzj.lab.mybatis.util.MybatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentService {

	private Logger logger = LoggerFactory.getLogger(StudentService.class);

	public List<Student> findAllStudents() {
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			List<Student> students = studentMapper.findAllStudents();
			List<Student> _students = studentMapper.findAllStudents();
			System.out.println(students.equals(_students));
			return students;
		} finally {
			sqlSession.close();
		}
	}

	public Student findStudentById(Integer studId) {
		logger.debug("Select Student By ID: {}", studId);
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findStudentById(studId);
		} finally {
			sqlSession.close();
		}
	}

	public void createStudent(Student student) {
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			studentMapper.insertStudent(student);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void deleteStudentById(Integer id) {
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			studentMapper.deleteStudentById(id);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

}
