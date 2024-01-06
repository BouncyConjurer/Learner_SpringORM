package com.springorm.dao;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springorm.entities.Student;

import java.util.List;

public class StudentDao {


	HibernateTemplate hibernateTemplate;


	//save Student
	@Transactional(readOnly = false)
	public int insert(Student student) {
		//insert
		Integer i =(Integer) this.hibernateTemplate.save(student);
		return i;
	}

	//get single data object
	public Student show(int studentId){

		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}

	//get all the data
	public List<Student> showAll(){

		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}

	//deleting single data
	@Transactional
	public void delete(int studentId){
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}

	@Transactional
	public void update(int studentId){
		this.hibernateTemplate.update(studentId);

	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
