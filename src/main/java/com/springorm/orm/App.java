package com.springorm.orm;

import com.springorm.dao.StudentDao;
import com.springorm.entities.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("config.xml");

        StudentDao studentDao = classPath.getBean("studentDao", StudentDao.class);

        Student student = new Student(5,"Shareef Kumar",null);

        int r = studentDao.insert(student);

        System.out.println("done "+r);
        
        classPath.close();

    }
}
