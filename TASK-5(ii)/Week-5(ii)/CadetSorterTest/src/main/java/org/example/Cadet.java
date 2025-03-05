import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

class Cadet {

    private List<String> courses = new ArrayList<>();

    public void addCourse(String courseId) {
        courses.add(courseId);
    }

    public void removeCourse(String courseId) {
        courses.remove(courseId);
    }

    private String name;

    public Cadet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class CadetSorter {
    public static void sortCadets(List<Cadet> cadets) {
        Collections.sort(cadets, (c1, c2) -> c1.getName().compareTo(c2.getName()));
    }
}

interface StudentManagement {
    void addStudent(Cadet student);
    void removeStudent(String studentId);
    Cadet getStudent(String studentId);
}

interface CourseManagement {
    void addCourse(Course course);
    void removeCourse(String courseId);
    Course getCourse(String courseId);
}

interface EnrollmentManagement {
    void enrollStudent(String studentId, String courseId);
    void unenrollStudent(String studentId, String courseId);
}

class Course {
    private String courseId;
    private String courseName;
    private List<Cadet> enrolledStudents;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public List<Cadet> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void addStudent(Cadet student) {
        this.enrolledStudents.add(student);
    }

    public void removeStudent(Cadet student) {
        this.enrolledStudents.remove(student);
    }
}

class EnrollmentManager implements EnrollmentManagement {
    private StudentManagement studentManagement;
    private CourseManagement courseManagement;

    public EnrollmentManager(StudentManagement studentManagement, CourseManagement courseManagement) {
        this.studentManagement = studentManagement;
        this.courseManagement = courseManagement;
    }

    @Override
    public void enrollStudent(String studentId, String courseId) {
        Cadet student = studentManagement.getStudent(studentId);
        Course course = courseManagement.getCourse(courseId);
        if (student != null && course != null) {
            student.addCourse(courseId);
            course.addStudent(student);
        }
    }

    @Override
    public void unenrollStudent(String studentId, String courseId) {
        Cadet student = studentManagement.getStudent(studentId);
        Course course = courseManagement.getCourse(courseId);
        if (student != null && course != null) {
            student.removeCourse(courseId);
            course.removeStudent(student);
        }
    }
}

class StudentManager implements StudentManagement {
    private Map<String, Cadet> students;

    public StudentManager() {
        students = new HashMap<>();
    }

    @Override
    public void addStudent(Cadet student) {
        students.put(student.getName(), student);
    }

    @Override
    public void removeStudent(String studentId) {
        students.remove(studentId);
    }

    @Override
    public Cadet getStudent(String studentId) {
        return students.get(studentId);
    }
}

class CourseManager implements CourseManagement {
    private Map<String, Course> courses;

    public CourseManager() {
        courses = new HashMap<>();
    }

    @Override
    public void addCourse(Course course) {
        courses.put(course.getCourseId(), course);
    }

    @Override
    public void removeCourse(String courseId) {
        courses.remove(courseId);
    }

    @Override
    public Course getCourse(String courseId) {
        return courses.get(courseId);
    }
}
