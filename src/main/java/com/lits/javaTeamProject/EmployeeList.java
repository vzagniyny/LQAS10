package com.lits.teamWork;

public class EmployeeList {

	private String lastName;
	private String position;
	private String salary;

	public EmployeeList(String lastName, String position, String salary) {
		this.lastName = lastName;
		this.position = position;
		this.salary = salary;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPosition() {
		return position;
	}

	public String getSalary() {
		return salary;
	}

}
