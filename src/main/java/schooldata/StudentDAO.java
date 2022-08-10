package schooldata;

import org.example.Student;

import java.util.HashMap;

public interface StudentDAO {
    Student saveStudent(Student student);
    Student findByEmail(String email);
    HashMap<Integer, Student> findByName(String name);
    Student findById(int id);
    HashMap<Integer, Student> findAll();
    boolean deleteStudent(Student student);
}
