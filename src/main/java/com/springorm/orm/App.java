package com.springorm.orm;

import com.springorm.dao.StudentDao;
import com.springorm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext classPath = new ClassPathXmlApplicationContext("config.xml");


        StudentDao studentDao = classPath.getBean("studentDao", StudentDao.class);

        Student student = new Student(1,"Praveen Kumar","Kanpur");

        int r = studentDao.insert(student);

        System.out.println("done"+r);

    }
}
