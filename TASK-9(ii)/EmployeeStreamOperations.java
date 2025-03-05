import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    private String department;
    private double salary;

    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age +
               ", department='" + department + "', salary=" + salary + "}";
    }
}

public class EmployeeStreamOperations {
    public static void main(String[] args) {
        // List of Employees
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, "HR", 50000),
            new Employee("Bob", 25, "IT", 60000),
            new Employee("Charlie", 35, "Finance", 70000),
            new Employee("David", 40, "IT", 80000),
            new Employee("Eve", 28, "HR", 55000)
        );

        // 1. Filtering employees by Department (IT)
        System.out.println("Employees in IT Department:");
        employees.stream()
                 .filter(emp -> emp.getDepartment().equalsIgnoreCase("IT"))
                 .forEach(System.out::println);

        // 2. Sorting employees by their names
        System.out.println("\nEmployees sorted by Name:");
        employees.stream()
                 .sorted(Comparator.comparing(Employee::getName))
                 .forEach(System.out::println);

        // 3. Find the employee with the highest salary
        Optional<Employee> highestPaid = employees.stream()
                                                  .max(Comparator.comparing(Employee::getSalary));
        highestPaid.ifPresent(emp -> System.out.println("\nHighest Paid Employee: " + emp));

        // 4. Calculate the average salary of employees
        double averageSalary = employees.stream()
                                        .mapToDouble(Employee::getSalary)
                                        .average()
                                        .orElse(0.0);
        System.out.println("\nAverage Salary of Employees: " + averageSalary);
    }
}
