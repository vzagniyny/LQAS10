package com.lits.javaTeamProject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkersDTO {

	private String lastName;
	private String position;
	private String salary;

	@JsonCreator
	public WorkersDTO(@JsonProperty("lastName") String lastName, @JsonProperty("position") String position,
			@JsonProperty("salary") String salary) {
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