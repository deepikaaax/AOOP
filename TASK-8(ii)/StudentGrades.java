import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class StudentGrades {
    private Map<Integer, Set<Integer>> studentGrades;

    public StudentGrades() {
        this.studentGrades = new HashMap<>();
    }

    // Method to add a grade for a student
    public void addGrade(int studentID, int grade) {
        studentGrades.putIfAbsent(studentID, new HashSet<>());
        studentGrades.get(studentID).add(grade);
        System.out.println("Grade " + grade + " added for Student ID: " + studentID);
    }

    // Method to retrieve a student's grades
    public Set<Integer> getGrades(int studentID) {
        return studentGrades.getOrDefault(studentID, new HashSet<>());
    }

    // Method to list all students and their grades
    public void listAllStudents() {
        if (studentGrades.isEmpty()) {
            System.out.println("No student records available.");
        } else {
            System.out.println("Student Grades List:");
            for (Map.Entry<Integer, Set<Integer>> entry : studentGrades.entrySet()) {
                System.out.println("Student ID: " + entry.getKey() + " -> Grades: " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        StudentGrades studentGrades = new StudentGrades();

        // Adding grades
        studentGrades.addGrade(101, 85);
        studentGrades.addGrade(101, 90);
        studentGrades.addGrade(102, 78);
        studentGrades.addGrade(103, 92);
        studentGrades.addGrade(103, 88);
        
        // Retrieving grades
        System.out.println("Grades for Student ID 101: " + studentGrades.getGrades(101));
        
        // Listing all students
        studentGrades.listAllStudents();
    }
}
