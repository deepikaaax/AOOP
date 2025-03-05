import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.function.Predicate;

class Employee {
    String name;
    int age;
    int experience;
    double salary;

    public Employee(String name, int age, int experience, double salary) {
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + 
               ", experience=" + experience + " years, salary=" + salary + "}";
    }
}

public class CoffeeShopSalary {
    public static void main(String[] args) {
        // PriorityQueue to store employees sorted by experience (highest first)
        PriorityQueue<Employee> employeeQueue = new PriorityQueue<>(Comparator.comparingInt(e -> -e.experience));

        // Adding employees to the queue
        employeeQueue.add(new Employee("Alice", 30, 5, 50000));
        employeeQueue.add(new Employee("Bob", 28, 4, 45000));
        employeeQueue.add(new Employee("Charlie", 25, 3, 40000));
        employeeQueue.add(new Employee("David", 22, 1, 35000));
        employeeQueue.add(new Employee("Eve", 21, 0, 30000));

        // Predicate to filter employees with more than 2 years of experience
        Predicate<Employee> bonusEligibility = e -> e.experience > 2;

        System.out.println("Salary Distribution (With Bonus for Eligible Employees):");
        while (!employeeQueue.isEmpty()) {
            Employee emp = employeeQueue.poll();
            if (bonusEligibility.test(emp)) {
                emp.salary += 5000; // Adding bonus
                System.out.println(emp.name + " received a bonus! New Salary: " + emp.salary);
            } else {
                System.out.println(emp.name + " received salary: " + emp.salary);
            }
        }
    }
}
