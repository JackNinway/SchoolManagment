package schooldata;

import org.example.Student;

import java.util.HashMap;

public class StudentDAOList implements StudentDAO {
    private static HashMap<Integer, Student> studentsDAOHM;

    public StudentDAOList() {
        studentsDAOHM = new HashMap<>();
    }

    @Override
    public Student saveStudent(Student student) {
        studentsDAOHM.put(student.getId(), student);
        return studentsDAOHM.get(student.getId());
    }

    @Override
    public Student findByEmail(String email) {
        for(Student s : studentsDAOHM.values()) {
            if (s.getEmail().equalsIgnoreCase(email))
                return s;
        }
        return null;
    }

    @Override
    public HashMap<Integer, Student> findByName(String name) {
        HashMap<Integer, Student> tmpHM = new HashMap<>();
        for(Student s : studentsDAOHM.values()){
           if(s.getName().equalsIgnoreCase(name))
               tmpHM.put(s.getId(), s);
        }
        return tmpHM;
    }

    @Override
    public Student findById(int id) {
        return studentsDAOHM.get(id) ;
    }

    @Override
    public HashMap<Integer, Student> findAll() {
        return studentsDAOHM;
    }

    @Override
    public boolean deleteStudent(Student student) {
        if(studentsDAOHM.remove(student.getId()) != null)
            return true;
        return false;
    }
}
