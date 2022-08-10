package schooldata;

import org.example.Course;
import java.time.LocalDate;

import java.util.Collection;
import java.util.HashMap;

public class CourseDAOList implements CourseDAO {
    private static HashMap<Integer, Course> coursesHM;

    public CourseDAOList() {
        coursesHM = new HashMap<>();
    }

    @Override
    public Course saveCourse(Course course) {
        coursesHM.put(course.getId(), course);
        return coursesHM.get(course.getId());
    }

    @Override
    public Course findById(int id) {
        return coursesHM.get(id);
    }

    @Override
    public Course findByName(String name) {
        for(Course c : coursesHM.values()) {
            if (c.getCourseName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public HashMap<Integer, Course> findByDate(LocalDate date) {
        HashMap<Integer, Course> tmpHM =new HashMap<>();
        for (Course c : coursesHM.values()) {
            if(c.getStartDate().isEqual(date)) {
                tmpHM.put(c.getId(), c);
            }
        }
        return tmpHM;
    }

    @Override
    public HashMap<Integer, Course>  findAll() {
        return coursesHM;
    }

    @Override
    public boolean removeCourse(Course course) {
        if(coursesHM.remove(course.getId()) != null)
            return true;
        return false;
    }
}
