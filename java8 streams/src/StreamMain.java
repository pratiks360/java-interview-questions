import java.util.*;
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
//        filterStudentBySubject(school);
//        averageGrade(school);
//        sortStudentBasedOnGradesApproach2(school);
//        studentWithHigestGrade(school);
        groupByStudentAge(school);
    }


    public static void filterStudentBySubject(School school) {
        String subjectName = "Math";
        List<Student> filteredStudents = school.getStudents().stream().filter(student -> student.getSubjects().stream()
                .anyMatch(t -> t.getName().equalsIgnoreCase(subjectName))).collect(Collectors.toList());


        Optional<Student> a = school.getStudents().stream().filter(student -> student.getName().equalsIgnoreCase("alice")).findFirst();
        System.out.println(a.get().getAge());
        for (Student student : filteredStudents) {
            System.out.println(student.getName());
        }
    }

    public static void averageGrade(School school) {
        double averageGrade = school.getStudents()
                .stream()
                .flatMap(student -> student.getSubjects().stream())
                .mapToInt(Subject::getGrade)
                .average()
                .orElse(0.0);

        System.out.println("Average Grade :  " + averageGrade);
    }

    public static void sortStudentBasedOnGradesApproach1(School school) {
        List<Student> sortedStudents = school.getStudents()
                .stream()
                .sorted(Comparator.comparingDouble(Student::calculateAverageGrade))
                .collect(Collectors.toList());

        for (Student student : sortedStudents) {
            System.out.println(student.getName() + " - Average Grade: " + student.getAverageGrade());
        }
    }

    public static void sortStudentBasedOnGradesApproach2(School school) {
        List<Student> sortedStudents = school.getStudents()
                .stream().sorted(Comparator.comparingDouble(student -> student.getSubjects().stream().mapToInt(Subject::getGrade).average().orElse(0.0))).collect(Collectors.toList());

        for (Student student : sortedStudents) {
            System.out.println(student.getName() + " - Average Grade: " + student.getAverageGrade());
        }
    }

    public static void studentWithHigestGrade(School school) {

        Optional<Student> highestGradeStudent = school.getStudents().stream().max(Comparator.comparingDouble(s -> s.getSubjects().stream()
                .mapToDouble(Subject::getGrade).max().orElse(0.0)));

        System.out.println(highestGradeStudent.get().getSubjects().stream().mapToDouble((Subject::getGrade)).max());
    }

    public static void groupByStudentAge(School school) {

        Map<Integer, List<Student>> grouped = school.getStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getAge,
                        () -> new TreeMap<>(Collections.reverseOrder()),
                        Collectors.toList()));

        grouped.forEach((age, students) ->
                System.out.println(age));
    }


}