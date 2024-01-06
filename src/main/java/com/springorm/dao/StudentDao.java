package com.springorm.dao;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springorm.entities.Student;

import java.util.List;

public class StudentDao {

	HibernateTemplate hibernateTemplate;

	//save Student
	@Transactional
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
		System.out.println("Data for "+studentId+" deleted!!");
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}

	@Transactional
	public void update(int studentId, String studentName, String studentCity) {

		Student studentToUpdate = this.hibernateTemplate.get(Student.class, studentId);

			if (studentName != null) {
				studentToUpdate.setStudentName(studentName);
			}

			if (studentCity != null) {
				studentToUpdate.setStudentCity(studentCity);
			}
			// Update the student entity in the database
			this.hibernateTemplate.update(studentToUpdate);

	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
