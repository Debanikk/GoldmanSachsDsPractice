package com.wildfire.GoldmanSachsDsPractice.MapReduceFilterPractice;

public class Employee {
    private String name;
    private String id;
    private double salary;
    private int yearOfJoining;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public Employee(String name, String id, double salary, int yearOfJoining) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.yearOfJoining = yearOfJoining;
    }
}
