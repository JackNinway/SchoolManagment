package org.example;

import schooldata.CourseDAOList;
import schooldata.StudentDAOList;

public class Main {
    public static void main(String[] args) {
        CourseDAOList courseDAOList = new CourseDAOList();
        StudentDAOList studentDAOList = new StudentDAOList();
        Student student;
        Course course;

        MyCommandLine myCli = new MyCommandLine();
        student = myCli.getStudent();
        studentDAOList.saveStudent(student);
        course = myCli.getCourse();
        course.register(student);
        courseDAOList.saveCourse(course);
        myCli.displayCourses();
        myCli.displayStudents();
//        System.out.println("course and student:\n" + courseDAOList.findAll() +"\n" + studentDAOList.findAll());
    }


}