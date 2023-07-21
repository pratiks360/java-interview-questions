import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Student student1 = new Student("John", 20);
        student1.addSubject("Math", 90);
        student1.addSubject("Science", 85);

        Student student2 = new Student("Alice", 22);
        student2.addSubject("Science", 95);
        student2.addSubject("History", 80);

        Student student3 = new Student("Bob", 21);
        student3.addSubject("Math", 92);
        student3.addSubject("History", 75);

        // Create School and add students
        School school = new School();
        school.addStudent(student1);
        school.addStudent(student2);
        school.addStudent(student3);
        filterStudentBySubject(school);
    }


    public static void filterStudentBySubject(School school) {
        String subjectName = "Math";
        List<Student> filteredStudents = school.getStudents().stream().filter(student -> student.getSubjects().stream()
                .anyMatch(t -> t.getName().equalsIgnoreCase(subjectName))).collect(Collectors.toList());

        for (Student student : filteredStudents) {
            System.out.println(student.getName());
        }
    }
}