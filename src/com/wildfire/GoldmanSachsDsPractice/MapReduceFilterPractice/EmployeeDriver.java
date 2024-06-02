package com.wildfire.GoldmanSachsDsPractice.MapReduceFilterPractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeDriver {
    public static void main(String[] args){

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("Debanik Kundu", "1", 200000.00, 2011));
        employeeList.add(new Employee("Payal Nath", "2", 201000.00, 2019));
        employeeList.add(new Employee("Rudra Pasad", "3", 250000.00, 2012));
        employeeList.add(new Employee("Pradosh Mitter", "4", 230000.00, 2015));
        employeeList.add(new Employee("Lalmohan Ganguly", "5", 267000.00, 2014));
        employeeList.add(new Employee("Tapesh Mitter", "6", 50000.00, 2013));
        employeeList.add(new Employee("Satyajit Ray", "7", 100000.00, 2011));
        employeeList.add(new Employee("Byomkesh Bakshi", "8", 76000.00, 2011));
        employeeList.add(new Employee("Ajit Banerjee", "9", 30000.00, 2004));
        employeeList.add(new Employee("Hemangini Hazra", "10", 140000.00, 2021));
        employeeList.add(new Employee("Aditya purakait", "11", 7000.00, 2015));
        employeeList.add(new Employee("Nelson Mandela", "12", 2000.00, 2006));
        employeeList.add(new Employee("Mamata Banerjee", "13", 450000.00, 2009));
        employeeList.add(new Employee("Madan Mitra", "14", 800000.00, 2012));
        employeeList.add(new Employee("Goru Chor", "15", 2300.00, 2015));
        employeeList.add(new Employee("Partha Dhyamna", "16", 37500.00, 2014));
        employeeList.add(new Employee("Arpita Sukumari", "17", 56000.00, 2013));

        List<String> salaryRangedEmployee = employeeList.stream()
                .filter(x -> x.getSalary()> 30000)
                .map(x -> x.getName())
                .collect(Collectors.toList());
        salaryRangedEmployee.stream().forEach(System.out::println);

        //Putting values in Map
        Map<String, String> employeeMap = employeeList.stream().filter(x -> x.getSalary() > 35000).collect(Collectors.toMap(x -> x.getId(), x -> x.getName()));
        for (String emp :  employeeMap.values()) {
            System.out.println(emp);
        };

        //Complex collect Map operation
        Map<Integer, Long> newMap =  employeeList.stream().collect(Collectors.groupingBy(Employee::getYearOfJoining, Collectors.counting()));

        for (Integer emp :  newMap.keySet()) {
            String key = emp.toString();
            String value = newMap.get(emp).toString();
            System.out.println("Count of employees based on joining year: " + key + " -> " + value);
        };

        Integer countOfEmployees = employeeList.stream()
                .filter(x -> x.getYearOfJoining() == 2014)
                .map(x -> x.getYearOfJoining())
                .reduce(0, (employee1, employee2) -> employee1 + employee2);
        System.out.println("Employee in 2014 joinee count is: " + countOfEmployees);
        Long countOfEmployees2 = employeeList.stream().filter(x -> x.getYearOfJoining() == 2014).count();
        System.out.println("Employee in 2014 joinee count is: " + countOfEmployees2);

        Employee higestSal = employeeList.stream().max(Comparator.comparing(Employee::getSalary)).get();
    }
}
