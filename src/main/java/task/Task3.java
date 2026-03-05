package task;

import java.util.ArrayList;

public class Task3 {
    public static void solve() {
        var list = getEmployeeList();
        System.out.println(list);
        System.out.println(list.stream().anyMatch(e -> e.getSalary() > 100000));
    }

    private static ArrayList<Employee> getEmployeeList() {
        var employees = new ArrayList<Employee>(7);
        employees.add(new Employee("Bob", 21, "IT", 100000.0));
        employees.add(new Employee("Bill", 25, "IT", 140000.0));
        employees.add(new Employee("Masha", 30, "HR", 123000.0));
        employees.add(new Employee("Tom", 35, "HR", 300000.0));
        employees.add(new Employee("Tim", 28, "IT", 200000.0));
        employees.add(new Employee("Jane", 27, "HR", 160000.0));
        employees.add(new Employee("Alice", 23, "IT", 90000.0));
        return employees;
    }
}