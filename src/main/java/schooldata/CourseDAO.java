package schooldata;

import org.example.Course;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;

public interface CourseDAO {
    Course saveCourse(Course course);
    Course findById(int id);
    Course findByName(String name);
    HashMap<Integer, Course> findByDate(LocalDate date);
    HashMap<Integer, Course>  findAll();
    boolean removeCourse(Course course);
}
