package com.varhzj.lab.mybatis.services;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.varhzj.lab.mybatis.domain.Student;

public class StudentServiceTest {

	private static StudentService studentService;

	@BeforeClass
	public static void setUp() {
		studentService = new StudentService();
	}

	@AfterClass
	public static void teardown() {
		studentService = null;
	}

	@Test
	public void testFindAllStudents() {
		List<Student> students = studentService.findAllStudents();
		Assert.assertNotNull(students);
		for (Student student : students) {
			System.out.println(student);
		}
//		students.forEach((Student student) -> System.out.println(student));
	}

	@Test
	public void testFindStudentById() {
		Student student = studentService.findStudentById(1);
		Assert.assertNotNull(student);
		System.out.println(student);
	}

	@Test
	public void testDeleteStudentById() {
		Student student = new Student();
		student.setStudId(11);
		student.setName("Henry");
		student.setEmail("Henry@example.com");
		student.setDob(new Date());
		studentService.createStudent(student);

		Student student1 = studentService.findStudentById(11);
		Assert.assertNotNull(student1);

		studentService.deleteStudentById(11);
		student1 = studentService.findStudentById(11);
		Assert.assertNull(student1);
	}
}
