package Week_11;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Class: Main2_KevinF
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
public class Main2 {
    public static void main(String[] args) {
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.add(new Employee("Ana Joo", 2000, 10));
        list.add(new Employee("Joe Jomey", 5000, 3));
        list.add(new Employee("Gene Samu", 2800, 1));
        list.add(new Employee("Joana Sick", 4000, 5));
        list.add(new Employee("Emma Emm", 2300, 5));
        list.add(new Employee("Emile Assis", 2000, 10));
        list.add(new Employee("Erik John", 4100, 10));

        Collections.sort(list);

        System.out.println("Employees after sorting by yearsInService and then by salaries: ");
        for (Employee emp : list) {
            System.out.println("Name: " + emp.getName() + ". Salary: " +
                    emp.getSalary() + ". Years in Service: " +
                    emp.getYearsInService());
        }
    }
}
