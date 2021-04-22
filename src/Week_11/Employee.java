package Week_11;

/**
 * Class: Employee
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: 3/30/2021
 * <p>
 * This class: now describe what the class does
 * <p>
 * Purpose: Describe the purpose of this class
 */

class Employee implements Comparable<Employee> {
    private String name;
    private int salary;
    private int yearsInService;

    // Constructor
    public Employee(String nm, int rt, int yr) {
        this.name = nm;
        this.salary = rt;
        this.yearsInService = yr;
    }

    // Getter methods for accessing private data
    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public int getYearsInService() {
        return yearsInService;
    }

    // Used to sort employees by year then rank
    public int compareTo(Employee m) {
        if (m.yearsInService == this.yearsInService) {
            return m.salary - this.salary;
        } else {
            return m.yearsInService - this.yearsInService;
        }
    }
}
