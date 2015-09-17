package com.lits.javaTeamProject.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeDTO {

	private String lastName;
	private String position;
	private String salary;

	@JsonCreator
	public EmployeeDTO(@JsonProperty("lastName") String lastName, @JsonProperty("position") String position,
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeDTO)) return false;

        EmployeeDTO that = (EmployeeDTO) o;

        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        if (salary != null ? !salary.equals(that.salary) : that.salary != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lastName != null ? lastName.hashCode() : 0;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Last Name='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }

}