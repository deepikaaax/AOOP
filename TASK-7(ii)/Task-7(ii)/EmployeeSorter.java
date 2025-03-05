import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeSorter {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice Johnson", "Sales", 60000));
        employees.add(new Employee(102, "Bob Williams", "Marketing", 75000));
        employees.add(new Employee(103, "Charlie Davis", "Engineering", 90000));
        employees.add(new Employee(104, "David Rodriguez", "Sales", 65000));
        employees.add(new Employee(105, "Eve Martinez", "Marketing", 80000));
        employees.add(new Employee(106, "Frank Lee", "Engineering", 85000));


        System.out.println("Unsorted Employees:");
        printEmployees(employees);

        Collections.sort(employees, Comparator.comparingDouble(Employee::getSalary));
        System.out.println("\nSorted by Salary (Ascending):");
        printEmployees(employees);

        Collections.sort(employees, Comparator.comparingDouble(Employee::getSalary).reversed());
        System.out.println("\nSorted by Salary (Descending):");
        printEmployees(employees);

        Collections.sort(employees, Comparator.comparing(Employee::getName));
        System.out.println("\nSorted by Name:");
        printEmployees(employees);

        Collections.sort(employees, Comparator.comparing(Employee::getDepartment));
        System.out.println("\nSorted by Department:");
        printEmployees(employees);

        Collections.sort(employees, Comparator.comparing(Employee::getDepartment)
                                          .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed()));

        System.out.println("\nSorted by Department then Salary (Descending):");
        printEmployees(employees);
    }

    private static void printEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}