package com.lits.javaTeamProject.dto;

public class Employee {
    private String lastName;
    private String position;
    private String salary;

    public Employee(String lastName, String position, String salary) {
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public String getSalary() {
        return salary;
    }


}