import java.util.ArrayList;
import java.util.List;

public class School {
    private List<Student> students;

    School() {
        students = new ArrayList<>();
    }

    public void addStudent(Student students) {
        this.students.add(students);
    }

    public List<Student> getStudents() {
        return students;
    }
    // Other methods like getStudents(), removeStudent(), etc.    
}