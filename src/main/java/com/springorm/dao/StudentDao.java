package com.springorm.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springorm.entities.Student;

public class StudentDao {
	
	HibernateTemplate hibernateTemplate;
	
	public int insert(Student student) {
		
		this.hibernateTemplate.save(student);
		
		
		return 1;
		
	
	}

}
