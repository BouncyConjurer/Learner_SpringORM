package com.springorm.orm;

import com.springorm.dao.StudentDao;
import com.springorm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext classPath = new ClassPathXmlApplicationContext("config.xml");

        StudentDao studentDao = classPath.getBean("studentDao", StudentDao.class);

//        Student student = new Student(5,"Shareef Kumar",null);
//
//        int r = studentDao.insert(student);
//
//        System.out.println("done "+r);

        boolean go =true;

        while(go){

            try{

                System.out.println("PRESS 1: Add new DATA");
                System.out.println("PRESS 2: Delete single DATA");
                System.out.println("PRESS 3: Show all DATA");
                System.out.println("PRESS 4: Show single the DATA");
                System.out.println("PRESS 5: Update the DATA");
                System.out.println("PRESS 6: Exit!");

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                int i = Integer.parseInt(br.readLine());

                System.out.println(i);

                switch(i){

                    case 1: //Add new data

                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            System.out.println("Enter the studentId");
                            int uId = Integer.parseInt(br.readLine());
                            System.out.println("Enter the studentName");
                            String uName = br.readLine();
                            System.out.println("Enter the studentCity");
                            String uCity = br.readLine();

                            Student s = new Student();
                            s.setStudentId(uId);
                            s.setStudentName(uName);
                            s.setStudentCity(uCity);

                            studentDao.insert(s);

                            System.out.println("Done Fuiyooohhh!!!!!!!!!");
                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            break;

                    case 2: //delete single data
                            System.out.println("Enter the StudentId");
                            int k = Integer.parseInt(br.readLine());
                            studentDao.delete(k);
                            break;
                    case 3: //show all data
                            System.out.println("*****************************************************");
                            List<Student> allStudents = studentDao.showAll();
                            allStudents.forEach(st ->{
                                    System.out.println("StudentId :: "+st.getStudentId());
                                    System.out.println("StudentName :: "+st.getStudentName());
                                    System.out.println("StudentCity :: "+st.getStudentCity());
                                    System.out.println("*****************************************************");
                            });
                            break;

                    case 4: //show single the data
                            System.out.println("Enter the StudentId");
                            int j = Integer.parseInt(br.readLine());

                            Student show = studentDao.show(j);
                            System.out.println("StudentId :: "+show.getStudentId());
                            System.out.println("StudentName :: "+show.getStudentName());
                            System.out.println("StudentCity :: "+show.getStudentCity());

                            System.out.println("*****************************************************");
                            break;

                    case 5: //update the data
                            System.out.println("Enter the StudentId");
                            int stuId = Integer.parseInt(br.readLine());
                            Student s1 =new Student();

                            Student show1 = studentDao.show(stuId);
                            System.out.println("The current StudentName is "+show1.getStudentName());
                            System.out.println("The current StudentCity is "+show1.getStudentCity());

                            System.out.println("Press 1 for update the name");
                            System.out.println("Press 2 for update the city\n");

                            System.out.println("Enter your choice for what do you want to update?");
                            int choice = Integer.parseInt(br.readLine());

                            String newName =null;
                            String newCity =null;
                            switch(choice){
                                case 1:
                                        System.out.println("Enter new name");
                                        newName = br.readLine();
                                        studentDao.update(stuId,newName, show1.getStudentCity());
                                        break;
                                case 2:
                                        System.out.println("Enter new City");
                                        newCity = br.readLine();
                                        studentDao.update(stuId,show1.getStudentName(),newCity);
                                        break;
                                default:
                                        System.out.println("Invalid choice!!");
                            }

                            Student updatedStudent = studentDao.show(stuId);
                            System.out.println("Updated Student Details:");
                            System.out.println("StudentId :: " + updatedStudent.getStudentId());
                            System.out.println("StudentName :: " + updatedStudent.getStudentName());
                            System.out.println("StudentCity :: " + updatedStudent.getStudentCity());

                        break;

                    case 6: //exit
                            go=false;

                }

            }catch (Exception e){

                System.out.println("Invalid command!!");
                e.printStackTrace();

            }finally {
                System.out.println("Thank you for using my app!!");
            }

        }
    }
}
