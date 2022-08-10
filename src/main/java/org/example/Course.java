package org.example;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Course {

    private static int idSequencer = 0;
    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private HashMap<Integer, Student> studentsHM;

    public Course(String courseName, LocalDate startDate, int weekDuration){
        this();
        this.courseName = courseName;
        this.startDate =startDate;
        this.weekDuration = weekDuration;
    }
    public Course() {
        id += idSequencer;
        studentsHM = new HashMap<>();
    }

    public void register(Student student){

        studentsHM.put(student.getId(),student);
    }
    public void unregister(Student student){

        studentsHM.remove(student.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && weekDuration == course.weekDuration && courseName.equals(course.courseName) && startDate.equals(course.startDate) && studentsHM.equals(course.studentsHM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, startDate, weekDuration, studentsHM);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", weekDuration=" + weekDuration +
                ", students in course=" + studentsHM +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public HashMap<Integer, Student> getStudentsHM() {
        return studentsHM;
    }

    public void setStudentsHM(HashMap<Integer, Student> studentsHM) {
        this.studentsHM = studentsHM;
    }
}
