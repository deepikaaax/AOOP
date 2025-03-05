import java.util.*;

interface StudentManagement {
    String getName();
    String getID();
    String getYear();
    void enrollInCourse(CourseManagement course);
}

interface CourseManagement {
    String getCourseID();
    String getCourseName();
    String getDepartment();
    String getSemester();
    void addStudent(StudentManagement student);
}

// 2. Dependency Inversion Principle (DIP) - Good as is

interface Enrollment {
    void enroll(StudentManagement student, CourseManagement course);
}

class EnrollmentManager implements Enrollment {
    @Override
    public void enroll(StudentManagement student, CourseManagement course) {
        student.enrollInCourse(course);
        course.addStudent(student);
    }
}

// 3. Single Responsibility Principle (SRP) - Good as is

class Student implements StudentManagement {
    private String name;
    private String ID;
    private Year year;
    private List<CourseManagement> enrolledCourses; // Store CourseManagement objects

    public Student(String name, String ID, Year year) {
        this.name = name;
        this.ID = ID;
        this.year = year;
        this.enrolledCourses = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public String getYear() {
        return year.getYear();
    }

    @Override
    public void enrollInCourse(CourseManagement course) {
        enrolledCourses.add(course); // Add the CourseManagement object directly
    }

    public List<CourseManagement> getEnrolledCourses() {
        return enrolledCourses;
    }
}

class Year {
    private String yearString;

    public Year(String yearString) {
        this.yearString = yearString;
    }

    public String getYear() {
        return yearString;
    }
}

// 4. Open/Closed Principle (OCP) - Good as is

abstract class Course implements CourseManagement {
    private String courseID;
    private String courseName;
    private String department;
    private String semester;
    private List<StudentManagement> enrolledStudents; // Store StudentManagement objects

    public Course(String courseID, String courseName, String department, String semester) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.department = department;
        this.semester = semester;
        this.enrolledStudents = new ArrayList<>();
    }

    @Override
    public String getCourseID() {
        return courseID;
    }

    @Override
    public String getCourseName() {
        return courseName;
    }

    @Override
    public String getDepartment() {
        return department;
    }

    @Override
    public String getSemester() {
        return semester;
    }

    @Override
    public void addStudent(StudentManagement student) {
        enrolledStudents.add(student); // Add the StudentManagement object directly
    }

    public List<StudentManagement> getEnrolledStudents() {
        return enrolledStudents;
    }
}

class RegularCourse extends Course {
    public RegularCourse(String courseID, String courseName, String department, String semester) {
        super(courseID, courseName, department, semester);
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Deepika", "2320030328", new Year("2nd year"));
        Course course = new RegularCourse("23CS2103R", "Advanced Object Oriented Programming", "CSE", "Even Sem");

        Enrollment enrollmentManager = new EnrollmentManager();
        enrollmentManager.enroll(student, course);

        System.out.println("STUDENT DETAILS : ");
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student ID: " + student.getID());
        System.out.println("Student Year: " + student.getYear());

        System.out.print("Enrolled Courses for " + student.getName() + ": ");
        for (CourseManagement enrolledCourse : student.getEnrolledCourses()) {
            System.out.print(enrolledCourse.getCourseID() + "-" + enrolledCourse.getCourseName() + ", "); // Access course details
        }
        System.out.println(); // Newline for cleaner output

        System.out.println("COURSE DETAILS : ");
        System.out.println("Course Name: " + course.getCourseName());
        System.out.println("Course ID: " + course.getCourseID());
        System.out.println("Course Department: " + course.getDepartment());
        System.out.println("Course Semester: " + course.getSemester());

        System.out.print("Enrolled Students in " + course.getCourseName() + ": ");
        for (StudentManagement enrolledStudent : course.getEnrolledStudents()) {
            System.out.print(enrolledStudent.getName() + " (" + enrolledStudent.getID() + "), "); // Access student details
        }
        System.out.println(); // Newline for cleaner output
    }
}