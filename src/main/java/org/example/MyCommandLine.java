package org.example;

import schooldata.CourseDAOList;
import schooldata.StudentDAOList;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.*;
public class MyCommandLine  {

    private Scanner inPut = new Scanner(System.in);
    private String inString = "";
    private CourseDAOList courseDAOList;
    private StudentDAOList studentDAOList;
    public MyCommandLine() {
        studentDAOList = new StudentDAOList();
        courseDAOList = new CourseDAOList();
    }

//    inString.equals("");

    public String getInString(String str){
        Student student;
        Course course;

        while (!str.equals("")) {
            System.out.print(str);
            return(inPut.next());
        }
        return null;
    }

    public Student getStudent(){
        String name = "";
        String email = "";
        String address = "";
        Scanner sc = new Scanner(System.in);
        Student s;
        System.out.println("Enter Student name");
        name = sc.nextLine();
        System.out.println("Enter Student email");
        email = sc.nextLine();
        System.out.println("Enter Student address");
        address = sc.nextLine();

        return  new Student(name, email, address);
    }

    public Course getCourse(){
        String name;
        LocalDate date;
        int duration;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter course name");
        name = sc.nextLine();
        System.out.println("Enter Start date: yyyy-mm-dd");
        date = getStartDate();
        System.out.println("Enter Course duration");
        duration = sc.nextInt();

        return  new Course(name, date, duration);
    }

    public void  displayStudents(){
        for (Student s : studentDAOList.findAll().values()) {
            System.out.println(s.toString());
        }
    }
    public void  displayCourses(){
        for (Course c : courseDAOList.findAll().values()) {
            System.out.println(c.toString());
        }
    }
    public LocalDate getStartDate() {
        String dateString = inPut.nextLine();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

        LocalDate date = LocalDate.parse(dateString);
        return  date;

    }

}
