package com.springorm.dao;

import jakarta.transaction.Transactional;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springorm.entities.Student;

public class StudentDao {


	HibernateTemplate hibernateTemplate;


	//save Student
	@Transactional
	public int insert(Student student) {
		//insert
		Integer i =(Integer) this.hibernateTemplate.save(student);
		return 1;
		
	
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
