package com.lits.javaTeamWork;

public class Workers {
	private String lastName;
	 private String position;
	 private String salary;

	 public Workers(String lastName, String position, String salary) {
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