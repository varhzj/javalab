package com.varhzj.lab.mybatis.mappers;

import java.util.List;

import com.varhzj.lab.mybatis.domain.Student;

public interface StudentMapper {

	List<Student> findAllStudents();

	Student findStudentById(Integer id);

	void insertStudent(Student student);

}
