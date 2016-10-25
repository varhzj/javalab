package com.varhzj.lab.mybatis.mappers;

import java.util.List;

import com.varhzj.lab.mybatis.domain.Student;
import org.apache.ibatis.annotations.Delete;

public interface StudentMapper {

	List<Student> findAllStudents();

	Student findStudentById(Integer id);

	void insertStudent(Student student);

	@Delete("delete from students where stud_id = #{id}")
	void deleteStudentById(Integer id);

}
