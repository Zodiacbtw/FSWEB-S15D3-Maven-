package org.example;


import org.example.entity.Employee;

import java.sql.SQLOutput;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        LinkedList<Employee> employeeList = new LinkedList<>();

        employeeList.add(new Employee(1, "Ahmet", "Karaman"));
        employeeList.add(new Employee(2, "Emre", "Şahbaz"));
        employeeList.add(new Employee(1, "Ahmet", "Karaman"));
        employeeList.add(new Employee(3, "Deniz", "Akkan"));
        employeeList.add(new Employee(2, "Emre", "Şahbaz"));

        List<Employee> duplicates = findDuplicates(employeeList);
        System.out.println("Duplicates: " + duplicates);

        Map<Integer, Employee> uniques = findUniques(employeeList);
        System.out.println("Uniques: " + uniques);

        List<Employee> noDuplicates = removeDuplicates(employeeList);
        System.out.println("No Duplicates: " + noDuplicates);
    }

    public static List<Employee> findDuplicates(List<Employee> employeeList) {
        List<Employee> duplicates = new ArrayList<>();
        Set<Employee> seen = new HashSet<>();

        for (Employee employee: employeeList) {
            if (!seen.add(employee)) {
                duplicates.add(employee);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employeeList) {
        Map<Integer, Employee> uniqueEmployees = new HashMap<>();
        Set<Employee> seen = new HashSet<>();

        for (Employee employee : employeeList) {
            if (employee != null && !seen.contains(employee)) {
                seen.add(employee);
                uniqueEmployees.put(employee.getId(), employee);
            }
        }
        return uniqueEmployees;
    }

    public static List<Employee> removeDuplicates(List<Employee> employeeList) {
        Map<Employee, Integer> frequencyMap = new HashMap<>();
        List<Employee> result = new ArrayList<>();

        for (Employee employee : employeeList) {
            if (employee != null) {
                frequencyMap.put(employee, frequencyMap.getOrDefault(employee, 0) + 1);
            }
        }

        for (Employee employee : employeeList) {
            if (employee != null && frequencyMap.get(employee) == 1) {
                result.add(employee);
            }
        }

        return result;
    }
}