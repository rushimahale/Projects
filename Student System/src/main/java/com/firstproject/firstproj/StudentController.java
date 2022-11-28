package com.firstproject.firstproj;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class StudentController {

	@Autowired
	SessionFactory factory;
	int age;

	public void setAge(int a) {
		age = a;
	}

	public StudentController() {
		System.out.println("age is" + age + "factory is" + factory);
		// Session session=factory.openSession();
	}

	@GetMapping("student")
	@CrossOrigin("http//localhost:8080")
	List<Student> allStudent() {

		Session session = factory.openSession();
		List<Student> arrayList = session.createCriteria(Student.class).list();

		System.out.println("contructor called.object is created");
		return arrayList;
	}
	// @path variable assign value of path variable to local variable
	// localhoast: 8089/student/1

	@GetMapping("students/{rno}")
	@CrossOrigin("http//localhost:8080")
	public Student getStudent(@PathVariable int rno) {
		Session session = factory.openSession();
		Student student = session.load(Student.class, rno);
		return student;
		// Rest api classes will convert above student class object into json
		// string
	}

	@PostMapping("student")
	public List<Student> addStudent(@RequestBody Student student) {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(student);
		tx.commit();
		List<Student> list = allStudent();
		return list;

	}

	@DeleteMapping("student/{rno}")
	public List<Student> DeleteStudent(@PathVariable int rno) {
		Session session = factory.openSession();
		Student student = session.load(Student.class, rno);
		Transaction tx = session.beginTransaction();
		session.delete(student);
		tx.commit();
		List<Student> list = allStudent();
		return list;

	}

	@PutMapping("student")
	public List<Student> updateStudent(@RequestBody Student clientStudent) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(clientStudent);
		tx.commit();
		List<Student> list = allStudent();
		return list;
	}

}
