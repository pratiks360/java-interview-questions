import java.util.ArrayList;
import java.util.List;
public class Student {
    private String name;
    private int age;
    private List<Subject> subjects;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        subjects = new ArrayList<>();
    }

    public void addSubject(String subjectName, int grade) {
        Subject subject = new Subject(subjectName, grade);
        subjects.add(subject);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public List<Subject> getSubjects() {
        return subjects;
    }
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}